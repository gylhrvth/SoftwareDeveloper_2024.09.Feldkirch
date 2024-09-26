package Furkan.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib die Größe des Arrays ein:", 0, 100);
        int[] arr = createAndFillArray(size);
        System.out.println(Arrays.toString(arr));

        System.out.println("schau bestimmter index an....");
        System.out.println(arr[0]);

        arr[0] = 13;

        int [] copy = new int[size];
        System.out.println(Arrays.toString(copy));

        copy[1] = arr[1];

        System.out.println(Arrays.toString(arr));
        int[] reverseArray = reverseArray(size);
        System.out.println("Reversed Array: " + Arrays.toString(reverseArray));
    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] =  i;
        }
        return result;
    }

    public static int[] reverseArray(int size) {
        int[] reversed = new int[size];
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = reversed.length - 1 - i;
        }
        return reversed;
    }


}





