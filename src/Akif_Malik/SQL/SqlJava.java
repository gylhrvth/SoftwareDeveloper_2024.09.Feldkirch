package Akif_Malik.SQL;

import java.sql.*;
import java.util.Scanner;

public class SqlJava {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        simulateNormalDay();
    }

    public static void addCity(String city) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial","root","root");

        PreparedStatement ps = con.prepareStatement("insert into city (Name, Country, Province) value (?, ?, ?) ");

        ps.setString(1, city);
        ps.setString(2, "A");
        ps.setString(3, "Vorarlberg");

        ps.execute();

        ps.close();
    }

    public static void updatecity(String city, String country) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial","root","root");

        PreparedStatement ps = con.prepareStatement("update city set country = ? where name = ?");

        ps.setString(1, country);
        ps.setString(2, city);

        ps.execute();
        ps.close();
    }

    public static void deleteCity(String city) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial","root","root");

        PreparedStatement ps = con.prepareStatement("delete city from city where name = ?");

        ps.setString(1, city);
        ps.execute();
        ps.close();

    }

    public static void simulateNormalDay() throws SQLException{
        showQuerry();

        System.out.println("Add a City to the List!");
        String userInput = sc.nextLine();
        addCity(userInput);
        System.out.println("City " + userInput + " has been added to the list!");

        System.out.println("Update a cities Country!");
        String city = sc.nextLine();
        String country = sc.nextLine();
        updatecity(city, country);
        System.out.println("City " + city + " has been updated!");

        System.out.println("Delete a city from the List!");
        String userInput3 = sc.nextLine();
        deleteCity(userInput3);
        System.out.println("City " + userInput3 + " has been deleted from the list! ");

        System.out.println("Changes have been made succesfully!");
    }

    public static void showQuerry() throws SQLException {
        System.out.println("Choose a Country to work on!");
        String country = sc.nextLine();

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial","root","root");

        PreparedStatement ps = con.prepareStatement("""
                    select *
                    from city
                    join country on country.code = city.country
                    where country.name = ? 
            """);

        ps.setString(1, country);


        ResultSet resultSet = ps.executeQuery();
        printResultSet(resultSet);
        resultSet.close();
        ps.close();
        con.close();
    }

    public static void printResultSet(ResultSet rs) throws SQLException{
        ResultSetMetaData meta = rs.getMetaData();
        for (int i = 1; i <= meta.getColumnCount(); i++) {
            System.out.printf("| %-24s ", meta.getColumnLabel(i));
        }
        System.out.println(" |");
        while (rs.next()){
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                System.out.printf("| %-24s ", rs.getString(i));
            }
            System.out.println("|");
        }
    }
}
