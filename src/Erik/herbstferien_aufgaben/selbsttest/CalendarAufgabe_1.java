package Erik.herbstferien_aufgaben.selbsttest;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/*
Gib mit Hilfe der Calendar Api den Wochentag des aktuellen Tages inklusive Datum aus.
Mi; 30.10.2024
 */

public class CalendarAufgabe_1 {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("EE dd.MM.yyyy");
        System.out.println(sdf.format(gc.getTime()));
    }
}
