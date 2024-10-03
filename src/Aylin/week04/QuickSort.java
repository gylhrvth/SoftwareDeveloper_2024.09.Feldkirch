package Aylin.week04;

import Sandro.Colors;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = Aylin.week03.RandomNumberArray.randomNumber(10);
        System.out.println(Colors. COLORS[4] + "Sortiertes Array: " + Arrays.toString(arr));
        System.out.println();
        int n = arr.length - 1;
        quickSortAlg(arr, 0, n);
        System.out.println(Colors.COLORS[6] + "Sortiertes Array: " + Arrays.toString(arr) + Colors.RESET);
    }

    public static void quickSortAlg(int[] arr, int lo, int hi){
        if(lo < hi){
            int pi = partition(arr, lo, hi);
            quickSortAlg(arr, lo, pi - 1);
            quickSortAlg(arr, pi + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi){
        int pivot = arr[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot){
                i++;
                Aylin.week04.CocktailShaker.swap(arr, i, j);
            }
        }
        Aylin.week04.CocktailShaker.swap(arr, i + 1, hi);
        return i + 1;
    }
}
