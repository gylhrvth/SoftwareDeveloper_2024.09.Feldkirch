package Furkan.week06;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class KalenderBeispiele {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println(gc);

        System.out.println("Gib ein wann du Geburtstag hast: ");
        String userInput = "";
        userInput = scanner.nextLine();

        GregorianCalendar meinGeburtstag = new GregorianCalendar(2003, Calendar.JANUARY, 17);

    }



}
