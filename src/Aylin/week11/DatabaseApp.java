package Aylin.week11;

import Sandro.Colors;

import java.sql.*;

public class DatabaseApp {
    public static void main(String[] args) {
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=aylin&password=aylin");               // stellt eine Verbindung zwischen der Datenbank und unserer Java Klasse
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM city WHERE name like 'B%' LIMIT 10");                             // vorbereitete Anweisungen für welche Daten aus der Datenbank ausgegeben werden

            ResultSet rs = ps.executeQuery();                                                                                                       // executeQuery: die Ausführung unserer Anweisung (z.B. run in Java)
                                                                                                                                                    // resultSet: Das Ergebnis, was wir durch die Ausführung der Anweisung erhalten
            printResultSet(rs);

            //Close everything (auf Reihenfolge achten! - die letzte geöffnete Methode zuerst schließen)
            rs.close();
            ps.close();
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();                                                                                                                    // gibt eine Error-Meldung mit der bestimmten Zeile, in der die/der Exception/Fehler stattfindet, zurück
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();                                                                                              // metaData: gibt die Spalten-Info zurück
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];                                                                          // Array verschafft die optimale Breite für alle Spalten plus eine zusätzliche Information (+1)
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),
                    metaData.getColumnDisplaySize(i));
        }

        for (int col = 1; col <= metaData.getColumnCount(); col++) {                                                // Überschrift
            System.out.printf(Colors.COLORS[6] + "| %-" + optimalColumnWidth[col] + "s " + Colors.RESET, metaData.getColumnLabel(col));
        }
        System.out.println(Colors.COLORS[6] + "|"+ Colors.RESET);

        while (rs.next()) {
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {                                    // Liste ohne überschrift
                if (metaData.getColumnType(col) == Types.VARCHAR) {
                    System.out.printf("| %-" + optimalColumnWidth[col] + "s ",
                            rs.getString(col));
                } else {
                    System.out.printf("| %" + optimalColumnWidth[col] + "s ", rs.getString(col));
                }
            }
            System.out.println("|");
        }
    }
}
