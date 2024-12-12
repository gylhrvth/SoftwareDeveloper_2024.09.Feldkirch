package Gyula.week12.zoowithdatabase;

import Gyula.week09.zoo.Animal;
import Gyula.week09.zoo.Zoo;
import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DBManager {
    private static DBManager instance = null;
    private Connection connection = null;

    private DBManager(){

    }

    public static DBManager getInstance(){
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    public void openConnection(){
        try {
            if (connection == null || connection.isClosed()) {
                Dotenv dotenv = Dotenv.load();
                String url = dotenv.get("urlAnimal");
                String user = dotenv.get("user");
                String password = dotenv.get("password");

                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException sqlException){
            System.out.println("Connection failed. " + sqlException.getMessage());
        }
    }

    public void readAllAnimalsFromDatabase(Zoo tierpark){
        openConnection();
        if (connection != null){
            try {
                PreparedStatement ps = connection.prepareStatement("select * from animal");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    tierpark.searchAndCreateAnimal(
                            rs.getString("Enclosure"),
                            rs.getString("Name"),
                            rs.getString("Species"),
                            rs.getString("Gender"),
                            rs.getInt("MaxHealth"),
                            rs.getInt("Attack")
                    );
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                System.out.println("Table Animal couldn't be read. " + e.getMessage());
            }
        }
    }


    public void updateAnimalHealth(Animal animal){
        openConnection();
        if (connection != null){
            try {
                PreparedStatement ps = connection.prepareStatement("update animal set Health = ? WHERE Name = ?");
                ps.setInt(1, animal.getHealth());
                ps.setString(2, animal.getName());

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected != 1){
                    System.out.println("Update failed... No lines has changed.");
                }
            } catch (SQLException e){
                System.out.println("Update is not possible. " + e.getMessage());
            }
        }
    }
}
