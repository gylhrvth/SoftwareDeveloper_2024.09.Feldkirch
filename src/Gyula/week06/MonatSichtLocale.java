package Gyula.week06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class MonatSichtLocale {
    public static void main(String[] args) {
        GregorianCalendar today = new GregorianCalendar();

        //today.add(Calendar.MONTH, 2);
        printMonthOverview(today, new Locale("DE", "at"));
        System.out.println();
        printMonthOverview(today, new Locale("FR", "fr"));
        System.out.println();
        printMonthOverview(today, new Locale("TR", "tr"));
    }

    public static void printMonthOverview(GregorianCalendar gc, Locale locale){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY MMMM");

        System.out.println(sdf.format(gc.getTime()));
        printDayNames(gc, locale);

        int lastDayOfMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);
        GregorianCalendar testDay = new GregorianCalendar();
        testDay.setTime(gc.getTime());
        testDay.set(Calendar.DAY_OF_MONTH, 1);

        int emptyDaysBefore = countEmptyCellBefore(testDay);
        for (int i = 0; i < emptyDaysBefore; i++) {
            System.out.print("|    ");
        }

        for (int day = 1; day <= lastDayOfMonth ; day++) {
            System.out.printf("| %2d", day);
            testDay.set(Calendar.DAY_OF_MONTH, day);
            System.out.print(testDay.get(Calendar.DAY_OF_MONTH) == gc.get(Calendar.DAY_OF_MONTH)?"*":" ");

            if (testDay.get(Calendar.DAY_OF_WEEK ) == Calendar.SUNDAY){
                System.out.println("|");
            }
        }

        while (testDay.get(Calendar.DAY_OF_WEEK ) != Calendar.SUNDAY){
            System.out.print("|    ");
            testDay.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("|");
    }

    public static int countEmptyCellBefore(GregorianCalendar gc){
        GregorianCalendar testDay = new GregorianCalendar();
        testDay.setTime(gc.getTime());
        testDay.set(Calendar.DAY_OF_MONTH, 1);

        int result = (7 + (testDay.get(Calendar.DAY_OF_WEEK) - 2)) % 7;

        return result;
    }

    public static void printDayNames(GregorianCalendar gc, Locale locale){
        SimpleDateFormat sdf = new SimpleDateFormat("EEE", locale);
        GregorianCalendar testDay = new GregorianCalendar();

        testDay.setTime(gc.getTime());
        testDay.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        for (int i = 0; i < 7; i++) {
            System.out.printf("| %s ", sdf.format(testDay.getTime()).substring(0,2));
            testDay.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("|");
    }
}

