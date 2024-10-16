package Furkan.week06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class KalenderWannWo {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(gc);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMM.yyyy");
        System.out.println("Datum: " + sdf.format(gc.getTime()));

        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        System.out.println("Uhrzeit: " + sdf2.format(gc.getTime()));

        SimpleDateFormat sdf3 = new SimpleDateFormat();
        System.out.println("Datum und Uhrzeit: " + sdf3.format(gc.getTime()));

        System.out.println("Datum Uhrzeit mit Zeitzone: " + gc.getTime());

        SimpleDateFormat sdf4 = new SimpleDateFormat("EEEE , dd. MMMM yyyy, HH:mm:ss");
        System.out.println("Datum Uhrzeit mit Millisekunde: " + sdf4.format(gc.getTime()));


    }
}
