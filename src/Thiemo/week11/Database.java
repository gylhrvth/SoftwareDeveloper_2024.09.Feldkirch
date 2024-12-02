package Thiemo.week11;

import Gyula.ConsoleTools;

import java.sql.*;
import java.util.Scanner;

public class Database {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a City Name");
        String countryName = sc.nextLine();
        String cityName = sc.nextLine();
        int minPop = ConsoleTools.readNumber("Min Pop", 1, 999999999);

        try {
          Connection connenction = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=Thiemo&password=thiemo");
            // Connection connenction = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial", "Thiemo", "thiemo");



            PreparedStatement ps = connenction.prepareStatement("""
                    Select distinct ci.*
                    From city ci 
                    Join country co on ci.country = co.code
                    where co.name like ? and ci.population > ?
                    """);
//            PreparedStatement ps = connenction.prepareStatement("SELECT * FROM city Limit 10");
//            System.out.println("""
//                    select distinct tempT.Continent, m2.Name, m2.Height\s
//                    from\s
//                    	(
//                    		select e.Continent, max(m.Height) maxH
//                    		from mountain m\s
//                    		join geo_mountain gm on m.Name = gm.Mountain\s
//                    		join encompasses e on gm.Country = e.Country
//                    		where e.Percentage >= 50
//                    		group by e.Continent						-- Das was im 'group by' steht muss oben im select stehen mit * geht's nicht!
//                    	) tempT
//                    join encompasses e2 on tempT.continent = e2.Continent\s
//                    join geo_mountain gm2  on e2.Country = gm2.Country\s
//                    join mountain m2 on gm2.Mountain = m2.Name
//                    where tempT.maxH = m2.Height\s
//                    """);


//            PreparedStatement ps = connenction.prepareStatement("select distinct tempT.Continent, m2.Name, m2.Height \n" +
//                    "from \n" +
//                    "\t(\n" +
//                    "\t\tselect e.Continent, max(m.Height) maxH\n" +
//                    "\t\tfrom mountain m \n" +
//                    "\t\tjoin geo_mountain gm on m.Name = gm.Mountain \n" +
//                    "\t\tjoin encompasses e on gm.Country = e.Country\n" +
//                    "\t\twhere e.Percentage >= 50\n" +
//                    "\t\tgroup by e.Continent\t\t\t\t\t\t
//                    "\t) tempT\n" +
//                    "join encompasses e2 on tempT.continent = e2.Continent \n" +
//                    "join geo_mountain gm2  on e2.Country = gm2.Country \n" +
//                    "join mountain m2 on gm2.Mountain = m2.Name\n" +
//                    "where tempT.maxH = m2.Height ");


            ps.setString(1, countryName + "%");
            ps.setInt(2, minPop);
            ResultSet rs = ps.executeQuery();
            printResultSet(rs);

            //Close Everything
            rs.close();
            ps.close();
            connenction.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void printResultSet(ResultSet rs) throws SQLException {

        // headliner from Datenbank

        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }


        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            System.out.printf("| %-" + optimalColumnWidth[column] + "s",
                    metaData.getColumnLabel(column));
//                    metaData.getColumnTypeName(column),
//                    metaData.getColumnDisplaySize(column));


        }
        System.out.println("|");

        // Daten von Datenbank

        while (rs.next()) {

            for (int column = 1; column <= rs.getMetaData().getColumnCount(); column++) {
                if (metaData.getColumnType(column) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[column] + "s", rs.getString(column));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[column] + "s", rs.getString(column));
                }
            }
            System.out.println("|");
        }
    }
}
