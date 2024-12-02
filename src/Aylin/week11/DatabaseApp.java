package Aylin.week11;

import Gyula.ConsoleTools;
import Sandro.Colors;

import java.sql.*;
import java.util.Scanner;

public class DatabaseApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the country: ");
        String countryName = scanner.nextLine();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mondial?user=aylin&password=aylin");               // stellt eine Verbindung zwischen der Datenbank und unserer Java Klasse
            PreparedStatement ps = connection.prepareStatement(                                                                                     // vorbereitete Anweisungen für welche Daten aus der Datenbank ausgegeben werden
                    """                                                                              
                    SELECT DISTINCT ci.*
                    FROM city ci
                    JOIN country co on co.code = ci.country
                    WHERE co.name = ?
                    """);
            ps.setString(1, countryName);
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
        for (int i = 1; i < optimalColumnWidth.length; i++) {                                                                                       // Abstand zwischen den Spalten was in der Datenbank hinterlegt ist
            optimalColumnWidth[i] = Math.max(                                                                                                       // Math.max vergleicht, ob die Überschriftlänge oder die hinterlegte Länge lãnger ist und nimmt dann die größte Zahl als Abstand
                    metaData.getColumnLabel(i).length(),                                                                                            // lãnge der Überschrift
                    metaData.getColumnDisplaySize(i));                                                                                              // max hinterlegte Lãnge der Eingabe der Spalte in der Datenbank
        }

        for (int col = 1; col <= metaData.getColumnCount(); col++) {                                                                                // fori bestimmt die Überschrift / metaData.getColumnCount(): gibt die Anzahl der Spalten zurück, die durchlaufen werden
            System.out.printf(Colors.COLORS[6] + "| %-" + optimalColumnWidth[col] + "s " + Colors.RESET, metaData.getColumnLabel(col));
        }
        System.out.println(Colors.COLORS[6] + "|"+ Colors.RESET);

        while (rs.next()) {
            for (int col = 1; col <= rs.getMetaData().getColumnCount(); col++) {                                                                    // Liste ohne überschrift
                if (metaData.getColumnType(col) == Types.VARCHAR) {                                                                                 // schaut ob die Daten Zahlen oder Buchstaben sind
                    System.out.printf("| %-" + optimalColumnWidth[col] + "s ", rs.getString(col));                                                  // je nachdem wird es linksbündig oder rechtsbündig formatiert
                } else {
                    System.out.printf("| %" + optimalColumnWidth[col] + "s ", rs.getString(col));
                }
            }
            System.out.println("|");
        }
    }
}
