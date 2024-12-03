package Gyula.week12.dotenvExample;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;
import java.util.Scanner;

public class DotEnvExample {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        String server = dotenv.get("server");
        String port = dotenv.get("port");
        String database = dotenv.get("database");
        String user = dotenv.get("user");
        String password = dotenv.get("password");

        System.out.println("In which country shall we search for cities?");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://" + server + ":" + port + "/" + database,
                    user,
                    password);

            PreparedStatement statement = connection.prepareStatement("""
                    select *
                    from city
                    join country on country.code = city.country
                    where country.name = ?
            """);
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();

            printResultSet(resultSet);

            // Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void printResultSet(ResultSet rs) throws SQLException{
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
}
