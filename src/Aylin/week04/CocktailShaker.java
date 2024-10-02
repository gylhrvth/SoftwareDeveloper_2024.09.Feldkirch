package Aylin.week04;

import java.util.Arrays;

public class CocktailShaker {
    public static void main(String[] args) {
        int[] arr = Aylin.week03.RandomNumberArray.randomNumber(5);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        int[] arrayCopyForSort = Arrays.copyOf(arr, arr.length);
        cocktailShakerSort(arrayCopyForSort);
        System.out.println("Sortiertes Array: " + Arrays.toString(arrayCopyForSort));
    }

    public static void cocktailShakerSort(int[] arr){
        int lo = 0;
        int hi = arr.length - 1;
        int mov = lo;

        while(lo < hi){
            for (int i = lo; i < hi ; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    mov = i;
                }
            }
            hi = mov;

            for (int i = hi; i > lo ; i--) {
                if(arr[i] < arr[i - 1]){
                    swap(arr, i, i -1);
                    mov = i;
                }
            }
            lo = mov;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}