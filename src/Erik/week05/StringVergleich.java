package Erik.week05;

import java.util.Scanner;

public class StringVergleich {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Geben Sie String 1 ein:");
        String word = sc.nextLine();
        System.out.println("Geben Sie String 2 ein:");
        String word2 = sc.nextLine();

        System.out.println("== "+(word == word2)); // Versucht das Object im selben Speicher zu prüfen und vergleicht nicht die einzelnen Buchstaben ()vergleicht die Speicheradresse
        System.out.println("equals "+(word.equals(word2))); //Es vergleicht den Inhalt bzw jeder einzelne Buchstabe mit einander

        System.out.println("------------------------------");

        String test = "Hallo"; // Kommt vom selben Speicher, deswegen ist es true
        System.out.println(test == test);

        System.out.println("------------------------------");
    }
}
