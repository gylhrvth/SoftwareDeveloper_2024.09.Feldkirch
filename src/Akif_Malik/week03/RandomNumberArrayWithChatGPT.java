package Akif_Malik.week03;

import java.util.Arrays;

import static Akif_Malik.week03.RandomNumberArrays.random;

public class RandomNumberArrayWithChatGPT {
    public static void main(String[] args) {

        int[] zahlen = createAndFillArray(5);
        System.out.println(Arrays.toString(zahlen));

        printArray(zahlen);
    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101); // Fill with random values between 0 and 100
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value); // Print the current element
            System.out.print(", "); // Print a comma after the element
        }
        System.out.println(); // Print a new line after the array
    }

}      // fixed by CHATGPT



