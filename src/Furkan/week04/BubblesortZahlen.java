package Furkan.week04;

import java.util.Arrays;

public class BubblesortZahlen {
    public static void main(String[] args) {
        int[] arr = Furkan.week04.RandomNumberArrayMinMaxAvg.createArrayRandom(10);
        System.out.println(Arrays.toString(arr));
        bubbleSortAufsteigend(arr);
        System.out.println(Arrays.toString(arr));
        bubbleSortAbsteigend(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void bubbleSortAufsteigend(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void bubbleSortAbsteigend(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length -1; j++) {
                if (arr[j] < arr[j+1]){
                    swap(arr, j , j+1);
                }
            }
        }


    }

}
