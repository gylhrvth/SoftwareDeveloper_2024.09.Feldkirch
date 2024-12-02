package Thiemo.week12;


import Gyula.week11.OOPdatanbank.City;

import java.sql.*;

public class Main {
    public static void main(String[] args) {


        // TODO: Connect DB, SELECT FROM TABLE, Initialize the Object in Java
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TVSeries", "Thiemo", "thiemo");

            readFromDatabaseFilm(connection);
            readFromDatabaseActor(connection);


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO: Create a function for printStructure()

    }

    public static void readFromDatabaseFilm(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("""
                SELECT * FROM film
                """);

        ResultSet rs = ps.executeQuery();
        processFilm(rs);

        // Close everything
        rs.close();
        ps.close();
    }

    public static void processFilm(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Film f = new Film(
                    rs.getInt("ID"),
                    rs.getString("Title")

            );

        }
    }

    public static void readFromDatabaseActor(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("""
                SELECT * FROM actor
                """);

        ResultSet rs = ps.executeQuery();
        processActor(rs);

        // Close everything
        rs.close();
        ps.close();
    }

    public static void processActor(ResultSet rs) throws SQLException {
        while (rs.next()) {
            Actor actor = new Actor(
                    rs.getInt("ID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("age"),
                    rs.getInt("weight"),
                    rs.getInt("height")
            );

        }
    }
}
