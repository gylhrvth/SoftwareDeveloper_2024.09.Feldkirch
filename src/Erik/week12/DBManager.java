package Erik.week12;

import java.sql.*;

public class DBManager {


    private static DBManager instance = null;
    private Connection connection = null;


    private DBManager() {
        // ...
    }


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

    public void createActorOOP() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from actor");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Actor actor = new Actor(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("alter"),
                    rs.getInt("weight"),
                    rs.getInt("height")
            );
//            f.addActor(actor);
        }
    }

    public void createMovieOOP() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from film");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Film movie = new Film(
                    rs.getInt("id"),
                    rs.getString("title")
            );

        }
    }


    public void updateActor(Actor a) {
        // TODO: Create UPDATE Statement...
    }
}







/*
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
 */
