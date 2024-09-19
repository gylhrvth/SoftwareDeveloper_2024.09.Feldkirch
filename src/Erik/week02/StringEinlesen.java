package Erik.week02;

import java.util.Scanner;

public class StringEinlesen {
    public static void main(String[] args) {
        String country = "";        //Leerer String namens Country
        String name = "";           //Leerer String names Name
        String age = "";            //Leerer String namens Age
        String color = "";
        int wert = 0;

        country = readString("Where do you live?");
        System.out.println("You're coming from " + country + "!");
        name = readString("What's your name?");
        System.out.println("Hello " + name + " Welcome!");
        age = readString("How old are you?");
        System.out.println("You're " + age + " years old.");
        color = readString("What's your favourite Color?");
        System.out.println("Your favourite Color is " + color + "!");
        wert = giveInt(wert,"Give me a Value");
        System.out.println(wert + 1);


/*
        String test = "---------";
        System.out.println(test);
        System.out.println("Bitte gib einen Text ein ");
        test = readString("Test");
        System.out.println();
        System.out.println(test);
        System.out.println();
        System.out.println("Danke für diesen tollen Text");
        System.out.println();
*/

    }

    public static String readString(String msg) {           // Methode erstellt; gibt/braucht einen Rückgabewert kann kontinurlich verwendet werden "text wird immer wieder neu deiniert
        System.out.println(msg);                            // Printet eine Message für dich das du weißt was du eingeben musst
        String text = "";                                   // String Variable angelegt mit dem Namen "text" ohne Wert/Inhalt
        Scanner sc = new Scanner(System.in);                // Scanner Aufruf mit dem Namen sc
        text = sc.nextLine();                               // Füllt den String "text" mit dem eingegebem Wert ein und wartet auf die Rückgabe
        return text;                                        // Gibt den Rüchgabewert zurück
    }
    public static int giveInt(int wert, String msg){
        System.out.println(msg);
        wert = 0;
        Scanner sc = new Scanner(System.in);
        wert = sc.nextInt();
        return wert;
    }
}
