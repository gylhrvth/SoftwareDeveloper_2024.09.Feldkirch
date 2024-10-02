package Gyula.week04;

import Erik.week04.Bubblesort;

import java.util.Arrays;

public class CocktailShaker {
    public static void main(String[] args) {
        int[] arr = Gyula.week03.RandomNumbers.createRandomArray(10);
        System.out.println(Arrays.toString(arr));
        cocktailShakerSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cocktailShakerSort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        int mov = lo;
        while (lo < hi){
            for (int i = hi; i > lo; i--) {
                if (arr[i - 1] > arr[i]){
                    BubbleSortExample.swap(arr, i-1, i);
                    mov = i;
                }
            }
            lo = mov;

            for (int i = lo; i < hi; i++) {
                if (arr[i] > arr[i + 1]){
                    BubbleSortExample.swap(arr, i, i+1);
                    mov = i;
                }
            }
            hi = mov;
        }
    }
}
