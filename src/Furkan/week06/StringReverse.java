package Furkan.week06;

/*
  Todo:   1. Scanner importieren
                    2. userInput einlesen
                    3. mit text.toCharArray aufsplitten
                    4. das userInput umdrehen
                    4.1 swap von bubblesort abholen
                    4.2 int temp zur char temp ändern
                    4.3 userInput mit charArray wechseln
                    5. alles mit new String(charArray) zusammenfügen.
                    6. aus print funktion erstellen
                    7. methode in main rufen



 */

import java.util.Scanner;

public class StringReverse {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Gib mir ein Wort zum umdrehen");
        String userInput = "";
        userInput = scanner.nextLine();
        String reversedUserInput = reverse(userInput);
        System.out.println(reversedUserInput);
    }

    public static String reverse(String text) {
        char[] charArray = text.toCharArray();

        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - 1 - i];
            charArray[charArray.length - 1 - i] = temp;
        }
        return new String(charArray);
    }
}
