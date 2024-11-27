package Erik.week11;

import Erik.week05.TicTacToe_Edited;
import Gyula.ConsoleTools;

import java.sql.*;
import java.util.Scanner;

public class DatabaseApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Give me a Country:\n>> ");
        String countryName = sc.nextLine();
        int minPopulation = TicTacToe_Edited.controlUserInput("Min. Einwohnerzahl eingeben:", 1,999999999);

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=erik&password=erik");
            PreparedStatement ps = conn.prepareStatement("""
                    select ci.*
                    from city ci
                    join country co on ci.country = co.code
                    where co.name = ? and ci.Population > ?
                    """);

            ps.setString(1, countryName);
            ps.setInt(2, minPopulation);
            ResultSet rs = ps.executeQuery();
            printResult(rs);

            // Close everything (for Performance)
            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printResult(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = getOptimalColumnWidth(rs);

        printHeader(metaData, optimalColumnWidth);

        // Print Body
        while (rs.next()) {
            for (int column = 1; column <= metaData.getColumnCount(); column++) {
                if (metaData.getColumnType(column) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[column] + "s ", rs.getString(column));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[column] + "s ", rs.getString(column));
                }
            }
            System.out.println("|");
        }
    }

    public static int[] getOptimalColumnWidth(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];

        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }
        return optimalColumnWidth;
    }

    public static void printHeader(ResultSetMetaData metaData, int[] optimalColumnWidth) throws SQLException {
        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            System.out.printf("| %-" + optimalColumnWidth[column] + "s ", metaData.getColumnLabel(column),
                    metaData.getColumnLabel(column));
        }
        System.out.println("|");
    }

}



