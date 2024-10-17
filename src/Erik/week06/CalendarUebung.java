package Erik.week06;
/*
        Todo:   1. Gregorian Calendar erstellen mit heutigem Daten initialisieren
                2. SimpleDateFormat erstellen mit "Jahr und Monat" definiert.
                3. for i schleife von 1 bis monats ende
                4. Wenn Wochenende erreicht
                5. Am Anfang Leerschläge bis 1. Monatstag
                6. Am Ende Leerschläge bis Sonntag
 */

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class CalendarUebung {
    public static void main(String[] args) {

        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.MONTH, 0);
        printCalendar(gc);

    }

    // Sonntag ist 1
    // Montag ist 2
    public static void printCalendar(GregorianCalendar gc) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM");
        System.out.println(sdf.format(gc.getTime()));

        System.out.println("| Mo | Di | Mi | Do | Fr | Sa | So |");

        GregorianCalendar testCal = new GregorianCalendar();            // neuer Test Calendar erstellen
        testCal.setTime(gc.getTime());                                  // Test Calendar bekommt die Werte vom Originalen Calendar
        int endOfMonth = gc.getActualMaximum(Calendar.DAY_OF_MONTH);    // Ende Monat in einer Variable speichern zum, die Funktion einmal aufzurufen; nicht mehrmals!

        testCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = testCal.getFirstDayOfWeek();

        // Leerschläge bis zum ersten tag
        for (int i = Calendar.MONDAY; i <= firstDayOfWeek; i++) {
            System.out.print("|    ");
        }

        // Print Calender im Format
        for (int day = 1; day <= endOfMonth; day++) {
            testCal.set(Calendar.DAY_OF_MONTH, day);
            System.out.printf("| %2d ", day);

            // Zeilenumbruch
            if (testCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) { // Wenn der aktuelle Tag Sonntag ist dann Zeilenumbruch
                System.out.println("|");
            }
        }

    }
}

