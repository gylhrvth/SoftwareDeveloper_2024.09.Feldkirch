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

        System.out.println(randomizeString(userInput));
    }

    public static String randomizeString(String userInput) {
        Random rand = new Random();
        char[] charArr = userInput.toCharArray();
        int random = rand.nextInt(charArr.length);

        for (int i = 0; i < charArr.length; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[random]; // <--- Randomizer anstelle des [.length] einfügen
            charArr[random] = temp;
        }
        String randomizeUserInput = new String(charArr);

        return randomizeUserInput;
    }

}
