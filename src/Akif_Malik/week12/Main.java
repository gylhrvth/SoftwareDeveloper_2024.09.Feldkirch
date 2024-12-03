package Akif_Malik.week12;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        IMDB imdb = new IMDB();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/series","root","root");

        showQuerry();
        // TODO: Connect DB, SELECT FROM TABLE, Initialize the Object in Java

    }

    public static void readFromDBFilmList(Connection connection, IMDB imdb) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from film");

        ResultSet rs = ps.executeQuery();

        rs.close();
        ps.close();
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
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

    public static void showQuerry() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/series","root","root");

        PreparedStatement ps = con.prepareStatement("""
                    select * 
                    from Actor
            """);


        ResultSet resultSet = ps.executeQuery();
        printResultSet(resultSet);
        resultSet.close();
        ps.close();
        con.close();
    }

}
