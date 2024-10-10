package Aylin.week05;

import java.util.Scanner;

public class BonuseStringVergleich {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Geben Sie String 1 ein:");

        String a = "Hallo";
        String b = "Hallo";
        String word = sc.nextLine();
        System.out.println("Geben Sie String 2 ein:");
        String word2 = sc.nextLine();

        System.out.println("== "+(word == word2));
        System.out.println("equals "+(word.equals(word2)));
        System.out.println();
        System.out.println("String Vergleich - Bonus");
        System.out.println("== "+(a == b));
    }
}
