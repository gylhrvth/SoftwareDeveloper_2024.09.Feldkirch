package Aylin.week06;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalenderExamples {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();

        System.out.println(gc);

        System.out.println("Year: " + gc.get(Calendar.YEAR));
        System.out.println("Month: " + gc.get(Calendar.MONTH));                             //Monate fangen von 0 an und enden bei 11
        System.out.println("Day: " + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println("Weekday: " + gc.get(Calendar.DAY_OF_WEEK));                     //Wochen beginnen am Sonntag
        System.out.println("Last day of a Month " + gc.getActualMaximum(Calendar.DAY_OF_MONTH));

        GregorianCalendar myBirthday = new GregorianCalendar(1998, Calendar.SEPTEMBER,14);
        System.out.println(myBirthday);
        System.out.println("The last Day of the Month " + myBirthday.getActualMaximum(Calendar.DAY_OF_MONTH));

        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(gc.getTime()));

        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm:ss");
        System.out.println(sdf2.format(gc.getTime()));

        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm", new Locale("TR", "tr"));
        System.out.println(sdf3.format(gc.getTime()));

        SimpleDateFormat sdf4 = new SimpleDateFormat("EEEE, dd.MMMM", new Locale("FR", "fr"));
        System.out.println(sdf4.format(gc.getTime()));

        System.out.println("My BDay was on " + sdf4.format(myBirthday.getTime()));

    }
}
