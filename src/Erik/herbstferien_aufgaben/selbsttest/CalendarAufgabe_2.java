package Erik.herbstferien_aufgaben.selbsttest;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/*
Erstelle ein Programm, das das aktuelle Datum und die Uhrzeit ausgibt.
Verwende für jede unten angegebene ausgabe ein eigenes SimpleDateFormat und erstelle eine 3 Zeilige Ausgabe:

1. Nur das Datum
2. Nur die Uhrzeit
3. Datum und Uhrzeit
4. Datum und Uhrzeit mit Zeitzone
5. Die aktuelle Sekunde mit Millisekunde
*/

public class CalendarAufgabe_2 {
    public static void main(String[] args) {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdfDateTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        SimpleDateFormat sdfDateTimeAndZone = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss z");
        SimpleDateFormat sdfPreciseTime = new SimpleDateFormat("s:S");

        System.out.println("Uhrzeit: " + sdfTime.format(gc.getTime()) + " Datum: " + sdfDate.format(gc.getTime()));
        System.out.println("Datum Uhrzeit: " + sdfDateTime.format(gc.getTime()));
        System.out.println("Datum Uhrzeit Zeitzone Sekunde Millisekunde: " + sdfDateTimeAndZone.format(gc.getTime()) + " " + sdfPreciseTime.format(gc.getTime()));
    }
}