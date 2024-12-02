package Thiemo.week12;


import java.sql.*;

public class Main {
    public static void main(String[] args) {
        IMDB imdb = new IMDB();

        // TODO: Connect DB, SELECT FROM TABLE, Initialize the Object in Java
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TVSeries", "gyula", "gyula");

            readFromDatabaseActor(connection, imdb);
            readFromDatabaseFilm(connection, imdb);


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // TODO: Create a function for printStructure()

    }

    public static void readFromDatabaseFilm(Connection conn, IMDB imdb) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("""
                SELECT * FROM film
                """);

        ResultSet rs = ps.executeQuery();
        processFilm(rs, imdb);

        // Close everything
        rs.close();
        ps.close();
    }

    public static void processFilm(ResultSet rs, IMDB imdb) throws SQLException {
        while (rs.next()) {
            Film f = new Film(
                    rs.getInt("ID"),
                    rs.getString("Title")
            );
            Actor regie = imdb.getActorByID(rs.getInt("Regie"));
            if (regie != null){
                f.setRegie(regie);
            }
            imdb.addFilm(f);
        }
    }

    public static void readFromDatabaseActor(Connection conn, IMDB imdb) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("""
                SELECT * FROM actor
                """);

        ResultSet rs = ps.executeQuery();
        processActor(rs, imdb);

        // Close everything
        rs.close();
        ps.close();
    }

    public static void processActor(ResultSet rs, IMDB imdb) throws SQLException {
        while (rs.next()) {
            Actor actor = new Actor(
                    rs.getInt("ID"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("age"),
                    rs.getInt("weight"),
                    rs.getInt("height")
            );
            imdb.addActor(actor);
        }
    }
}
