package Gyula.week04;

import java.util.Arrays;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] arr = Gyula.week03.RandomNumbers.createRandomArray(100);

        System.out.println(Arrays.toString(arr));
        // swap(arr, 0, 1);
        // System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
