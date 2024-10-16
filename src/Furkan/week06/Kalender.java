package Furkan.week06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Kalender {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();

        printCalendar(gc, new Locale("DE", "at"));
        printCalendar(gc, new Locale("EN", "us"));
        printCalendar(gc, new Locale("TR", "tr"));
        printCalendar(gc, new Locale("ES", "es"));
        printCalendar(gc, new Locale("FR", "fr"));
        printCalendar(gc, new Locale("JA", "ja"));
        printCalendar(gc, new Locale("RU", "ru"));
        printCalendar(gc, new Locale("HU", "hu"));
        printCalendar(gc);
    }

    public static void printCalendar(GregorianCalendar gc){
        printCalendar(gc, Locale.getDefault());
    }

    public static void printCalendar(GregorianCalendar gc, Locale l){
        printHeader(gc, l);
        printEmptyBefore(gc);
        printDays(gc);
        printEmptyAfter(gc);
    }

    public static void printHeader(GregorianCalendar gc, Locale l){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM", l);
        System.out.println(sdf.format(gc.getTime()));

        SimpleDateFormat dayNameFormat = new SimpleDateFormat("EEE", l);
        GregorianCalendar testDay = new GregorianCalendar();
        testDay.setTime(gc.getTime());
        testDay.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        for (int i = 0; i < 7; i++) {
            String dayName = dayNameFormat.format(testDay.getTime());
            if (dayName.length() > 2){
                dayName = dayName.substring(0,2);
            }
            System.out.printf("| %2s ", dayName.toUpperCase(l));
            testDay.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("|");
    }

    public static void printEmptyBefore(GregorianCalendar gc){
        GregorianCalendar testDay = new GregorianCalendar();
        testDay.setTime(gc.getTime());
        testDay.set(Calendar.DAY_OF_MONTH, 1);

        while (testDay.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY){
            System.out.print("|    ");
            testDay.add(Calendar.DAY_OF_MONTH, -1);
        }

    }
    public static void printDays(GregorianCalendar gc){
        int daysMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
        GregorianCalendar testDay = new GregorianCalendar();
        testDay.setTime(gc.getTime());

        for (int day = 1; day <= daysMonth; day++) {
            testDay.set(Calendar.DAY_OF_MONTH, day);
            System.out.printf("| %2d%s",
                    day,
                    testDay.get(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH)?"*":" ");

            if (testDay.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
                System.out.println("|");
            }
        }
    }
    public static void printEmptyAfter(GregorianCalendar gc){
        GregorianCalendar testDay = new GregorianCalendar();
        testDay.setTime(gc.getTime());
        testDay.set(Calendar.DAY_OF_MONTH, testDay.getActualMaximum(Calendar.DAY_OF_MONTH));

        while (testDay.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
            System.out.print("|    ");
            testDay.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("|");
    }

}
