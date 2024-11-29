package Furkan.week12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseApp2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }


    public static void addCity(String city) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "Furkan", "furkan");

        PreparedStatement ps = connection.prepareStatement("insert into city (Name, Country, Province) value (?, ?, ?)");

        ps.setString(1, city);
        ps.setString(2, "A");
        ps.setString(3, "Vorarlberg");

        ps.execute();

        ps.close();
    }

    public static void updateCity(String country, String city) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "Furkan", "furkan");
        PreparedStatement ps = connection.prepareStatement("update city set country = ? where name = ?");

        ps.setString(1, country);
        ps.setString(2, city);

        ps.execute();
        ps.close();
    }

    public static void deleteCity(String city) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "Furkan", "furkan");
        PreparedStatement ps = connection.prepareStatement("delete city from city where name = ?");

        ps.setString(1, city);

        ps.execute();
        ps.close();
    }





}
