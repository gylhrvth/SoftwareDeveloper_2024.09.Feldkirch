package Aylin.week11.Crud;

import Sandro.Colors;

import java.sql.*;
import java.util.Scanner;

public class CrudExample {
    public static void main(String[] args) {
        try{
//            addCity();
            printTable();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void addCity() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the city: ");
        String cityName = scanner.nextLine();
//        System.out.print("Enter the Code of the country: ");
//        String countryCode = scanner.nextLine();
//        System.out.print("Enter the Province of the city: ");
//        String province = scanner.nextLine();


        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "aylin", "aylin");
        PreparedStatement ps = conn.prepareStatement("Insert into city (Name, Country, Province) values (?, ?, ?)");

        ps.setString(1, cityName);
        ps.setString(2, "A");
        ps.setString(3, "Vorarlberg");

        ps.execute();

        ps.close();
        conn.close();
    }

    public static void printTable() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "aylin", "aylin");
        PreparedStatement ps = connection.prepareStatement(
                """                                                                              
                SELECT DISTINCT ci.*
                FROM city ci
                JOIN country co on co.code = ci.country
                WHERE co.name = ?
                """);
        ps.setString(1, "Austria");
        ResultSet rs = ps.executeQuery();                                                                                                       // executeQuery: die Ausführung unserer Anweisung (z.B. run in Java)

        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }
        for (int col = 1; col <= metaData.getColumnCount(); col++) {
            System.out.printf(Aylin.Colors.getBackgroundColor(131, 139, 139) + "| %-" + optimalColumnWidth[col] + "s " , metaData.getColumnLabel(col));
        }
        System.out.println("|" + Colors.RESET);

        int oddRow = 0;
        while (rs.next()) {
            oddRow++;
            if(oddRow%2 == 0){
                System.out.print(Aylin.Colors.getBackgroundColor(72,61,139));
            }else{
                System.out.print(Aylin.Colors.getBackgroundColor(229, 229, 229));
            }
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                if (metaData.getColumnType(col) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[col] + "s ", rs.getString(col));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[col] + "s ", rs.getString(col));
                }
            }
            System.out.println("|" + Colors.RESET);
        }
        rs.close();
        ps.close();
        connection.close();
    }
}
