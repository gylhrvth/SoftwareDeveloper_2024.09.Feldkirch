package Aylin.week04;

import java.util.Arrays;

public class CocktailShaker {
    public static void main(String[] args) {
        int[] arr = Aylin.week03.RandomNumberArray.randomNumber(5);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        int[] arrayCopyForSort = Arrays.copyOf(arr, arr.length);
        System.out.println("Sortiertes Array: " + Arrays.toString(arrayCopyForSort));
    }

    public static void cocktailShakerSort(int[] arr){
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;

        while(swapped){
            swapped = false;
            for (int i = start; i < end ; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
            end--;

            swapped = false;

            for (int i = end; i > start ; i--) {
                if(arr[i] < arr[i - 1]){
                    swap(arr, i, i -1);
                    swapped = true;
                }
            }
            start++;
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}