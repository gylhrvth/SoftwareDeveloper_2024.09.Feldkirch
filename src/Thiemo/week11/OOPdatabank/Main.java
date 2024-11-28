package Thiemo.week11.OOPdatabank;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Mondial mondial = new Mondial();

        try {
            Connection connenction = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=Thiemo&password=thiemo");

            readFromtablesCountry(connenction, mondial);
            readFromtablesCity(connenction, mondial);
            connenction.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(mondial);
    }

    public static void readFromtablesCountry(Connection connection, Mondial mondial) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("""
                SELECT * FROM country
                """);
//            ps.setString(1,countryName);
//            ps.setInt(2,minPop);
        ResultSet rs = ps.executeQuery();
        processCountries(mondial, rs);
        //Close Everything
        rs.close();
        ps.close();
    }

    public static void readFromtablesCity(Connection connection, Mondial mondial) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("""
                SELECT * FROM city
                """);
//            ps.setString(1,countryName);
//            ps.setInt(2,minPop);
        ResultSet rs = ps.executeQuery();
        processCity(mondial, rs);
        //Close Everything
        rs.close();
        ps.close();
    }

    public static void processCountries(Mondial mondial, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Country c = new Country(rs.getString("name"),
                    rs.getString("code"),
                    rs.getString("capital"),
                    rs.getString("province"),
                    rs.getFloat("area"),
                    rs.getInt("Population")
            );

            mondial.addCountry(c);

        }
    }

    public static void processCity(Mondial mondial, ResultSet rs) throws SQLException {
        while (rs.next()) {
            City ci = new City(rs.getString("name"),
                    rs.getString("province"),
                    rs.getInt("population"),
                    rs.getFloat("longitude"),
                    rs.getFloat("latitude")
            );
            ci.setCountryByCode(mondial, rs.getString("country"));
        }
    }
}
