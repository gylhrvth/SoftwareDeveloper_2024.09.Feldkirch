package Thiemo.week12;

import java.sql.*;
import java.util.Scanner;

public class DBManager {
    public Scanner sc = new Scanner(System.in);
    private static DBManager instance = null;

    private DBManager() {
        // ...
    }

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/TVSeries", "Thiemo", "thiemo");

    }


    // TODO: Create a function for printStructure()

    public void readFromDatabaseFilm(IMDB imdb) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("""
                    SELECT * FROM film
                    """);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Film f = new Film(
                        rs.getInt("ID"),
                        rs.getString("Title")
                );
                Actor regie = imdb.getActorByID(rs.getInt("Regie"));
                if (regie != null) {
                    f.setRegie(regie);
                }
                imdb.addFilm(f);
            }      // Close everything
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void readFromDatabaseActor(IMDB imdb) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("""
                    SELECT * FROM actor
                    """);

            ResultSet rs = ps.executeQuery();

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

            // Close everything
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateFilm(Film f){

        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("update film set title = ?, regie = ? where id = ?");

            ps.setString(1, f.getTitle());
            ps.setInt(2, f.getRegie().getId());
            ps.setInt(3, f.getId());

            int effectedRows = ps.executeUpdate();
            if(effectedRows == 0){
                System.out.println("Nothing changed.");
            }

            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void readAllFilmActorsFromDB(IMDB imdb){
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("Select * from filmactor");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
               Film f = imdb.getFilmByID(rs.getInt("filmId"));
               Actor a = imdb.getActorByID(rs.getInt("actorId"));
                if (f != null && a != null){
                    f.addActor(a);
                }
            }

            rs.close();
            ps.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

