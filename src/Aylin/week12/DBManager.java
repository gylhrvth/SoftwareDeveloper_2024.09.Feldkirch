package Aylin.week12;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Scanner;

public class DBManager {
    public Scanner scanner = new Scanner(System.in);
    private static DBManager instance = null;
    private Connection connection = null;

    private DBManager(){
    }

    private Connection getConnection()throws SQLException{
        if(connection == null) {
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("urlSeries");
            String user = dotenv.get("user");
            String password = dotenv.get("password");
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    public void closeConnection(){
        if(connection != null){
           try {
               connection.close();
           } catch (SQLException e) {
           }
            connection = null;
        }
    }

    public static DBManager getInstance() {
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    public void readAllActorFromDB(IMDB imdb){
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from actor");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Actor newActor = new Actor(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getInt("age")
                );
                imdb.addActor(newActor);
            }

            rs.close();
            ps.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void readAllFilmsFromDB(IMDB imdb){
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("Select * from film");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Film newFilm = new Film(
                        rs.getInt("id"),
                        rs.getString("title"),
                        imdb.getActorByID(rs.getInt("regie"))
                );
                imdb.addFilm(newFilm);
            }

            rs.close();
            ps.close();

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

        } catch (SQLException e) {
            throw new RuntimeException(e);
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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void addActor(Actor actor) {
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/series", "aylin", "aylin");
//            PreparedStatement ps = conn.prepareStatement("insert into actor (firstname, lastname, age) values (?, ?, ?)");
//
//            ps.setString(1, actor.getFirstName());
//            ps.setString(2, actor.getLastName());
//            ps.setInt(3, actor.getAge());
//
//            ps.executeUpdate();
//
//            ps.close();
//            conn.close();
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
}
