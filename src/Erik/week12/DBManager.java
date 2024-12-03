package Erik.week12;

import java.sql.*;

public class DBManager {

    // Attribute
    private static DBManager instance = null;
    private Connection connection = null;


    // Konstruktor
    private DBManager() {

    }


    // Methoden
    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }


    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TSerien?user=erik&password=erik");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }


    public void readActorFromDB(IMDB imdb) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from actor");

        ResultSet rs = ps.executeQuery();
        createActorOOP(imdb, rs);

        rs.close();
        ps.close();
    }

    public void readMovieFromDB(IMDB imdb) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from film");

        ResultSet rs = ps.executeQuery();
        createMovieOOP(imdb, rs);

        rs.close();
        ps.close();
    }


    public void createActorOOP(IMDB imdb, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Actor actor = new Actor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("alter"),
                    rs.getInt("weight"),
                    rs.getInt("height")
            );
            imdb.addActor(actor);
        }
    }

    public void createMovieOOP(IMDB imdb, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Film movie = new Film(
                    rs.getInt("id"),
                    rs.getString("title")
            );
            imdb.addFilm(movie);
        }
    }


    public void updateActor(Actor a) {
        // TODO: Create UPDATE Statement...
    }
}