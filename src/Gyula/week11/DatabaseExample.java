package Gyula.week11;

import java.sql.*;
import java.util.Scanner;

public class DatabaseExample {
    public static void main(String[] args) {
        System.out.println("In which country shall we search for cities?");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "gyula", "gyula");

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
