package Akif_Malik.week05;
/*
                    ToDo: 1. Scanner importieren
                          2. eine String userInput erstellen
                          3. text.toCharArray verwenden für das Aufsplitten
                          4. eine neue char[] erstellen mit userInput drinnen
                          5. Alles zusammenfügen mit new String(charArray)
                          6. Das Lösung ausgeben
 */
import java.util.Random;
import java.util.Scanner;

public class StringRandomizer {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Give me a word");
        System.out.print(">>> ");
        String userInput = sc.nextLine();
        RandomUserInput(userInput);
    }

    public static void RandomUserInput(String userInput) {
        char[] charArr = userInput.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[rand.nextInt(userInput.length())];
            charArr[userInput.length() - 1 - i] = temp;
        }
        String randomizedUserInput = new String(charArr);
        System.out.println(randomizedUserInput);
    }
}