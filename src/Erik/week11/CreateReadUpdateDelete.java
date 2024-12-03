package Erik.week11;

import java.sql.*;
import java.util.Scanner;

public class CreateReadUpdateDelete {
     public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=erik&password=erik");

            System.out.println("Aktuelle Liste");
            printQuery(conn);


            // Mit Scanner      in einzelne Methoden knallen! (macht mehr Sinn)
            createCity(conn);
            printQuery(conn);

            updateCityPop(conn);
            printQuery(conn);

            deleteCity(conn);
            printQuery(conn);


            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] getOptimalColumnWidth(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColWidth = new int[1 + metaData.getColumnCount()];

        for (int i = 1; i < optimalColWidth.length; i++) {
            optimalColWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }
        return optimalColWidth;
    }

    public static void printHeadLine(int[] optimalColWidth, ResultSetMetaData metaData) throws SQLException {
        System.out.println("-".repeat(130));
        for (int col = 1; col <= metaData.getColumnCount(); col++) {
            System.out.printf("| %-" + optimalColWidth[col] + "s ", metaData.getColumnLabel(col),
                    metaData.getColumnLabel(col));
        }
        System.out.println("|");
    }

    public static void printBody(ResultSet rs, ResultSetMetaData metaData, int[] optimalColWidth) throws SQLException {
        while (rs.next()) {

            for (int col = 1; col <= metaData.getColumnCount(); col++) {

                if (metaData.getColumnType(col) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColWidth[col] + "s ", rs.getString(col));
                } else {
                    System.out.printf("| %" + optimalColWidth[col] + "s ", rs.getString(col));
                }
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(130));
    }

    public static void printQuery(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from city c where c.Country = 'A';");
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColWidth = getOptimalColumnWidth(rs);

        printHeadLine(optimalColWidth, metaData);
        printBody(rs, metaData, optimalColWidth);

        ps.close();
        rs.close();
    }


    // Testing with Hardcoding
    public static void createCity(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into city (Name, Country, Province) values(?, ?, ?)");

        System.out.print("Enter a City you want to create: >> ");
        String city = sc.nextLine();

        ps.setString(1, city);
        ps.setString(2, "A");
        ps.setString(3, "Vorarlberg");

        ps.executeUpdate();
        ps.close();
        System.out.println("Info: New City: >> " + city + " got added to the List!");
    }

    public static void updateCityPop(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update city c set Population = ? where c.Name = ?");

        System.out.print("Enter the Population of the City: >> ");
        int Population = sc.nextInt();

        ps.setInt(1, Population);
//        ps.setString(2, city);

        ps.executeUpdate();
        ps.close();
//        System.out.println("Info: Population from the chosen City: >> " + city + " got updated!");
    }

    public static void deleteCity(Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from city c where c.Name = ?");

        System.out.print("Enter a City you want to delete: >> ");
        String cityDelete = sc.nextLine();

        ps.setString(1, cityDelete);

        ps.executeUpdate();
        ps.close();
        System.out.println("Chosen City: >> " + cityDelete + " got deleted from the List!");
    }
}