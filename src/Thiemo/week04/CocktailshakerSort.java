package Thiemo.week04;

import Gyula.week04.BubbleSortExample;

import java.util.Arrays;

public class CocktailshakerSort {
    public static void main(String[] args) {

        int[] array = Thiemo.week03.RandomNumberArray.createAndFillArrayWithRandom(10);
        System.out.println("\n Original Array : \n" + Arrays.toString(array));
        System.out.println();
        cocktailShakerSort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void cocktailShakerSort(int[] array) {

        int low = 0, high = array.length - 1, move = low;

        while (low < high) {
            for (int i = high; i > low; i--) {
                if (array[i - 1] > array[i]) {
                    BubbleSortExample.swap(array, i - 1, i);
                    move = i;
                }
            }
            low = move;


            for (int i = low; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    BubbleSortExample.swap(array, i, i + 1);
                    move = i;
                }
            }
            high = move;
        }
    }
}

