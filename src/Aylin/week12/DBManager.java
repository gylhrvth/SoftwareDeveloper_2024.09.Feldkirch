package Aylin.week12;

import Sandro.Colors;

import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class DBManager {
    public Scanner scanner = new Scanner(System.in);
    private static DBManager instance = null;
    private Vector<Film> films;
    private Vector<Actor> actors;
    private IMDB imdb;

    private DBManager(){
        films = new Vector<>();
        actors = new Vector<>();

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/series", "aylin", "aylin");
            PreparedStatement ps = conn.prepareStatement("Select * from actor");

            ResultSet rs = ps.executeQuery();

            printResultSet(rs);

            ps.close();
            conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static DBManager getInstance() {
        if (instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    public static void printResultSet(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }

        for (int col = 1; col <= metaData.getColumnCount(); col++) {
            System.out.printf(Colors.COLORS[6] + "| %-" + optimalColumnWidth[col] + "s " + Colors.RESET, metaData.getColumnLabel(col));
        }
        System.out.println(Colors.COLORS[6] + "|"+ Colors.RESET);

        while (rs.next()) {
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {
                if (metaData.getColumnType(col) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[col] + "s ", rs.getString(col));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[col] + "s ", rs.getString(col));
                }
            }
            System.out.println("|");
        }
    }

    public void addActor(Actor actor) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/series", "aylin", "aylin");
            PreparedStatement ps = conn.prepareStatement("insert into actor (firstname, lastname, age) values (?, ?, ?)");

            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());
            ps.setInt(3, actor.getAge());

            ps.executeUpdate();

            ps.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
