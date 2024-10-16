package Erik.week06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExamples {
    public static void main(String[] args) {

        GregorianCalendar gc = new GregorianCalendar();                             // Wenn der Gregorian Calendar in der klammer nicht definiert wird verwendet er das aktuelle Datum.
        System.out.println(gc + "\n");

        System.out.println("Wochentag: >> " + gc.get(Calendar.DAY_OF_WEEK));        // Die Standard sprache ist auf US gesetzt, deswegen fängt der Wochentag "1" beim Sonntag an.
        System.out.println("      Tag: >> " + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println("    Monat: >> " + gc.get(Calendar.MONTH));              // Achtung!!! Der Januar fängt bei "0" an zu zählen
        System.out.println("     Jahr: >> " + gc.get(Calendar.YEAR) + "\n");

        SimpleDateFormat sdf = new SimpleDateFormat();                              // SimpleDateFormat erstellen
        System.out.println(sdf.format(gc.getTime()) + "\n");                        // SimpleDateFormat Aufruf mit der aktuellen Zeit vom Gregorian Calendar

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy, 'W'ww, u");      // Datum/Zeit Pattern erstellen wie es bei der Ausgabe aus schauen soll.
        System.out.println("Year, Week of Year, Day of Week  ");
        System.out.println(sdf2.format(gc.getTime()) + "\n");

        SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MMM yyyy; HH:mm:ss z"); // Tag, Monat, Jahr, Stunde, Minute, Sekunde, Zeit Zone
        System.out.println(sdf3.format(gc.getTime()));

        SimpleDateFormat sdf4 = new SimpleDateFormat("dd.MMMM yyyy");
        GregorianCalendar meinGeburtstag = new GregorianCalendar(2001, 3, 28);
        System.out.println("Mein Geburtstag ist am: >> " + sdf4.format(meinGeburtstag.getTime()));
    }
}
