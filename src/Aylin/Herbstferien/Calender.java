package Aylin.Herbstferien;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Calender {
    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        System.out.println("======== Aufgabe 1.1 ========");
        SimpleDateFormat sdf = new SimpleDateFormat("EE dd.MM.yyyy");
        System.out.println(sdf.format(gc.getTime()).toUpperCase());
        System.out.println();
        System.out.println("======== Aufgabe 1.2 ========");
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MMMyyyy");
        System.out.println(sdf1.format(gc.getTime()));
        System.out.println();
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
        System.out.println(sdf2.format(gc.getTime()));
        System.out.println();
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");    //Zeitzone nicht gewusst
        System.out.println(sdf3.format(gc.getTime()));
        System.out.println();
        SimpleDateFormat sdf4 = new SimpleDateFormat("mm:ss:SS");
        System.out.println(sdf4.format(gc.getTime()));
    }
}
