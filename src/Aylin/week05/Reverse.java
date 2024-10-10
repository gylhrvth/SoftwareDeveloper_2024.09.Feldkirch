package Aylin.week05;

import java.util.Random;
import java.util.Scanner;

public class Reverse {
    public static Scanner sc = new Scanner(System.in);

    public static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Welcome to reverse program!!!");
        System.out.print(">>>");
        String textUser = sc.nextLine();
        System.out.println(reverse(textUser));
        System.out.println();
        System.out.println("Welcome to random shuffle!!!");
        System.out.print(">>>");
        System.out.println(randomize(textUser));
    }


    public static String reverse(String text) {
        char[] charArray = text.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }

    public static String randomize(String text) {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int randomly = random.nextInt(charArray.length);
            char temp = charArray[i];
            charArray[i] = charArray[randomly];
            charArray[randomly] = temp;
        }
        return new String(charArray);
    }
}
