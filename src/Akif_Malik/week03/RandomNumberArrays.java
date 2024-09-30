package Akif_Malik.week03;

import Sandro.Colors;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrays {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] zahlen = createAndFillArray(10);
        System.out.println(Arrays.toString(zahlen));
        printArray(zahlen);
        System.out.println(Colors.COLORS[6] + "----------------------" + Colors.RESET);

        System.out.println(zahlen[1] + " zweite wert");
        System.out.println(zahlen[4] + " fünfte wert");
        System.out.println(zahlen[9] + " zehnte wert");

        System.out.println(Colors.COLORS[6] + "----------------------" + Colors.RESET);

        printArray2(zahlen);

        System.out.println();
        System.out.println(Colors.COLORS[6] + "-----------------------" + Colors.RESET);

        printSecondArray(zahlen);

    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101);
        }
        return result;
    }

    public static void printArray(int[] arr) {
        boolean firstValue = true;
        System.out.print("[");
        for (int value : arr) {
            if (!firstValue) {
                System.out.print(", ");
            }
            System.out.print(value);
            firstValue = false;
        }
        System.out.println("]");
    }

    public static void printArray2(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void printSecondArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                System.out.print(", ");
                System.out.print(arr[i]);
            }
        }
        System.out.print("]");
    }
}