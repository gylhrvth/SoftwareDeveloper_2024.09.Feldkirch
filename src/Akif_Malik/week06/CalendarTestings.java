package Akif_Malik.week06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTestings {
    public static void main(String[] args) {
        System.out.println(GregorianCalendar.getAvailableCalendarTypes());

        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(gc.get(Calendar.DAY_OF_YEAR));
        System.out.println(gc.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc.get(Calendar.DAY_OF_WEEK));

        System.out.println("Jahr  : " + gc.get(Calendar.YEAR));
        System.out.println("Monat  : " + gc.get(Calendar.MONTH));
        System.out.println("Tag  : " + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println("Tag im Jahr  : " + gc.get(Calendar.DAY_OF_YEAR));
        System.out.println("Wochentag  : " + gc.get(Calendar.DAY_OF_WEEK));
        System.out.println("letzte Tag im Monat  : " + gc.getActualMaximum(Calendar.DAY_OF_MONTH));

        GregorianCalendar myBirthday = new GregorianCalendar(2009, Calendar.JANUARY, 28, 0, 13);
        //System.out.println(myBirthday);
        //myBirthday.add(Calendar.YEAR, 11);

        SimpleDateFormat formatter1 = new SimpleDateFormat();
        System.out.println("The Time now is  : " + formatter1.format(gc.getTime()));

        SimpleDateFormat formatter2 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm", new Locale("TR", "tr"));
        System.out.println("The updated Time now is  : " + formatter2.format(gc.getTime()));

        System.out.println("My Birthday is  : " + formatter2.format(myBirthday.getTime()));

                // THE USE OF TIMEZONE
        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd. MMMM yyyy, HH:mm z");

        gc.setTimeZone(tz);
        sdf4.setCalendar(gc);
        System.out.println("The Time and Date in Los Angeles now is : " +  sdf4.format(gc.getTime()));
        // shows the time in Los_Angeles~/~America
    }
}
