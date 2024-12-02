package Thiemo.week11;

import Sandro.Colors;

import java.sql.*;
import java.util.Scanner;

public class crudexample {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
//        System.out.println("City name ?");
//        String city = sc.nextLine();
//
//        System.out.println("Set Population");
//        int Pop = sc.nextInt();

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=Thiemo&password=thiemo");

//        Create(connection,city);
        printQuerry();       // Read
        System.out.println();

//        Update(connection, city, Pop);
        printQuerry();      // Read
        System.out.println();

//        Delete(connection, city);
        printQuerry();     //
        System.out.println();
        connection.close();
    }

    public static void Create(Connection connection, String city) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Insert into City(Name, Country, Province) values (?, ? ,?)");

        ps.setString(1, city);
        ps.setString(2, "A");
        ps.setString(3, "Vorarlberg");


        ps.execute();
        ps.close();

    }


    public static void printQuerry() {

        try {
            Connection connenction = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=Thiemo&password=thiemo");
            // Connection connenction = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "Thiemo", "thiemo");


            PreparedStatement ps = connenction.prepareStatement("""
                    select * from city ci
                    join country c on ci.country = c.code
                    where c.name = ? 
                    order by ci.province desc
                    
                    """);

            ps.setString(1, "Austria");
            ResultSet rs = ps.executeQuery();
            printResultSetakaRead(rs);

            //Close Everything
            rs.close();
            ps.close();
            connenction.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void printResultSetakaRead(ResultSet rs) throws SQLException {

        // headliner from Datenbank

        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }


        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            System.out.printf(Colors.BACKGROUND_COLORS[5]+ "| %-" + optimalColumnWidth[column] + "s",
                    metaData.getColumnLabel(column));
//                    metaData.getColumnTypeName(column),
//                    metaData.getColumnDisplaySize(column));


        }
        System.out.println("|"+Colors.RESET);

        // Daten von Datenbank

        while (rs.next()) {
            String lineColor = (rs.getRow() % 2 == 0) ? "\u001B[47m" : "\u001B[40m"; // White and Black backgrounds
            String resetColor = "\u001B[0m";
            for (int column = 1; column <= rs.getMetaData().getColumnCount(); column++) {
                System.out.print(lineColor);
                if (metaData.getColumnType(column) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[column] + "s", rs.getString(column));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[column] + "s", rs.getString(column));
                }
            }
            System.out.println("|"+resetColor);
        }
    }


    public static void Update(Connection connection, String city, int Pop) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Update city ci set ci.population = ? where ci.name = ?");

        ps.setInt(1, Pop);
        ps.setString(2, city);
        ps.execute();
        ps.close();
    }

    public static void Delete(Connection connection, String city) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("Delete from city where city.name = ?");

        ps.setString(1, city);

        ps.execute();
        ps.close();
    }
}
