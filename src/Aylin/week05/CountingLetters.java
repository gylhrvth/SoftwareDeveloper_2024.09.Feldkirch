package Aylin.week05;

import java.util.Arrays;

public class CountingLetters {
    public static void main(String[] args) {
        System.out.println(data.Texts.getSimpleText());
        String text = data.Texts.getSimpleText();
        int[] arr = countCharacters(text);
        printCharacters(arr, 100);
    }

    public static int[] countCharacters(String text){
        int[] datenbank = new int[Character.MAX_VALUE];
        for (int i = 0; i < text.length(); i++) {
            ++datenbank[text.charAt(i)];
        }
        return datenbank;
    }

    public static void printCharacters(int[] arr, int counter){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > counter){
                System.out.printf("%-5c ---> %5d - %d", (char)i, i, arr[i]);
                System.out.println();
            }
        }
    }
}
