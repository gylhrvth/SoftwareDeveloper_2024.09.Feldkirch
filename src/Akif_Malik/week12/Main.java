package Akif_Malik.week12;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException{
        IMDB imdb = new IMDB();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/series","root","root");

        readFromDatabaseActor(con, imdb);
        readFromDBFilmList(con, imdb);

        // TODO: Connect DB, SELECT FROM TABLE, Initialize the Object in Java
    }

    public static void readFromDBFilmList(Connection connection, IMDB imdb) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("select * from film");

        ResultSet rs = ps.executeQuery();
        processFilm(rs, imdb);

        rs.close();
        ps.close();
    }

    public static void processFilm(ResultSet rs, IMDB imdb) throws SQLException {
        while (rs.next()) {
            Film f = new Film(
                    rs.getInt("ID"),
                    rs.getString("Title")
            );
            Actor regie = imdb.getActorbyId(rs.getInt("Regie"));
            if (regie != null){
                f.setRegie(regie);
            }
            imdb.addFilm(f);
        }
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