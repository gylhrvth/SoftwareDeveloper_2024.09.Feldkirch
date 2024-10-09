package Akif_Malik.week04;

import java.util.Arrays;

import static Akif_Malik.week03.RandomNumberArrays.random;

public class Sortieralgorithmen {
    public static void main(String[] args) {
        System.out.println("Sortier Algorithme 1");
        int[] array = createAndFillArray(10);
        System.out.println(Arrays.toString(array));

    }


    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101);
        }
        return result;
    }


    public static void heapSort(int[] array){

    }

}
