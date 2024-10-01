package Akif_Malik.week04;

import java.util.Arrays;

import static Akif_Malik.week03.RandomNumberArrays.random;

public class Bubblesort {
    public static void main(String[] args) {
        int[] zahlen = createAndFillArray(10);
        System.out.println(Arrays.toString(zahlen));
        ascending(zahlen);
        System.out.println(Arrays.toString(zahlen));
        descending(zahlen);
        System.out.println(Arrays.toString(zahlen));
    }


    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101);
        }
        return result;
    }

    public static void ascending (int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void descending (int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
