package Gyula.week11.OOPdatanbank;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Mondial mondial = new Mondial();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=gyula&password=gyula");

            readFromDatabaseCountry(mondial, conn);
            readFromDatabaseCity(mondial, conn);

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(mondial);
    }

    public static void readFromDatabaseCountry(Mondial mondial, Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("""
SELECT * FROM country
            """);

        ResultSet rs = ps.executeQuery();
        processCountries(mondial, rs);

        // Close everything
        rs.close();
        ps.close();
    }


    public static void processCountries(Mondial mondial, ResultSet rs) throws SQLException{
        while (rs.next()){
           Country c = new Country(
                   rs.getString("name"),
                   rs.getString("code"),
                   rs.getString("capital"),
                   rs.getString("province"),
                   rs.getFloat("area"),
                   rs.getInt("population")
           );
           mondial.addCountry(c);
        }
    }

    public static void readFromDatabaseCity(Mondial mondial, Connection conn) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("""
SELECT * FROM city
            """);

        ResultSet rs = ps.executeQuery();
        processCities(mondial, rs);

        // Close everything
        rs.close();
        ps.close();
    }

    public static void processCities(Mondial mondial, ResultSet rs) throws SQLException{
        while (rs.next()){
            City c = new City(
                    rs.getString("name"),
                    rs.getString("province"),
                    rs.getInt("population"),
                    rs.getFloat("Longitude"),
                    rs.getFloat("latitude")
            );
            c.setCountryByCode(mondial, rs.getString("country"));
        }
    }
}
