package Akif_Malik.week06;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/*
    ToDo

    1. Ausdruck alle Zahlen zwischen 1 bis 35 in einer Zeile, formatiert mit | zeichen
    2. Eingrenzen das Zyklus auf letzten Tag des Monates
    3. Zeilenumbruch bei jeden 7 Tag. (Modulo 7 ist gleich Zero)
    4. Test Calendar Erstellen mit der Kopie von Datum aus dem original (setTime)
    5. Test Calendar auf TAG des Monates setzen (set)
    6. Überarbeiten Schritt 3, Zeilenumbruch wenn Test Calendar ist am Sonntag (get DAY_OF_WEEK)
    7. Leere Blöcke am Anfang ausdrucken
    7.a Test Calendar auf 1. des Monates setzen und einen Tag abziehen (add mit -1)
    7.b Solange testTag ist nicht Sonntag, leere Block drücken und einen Tag abziehen.
    8. Am Ende leere Blöcke drucken
    8.a Solange Test Calendar ist nicht am Sonntag, leere Block drücken und einen Tag addieren
    9 If block für den aktuellen Datum und * oder leerschlag drucken
    10. Kopfzeile ausdrucken
    11. Jahr und Monatname formatiert ausdrucken


 */

public class Calendar {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        int maxDay = gc.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);


        for (int i = 0; i < maxDay; i++) {
            System.out.print(i + " | ");
            if (i % 7 == 0) {
                System.out.println();
            }
        }


    }
}
