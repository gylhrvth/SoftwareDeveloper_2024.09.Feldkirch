package Aylin.week06;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateAndTime {
    public static void main(String[] args) {
        System.out.println("Datum:");
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MMMM.yyy");
        System.out.println(sdf.format(gc.getTime()));
        System.out.println();
        System.out.println("Uhrzeit:");
        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdfTime.format(gc.getTime()));
        System.out.println();
        System.out.println("Datum und Uhrzeit:");
        SimpleDateFormat sdfDateAndTime = new SimpleDateFormat("dd.MMM.yyyy, HH:mm:ss");
        System.out.println(sdfDateAndTime.format(gc.getTime()));
        System.out.println();
        System.out.println("Datum und Uhrzeit mit Zeitzone:");
        sdfDateAndTime.setTimeZone(TimeZone.getTimeZone("GMT"));
        SimpleDateFormat sdfDateWithTimezone = new SimpleDateFormat("dd.MMM.yyyy, HH:mm:ss,");
        //System.out.println(sdfDateAndTime.format(gc.getTime() + ", " + sdfDateWithTimezone.getTimeZone().getID()));
        System.out.println();
        System.out.println("Sekunde und Milisekunde");
        SimpleDateFormat sdfSecondAndMilisecond = new SimpleDateFormat("HH:mm:ss:SSS");
        System.out.println(sdfSecondAndMilisecond.format(gc.getTime()));
    }
}
