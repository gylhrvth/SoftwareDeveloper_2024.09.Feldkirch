package Aylin.week08.Zoo;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class dbManagerZoo {
    private static dbManagerZoo instance = null;
    private Connection connection = null;

    private dbManagerZoo() {
        // ...
    }

    private Connection getConnection()throws SQLException {
        if(connection == null) {
            Dotenv dotenv = Dotenv.load();
            String url = dotenv.get("urlZoo");
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

    public static dbManagerZoo getInstance() {
        if (instance == null) {
            instance = new dbManagerZoo();
        }
        return instance;
    }

    /*public void readTableFromDB(Enclosure enclosure){
        try{
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("Select * from zoo");

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Zoo zoo = new Zoo(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("species"),
                        rs.getInt("age"),
                        rs.getString("food"),
                        rs.getDouble("amount"),
                        rs.getInt("health"),
                        rs.getInt("bite"),
                        rs.getInt("maxHealth")
                );
                enclosure.addAnimals(new Animals());
            }
            rs.close();
            ps.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }*/
}
