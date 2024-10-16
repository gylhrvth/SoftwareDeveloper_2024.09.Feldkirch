package Thiemo.week06;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ThiemoCalendar {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();

        printCalendar(gc);
    }

    public static void printCalendar(GregorianCalendar today){
        printHeader(today);
        printEmptyBlocksBefore(today);
        printDays(today);
        printEmptyBlocksAfter(today);
    }

    public static void printHeader(GregorianCalendar today){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM");
        System.out.println(sdf.format(today.getTime()));

        System.out.println("| Mo | Di | Mi | Do | Fr | Sa | So |");
    }

    public static void printEmptyBlocksBefore(GregorianCalendar today){
        GregorianCalendar testDaysBefore = new GregorianCalendar();
        testDaysBefore.setTime(today.getTime());
        testDaysBefore.set(Calendar.DAY_OF_MONTH, 1);
        while (testDaysBefore.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY){
            System.out.print("| .. ");
            testDaysBefore.add(Calendar.DAY_OF_MONTH, -1);
        }
    }

    public static void printDays(GregorianCalendar today){
        int lastDayofMonth = today.getActualMaximum(Calendar.DAY_OF_MONTH);
        int actualDay = today.get(Calendar.DAY_OF_MONTH);

        GregorianCalendar test = new GregorianCalendar();
        test.setTime(today.getTime());

        for (int day = 1; day <= lastDayofMonth; day++) {
            test.set(Calendar.DAY_OF_MONTH, day);
            System.out.printf("| %2d", day);
            if (day == actualDay) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            if (test.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                System.out.println("|");
            }
        }
    }

    public static void printEmptyBlocksAfter(GregorianCalendar today){
        GregorianCalendar testDaysAfter = new GregorianCalendar();
        testDaysAfter.setTime(today.getTime());
        testDaysAfter.set(Calendar.DAY_OF_MONTH, today.getActualMaximum(Calendar.DAY_OF_MONTH));

        while (testDaysAfter.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){
            System.out.print("| ++ ");
            testDaysAfter.add(Calendar.DAY_OF_MONTH, 1);
        }
        System.out.println("|");
    }

}




