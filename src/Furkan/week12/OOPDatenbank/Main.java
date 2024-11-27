package Furkan.week12.OOPDatenbank;

import java.sql.*;

public class Main {
    public static void main(String[] args) {


        Mondial mondial = new Mondial();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=Furkan&password=furkan");
            PreparedStatement ps = connection.prepareStatement("""
                    SELECT * FROM country
                    """);

            ResultSet rs = ps.executeQuery();
            processCountries(mondial, rs);

            rs.close();
            ps.close();
            connection.close();

        }catch (SQLException e){

        }

    }

    private static void processCountries(Mondial mondial, ResultSet rs) {
    }
}
