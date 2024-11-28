package Gyula.week11;

import Gyula.ConsoleTools;

import java.sql.*;
import java.util.Scanner;

public class DatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the country: ");
        String countryName = scanner.nextLine();

        int minPopulation = ConsoleTools.readNumber("Min Population", 1, 99999999);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=gyula&password=gyula");
            PreparedStatement ps = conn.prepareStatement("""
SELECT ci.*
FROM city ci
JOIN country co on ci.country = co.code
WHERE co.name = ? AND ci.Population > ?
            """);

            ps.setString(1, countryName);
            ps.setInt(2, minPopulation);
            ResultSet rs = ps.executeQuery();
            printResultSet(rs);

            // Close everything
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }

        for (int column = 1; column <= metaData.getColumnCount() ; column++) {
            System.out.printf("| %-" + optimalColumnWidth[column] + "s ",
                    metaData.getColumnLabel(column));
        }
        System.out.println("|");
        while (rs.next()){
            for (int column = 1; column <= metaData.getColumnCount() ; column++) {
                if (metaData.getColumnType(column) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[column] + "s ", rs.getString(column));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[column] + "s ", rs.getString(column));
                }
            }
            System.out.println("|");
        }
    }
}
