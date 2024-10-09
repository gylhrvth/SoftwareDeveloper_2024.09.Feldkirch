package Thiemo.week05;

import java.util.Scanner;

public class StringVergleich {

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {



        System.out.println("Geben Sie String 1 ein:");
        String word = sc.nextLine();
        System.out.println("Geben Sie String 2 ein:");
        String word2 = sc.nextLine();

        System.out.println("== " + (word == word2));             // checks if the String is the same??
        System.out.println("equals " + (word.equals(word2)));   // checks if the content of the string is the same
    }
}