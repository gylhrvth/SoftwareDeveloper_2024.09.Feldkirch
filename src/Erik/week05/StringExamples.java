package Erik.week05;

import java.util.Locale;

public class StringExamples {

    public static void main(String[] args) {

        String name1 = "Erik";
        String name2 = "Aylin";
        String name3 = "Furkan";

        System.out.println("---");
        System.out.println(name1 + " compareTo " + name1.compareTo(name2) + " " + name2);
        System.out.println(name1 + " compareTo " + name1.compareTo(name3) + " " + name3);
        System.out.println("---");


        String string = "Hello";
        char letter = string.charAt(2); // Gibt mir den 2 Index Wert von meinem String zurück
        System.out.println("2. Index von " + string + " ist: " + letter);

        System.out.println("---");

        String[] names = {"Thiemo, Sandro, Gyula, Furkan, Erik, Aylin, Akif"};


        for (int i = 0; i < names.length ; i++) {
            System.out.println(names[i]);
        }

        System.out.println("---");
        System.out.println("Name Repeat: " + name1.repeat(3)); // Repeat geht nur auf einzelne Strings und nicht auf String[]
        System.out.println("---");

        System.out.println("String name3 in Capslock ist: " + name3.toUpperCase(Locale.ROOT) + "\n---"); // Gibt den String Wert in Capslock aus
        System.out.println("String name2 in small letters ist: " + name2.toLowerCase(Locale.ROOT) + "\n---"); // Gibt den String in Kleinbuchstaben aus

        System.out.println("Wie lange ist der Name Furkan? " + name3.length() + " Zeichen \n---"); // Gibt mir die Länge des Strings an.

        String charTest = "Hello World!";
        char[] charArray = charTest.toCharArray(); //Verwandelt den String "charTest" in ein Array und jeder Index bekommt ein Buchstabe Array ist so lang wie der String

        for (char test : charArray) {
            System.out.print(test);
        }
        System.out.println();
        System.out.println("---");

        String trimTest = "               Hallo wie geht es dir?        ";
        System.out.println("Original: " + trimTest);
        System.out.println("Trimmed Version: " + trimTest.trim() + "\n---"); // Trimmt mir die Leerzeichen im String am Anfang und am Ende NICHT da zwischen!

        String testSubString = "Emoji";
        System.out.println("Kompletter String: " + testSubString + "\nString ab dem 2.Index: " + testSubString.substring(2) + "\n---"); // Gibt mir die restlichen Buchstaben nach dem 2. Index

        String hash = "Alter";
        System.out.println(hash.hashCode()); // Verwandelt meinen String in ein Hash Code

        String blank = "";
        String full = "F";
        System.out.println(blank.isBlank()); // Schaut durch ob der String befüllt ist und gibt False oder True zurück.
        System.out.println(full.isBlank());


    }
}
