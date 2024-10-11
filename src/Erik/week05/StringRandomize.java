package Erik.week05;

/*
        Todo:   1. Scanner erstellen ♥
                2. User Input abfragen ♥
                3. char[] erstellen
                4. text.toCharArray User Input aufsplitten
                5. char [] mit zufälligen buchstaben befüllen
                6. char [] wieder in einen String umwandeln (new String(charArray))
                7. Neuer String ausgeben.
 */

import java.util.Random;
import java.util.Scanner;

public class StringRandomize {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Gib ein Wort ein:");
        System.out.print(">> ");

        String userInput = sc.nextLine();
        randomizeString(userInput);


    }

    public static void randomizeString(String userInput) {
        Random rand = new Random();
        char[] charArr = new char[100];

//        for (int i = 0; i < charArr.length; i++) {
//            charArr[i] = (char) ('a' + rand.nextInt('z' - 'a'));
//        }

        for (int i = 0; i < charArr.length / 2; i++) {
            char temp = charArr[rand.nextInt(userInput.length())]; // <--- Randomizer anstelle des [i] einfügen
            charArr[i] = charArr[charArr.length - 1 - i];
            charArr[charArr.length - 1 - i] = temp;
        }

        String randomizeUserInput = new String(charArr);

        System.out.println(randomizeUserInput);

    }
}
