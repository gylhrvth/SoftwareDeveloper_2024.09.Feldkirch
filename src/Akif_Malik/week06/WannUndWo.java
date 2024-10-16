package Akif_Malik.week06;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class WannUndWo {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat();
        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, dd. MMMM yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm");
        TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
        SimpleDateFormat sdf4 = new SimpleDateFormat("dd. MMMM yyyy, HH:mm z");
        SimpleDateFormat sdf5 = new SimpleDateFormat("ss:S");

        System.out.println("The Date now is : " + sdf2.format(gc.getTime()));

        System.out.println("The Time now is : " +  sdf3.format(gc.getTime()));

        System.out.println("The Time and Date now is : " + sdf.format(gc.getTime()));

        System.out.println("The Time and Date with TimeZone now is : " +  sdf4.format(gc.getTime()));
        gc.setTimeZone(tz);
        sdf4.setCalendar(gc);
        System.out.println("The Time and Date in Los Angeles now is : " +  sdf4.format(gc.getTime()));

        System.out.println("The current seconds at the moment with milliseconds : " + sdf5.format(gc.getTime()));
    }
}