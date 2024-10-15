package Thiemo.week06;

import java.util.Random;
import java.util.Scanner;

    /*
        Todo:   1. Scanner erstellen
                2. User Input abfragen
                3. User Input mit text.toCharArray() aufteilen/splitten (User Input wird in ein CharArray umgewandelt)
                4. for i schleife User Input durchgehen
                5. Swap methode (zum tauschen der Buchstaben)
                6. charArray zurück in ein String umwandeln | new String(charArray)
                7. Print Endergebnis
 */


public class StringReverseAndRandomize {


    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Gib etwas ein: ");
        String userInput = sc.nextLine();

        String result = reverse(userInput);
        System.out.println(result);

        System.out.println(randomize(userInput));
    }

    public static String reverse(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
        return new String(arr);
    }

    public static String randomize(String text) {
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length * 5; i++) {
            swap(arr, rand.nextInt(arr.length), rand.nextInt(arr.length));
        }
        return new String(arr);
    }

    public static void swap(char[] arr, int pos1, int pos2) {
        char temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}


