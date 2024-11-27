package Furkan.week12;

import java.sql.*;
import java.util.Scanner;

public class DatabaseApp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Gib ein Land ein:");
           String input = sc.nextLine();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=Furkan&password=furkan"); // Verbindet Datenbank zu Java Inteliji Klasse

            PreparedStatement ps = connection.prepareStatement("""
                    select c.*
                    from country co\s
                    join city c on co.Code = c.Country\s
                    where co.Name = '""" + input + "'");                                                       // Vorbereitung: Liest den angegebenen wert von der Datenbank aus (SQL Anweisung gespeichert)

            ResultSet rs = ps.executeQuery();   // Liefert den Result Set (ausführung von der gespeicherten SQL Anweisung)
            printResultSet(rs);

            // Alles Schließen für Ressourcen
            rs.close();
            ps.close();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();    // Fehlermeldung rückgabe
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData(); // ResultSetMetaData um Informationen über die Typen und Eigenschaften der Spalten zu erhalten   // Meta Data gibt Spalten info's

        // Suche nach der optimalen Spalten länge
        int[] optimalColumnWidth = new int[1 + metaData.getColumnCount()];  // im Array +1 weil SQL nicht bei 0 startet (Array startet bei 0 | SQL startet bei 1)
        for (int i = 1; i < optimalColumnWidth.length; i++) {
            optimalColumnWidth[i] = Math.max(
                    metaData.getColumnLabel(i).length(),    // Ruft angegebner Column
                    metaData.getColumnDisplaySize(i));      // Ruft die maximale Breite der spalte an
        }

        // Head Line
        for (int column = 1; column <= metaData.getColumnCount(); column++) {
            System.out.printf("| %-20s ", metaData.getColumnLabel(column) + "s",
                    metaData.getColumnLabel(column));   // Printet den angegebenenn Column auf
        }
        System.out.println("|");

        // Der rest
        while (rs.next()) { // Solange noch was vorhanden ist
            for (int column = 1; column <= rs.getMetaData().getColumnCount(); column++) {   // getColumnCount gibt anzahl der spalten zurück
                if (metaData.getColumnType(column) == Types.VARCHAR) {                      // getColumnType Gibt die spalten zahl zurück | und Types.Varchar = "Variabler Charakter" um die länge von einem wort zu speichern
                    System.out.printf("%-20s", rs.getString(column) + "s ", rs.getString(column));
                } else {
                    System.out.printf("%-20s", rs.getString(column) + "s ", rs.getString(column));
                }
            }
            System.out.println("|");

        }
    }

}
