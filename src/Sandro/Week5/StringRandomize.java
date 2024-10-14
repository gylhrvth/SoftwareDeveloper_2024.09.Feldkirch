package Sandro.Week5;

import java.util.Random;
import java.util.Scanner;

public class StringRandomize {
    static Random rand = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Word, to randomize it");
        String text = sc.nextLine();
        String randomWord = randoMyString(text);
        System.out.println(randomWord);
    }

    public static String randoMyString(String input) {
        char[] rando = input.toCharArray();

        for (int count = 0; count < 10 * rando.length + 3; count++) {
            int i = rand.nextInt(rando.length);
            int j = rand.nextInt(rando.length);
            char temp = rando[i];
            rando[i] = rando[j];
            rando[j] = temp;
        }

        return new String(rando);
    }
}
