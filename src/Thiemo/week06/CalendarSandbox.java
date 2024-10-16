package Thiemo.week06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalendarSandbox {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd MM yy");
        System.out.println(sdfDate.format(gc.getTime()));

        SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdfTime.format(gc.getTime()));

        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println(sdf.format(gc.getTime()));

        SimpleDateFormat Timezone = new SimpleDateFormat("HH:mm:ss z");
        System.out.println(Timezone.format(gc.getTime()));

        SimpleDateFormat sec = new SimpleDateFormat("ss SSS");
        System.out.println(sec.format(gc.getTime()));

        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm:ss");
        System.out.println("Jetzt ist: " + sdf2.format(gc.getTime()));

        GregorianCalendar dateFromConsole = new GregorianCalendar();
        dateFromConsole.setTime(readDateFromConsole("Gib dein Geburtdatum im Format TT/MM/JJJJ ein:"));
        System.out.println("Geburtsdatum des Users: " + sdf2.format(dateFromConsole.getTime()));
        System.out.println("Wochentag:"+dateFromConsole.get(java.util.Calendar.DAY_OF_MONTH));
        System.out.println("Wochentag:"+dateFromConsole.get(java.util.Calendar.DAY_OF_WEEK));
        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE");
        System.out.println(sdf3.format(dateFromConsole.getTime()));
    }

    public static Date readDateFromConsole(String msg) {
        Date result = null;
        SimpleDateFormat formatBirthday = new SimpleDateFormat("dd/MM/yyyy");

        while (result == null) {
            System.out.print(msg + " >>> ");
            String text = sc.nextLine();
            try {
                result = formatBirthday.parse(text);
            } catch (ParseException pe) {
                System.out.println("ungültige Datum Format. Bitte TT/MM/JJJJ verwenden.");
            }
        }
        return result;
    }
}







