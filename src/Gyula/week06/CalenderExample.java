package Gyula.week06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalenderExample {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();

        System.out.println(gc);

        System.out.println("Jahr : " + gc.get(Calendar.YEAR));
        System.out.println("Monat (!!! Vorsicht Monat geht von 0 bis 11): " + gc.get(Calendar.MONTH));
        System.out.println("Tag  : " + gc.get(Calendar.DAY_OF_MONTH));
        System.out.println("Tag im Jahr : " + gc.get(Calendar.DAY_OF_YEAR));
        System.out.println("Wochentag (!!! Vorsicht beginnt bei Sonntag) : " + gc.get(Calendar.DAY_OF_WEEK));
        System.out.println("letzte Tag im Monat : " + gc.getActualMaximum(Calendar.DAY_OF_MONTH));

        GregorianCalendar meinGeburtstag = new GregorianCalendar(1979, Calendar.MARCH,2, 14, 15);
        System.out.println(meinGeburtstag);
        System.out.println("letzte Tag im Monat : " + meinGeburtstag.getActualMaximum(Calendar.DAY_OF_MONTH));

        //meinGeburtstag.add(Calendar.YEAR, 21);

        SimpleDateFormat sdf = new SimpleDateFormat();
        System.out.println("Jetzt ist: " + sdf.format(gc.getTime()));

        SimpleDateFormat sdf2 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm:ss");
        System.out.println("Jetzt ist: " + sdf2.format(gc.getTime()));

        SimpleDateFormat sdf3 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm", new Locale("TR", "tr"));
        System.out.println("Jetzt ist: " + sdf3.format(gc.getTime()));

        System.out.println("Mein Geburtsdatum ist: " + sdf3.format(meinGeburtstag.getTime()));


        GregorianCalendar dateFromConsole = new GregorianCalendar();
        dateFromConsole.setTime(readDateFromConsole("Gib dein Geburtdatum im Format TT/MM/JJJJ ein:"));
        System.out.println("Geburtsdatum des Users: " + sdf2.format(dateFromConsole.getTime()));

    }


    public static Date readDateFromConsole(String message){
        Date result = null;
        SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd/MM/yyyy");

        while (result == null) {
            System.out.print(message + " >>> ");
            String text = scanner.nextLine();
            try {
                result = birthdayFormat.parse(text);
            } catch (ParseException pe) {
                System.out.println("ungültige Datum Format. Bitte TT/MM/JJJJ verwenden.");
            }
        }
        return result;
    }
}
