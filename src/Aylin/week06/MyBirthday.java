package Aylin.week06;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyBirthday {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        GregorianCalendar dateFromConsole = new GregorianCalendar();
        dateFromConsole.setTime(readDateFromConsole("Gib dein Geburtdatum im Format TT/MM/JJJJ ein:"));
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd. MMMM yyyy");
        System.out.println("Geburtsdatum des Users: " + sdf.format(dateFromConsole.getTime()));
    }

    public static Date readDateFromConsole(String msg){
        Date result = null;
        SimpleDateFormat birthdayFormat = new SimpleDateFormat("dd.MM.yyyy");

        while(result == null){
            System.out.print(msg);
            String text = sc.nextLine();
            try{
                result = birthdayFormat.parse(text);
            }catch(ParseException pe){
                System.out.println("Invalid date format. Please use DD.MM.YYYY.");
            }
        }
        return result;
    }
}
