package Erik.week12.DBSelbsttestMitOOP;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DBManager {

    // Attribute
    private static DBManager instance = null;
    private Connection connection = null;


    // Konstruktor
    private DBManager() {
        // nothing..
    }


    // Methoden
    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("urlDDL");
        String user = dotenv.get("user");
        String password = dotenv.get("password");

        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
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


    public void readAnimalsFromDB(Enclosure enc) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from animal");

        ResultSet rs = ps.executeQuery();
        createAnimalOOP(enc, rs);

        rs.close();
        ps.close();
    }

    public Food getFoodByName(String foodName) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from food where name = ?");
        ps.setString(1, foodName);

        ResultSet rs = ps.executeQuery();

        Food food = null;
        if (rs.next()) {
            String name = rs.getString("name");
            int unit = rs.getInt("unit");
            int unitPrice = rs.getInt("unit price");

            food = new Food(name, unit, unitPrice);
        }

        rs.close();
        ps.close();

        return food;
    }

    public void createAnimalOOP(Enclosure enc, ResultSet rs) throws SQLException {
        while (rs.next()) {
            Food food = getFoodByName(rs.getString("food")); // Food aus der DB holen
            Animal animal = new Animal(
                    rs.getString("name"),
                    rs.getString("species"),
                    food,
                    rs.getInt("amount of food"),
                    rs.getInt("max health"),
                    rs.getInt("damage")
            );
            enc.addAnimalToList(animal);
        }
    }

    public void insertAnimalToDB(Animal animal) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into animal (name, species, food, amount_of_food, max_health, damage) values (?, ?, ?, ?, ?, ?)");
        ps.setString(1, animal.getName());
        ps.setString(2, animal.getGattung());
        ps.setString(3, animal.getFoodByName());
        ps.setInt(4, animal.getAmountOfFood());
        ps.setInt(5, animal.getMaxHP());
        ps.setInt(6, animal.getDamage());

        ps.executeUpdate();
        System.out.println("Animal inserted to DB");
    }

    public void updateAnimalInDB(Animal animal) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("update animal set species = ?, food = ?, amount_of_food = ?, max_health = ?, damage = ? where name = ?");

        ps.setString(1, animal.getGattung());
        ps.setString(2, animal.getFoodByName());
        ps.setInt(3, animal.getAmountOfFood());
        ps.setInt(4, animal.getMaxHP());
        ps.setInt(5, animal.getDamage());
        ps.setString(6, animal.getName());

        ps.executeUpdate();
        System.out.println("Animal updated!");
    }

    public void deleteAnimalFromDB(Animal animal) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from animal where name = ?");

        ps.setString(1, animal.getName());
        ps.executeUpdate();
        System.out.println("Animal deleted!");
    }
}
