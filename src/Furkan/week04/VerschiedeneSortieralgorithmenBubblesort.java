package Furkan.week04;

import java.util.Arrays;

public class VerschiedeneSortieralgorithmenBubblesort {
    public static void main(String[] args) {
        int[] arr = Furkan.week04.RandomNumberArrayMinMaxAvg.createArrayRandom(10);

        System.out.println(Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sortiertes Array:");
        System.out.println(Arrays.toString(arr));
        cocktailShakerSort(arr);
        System.out.println(Arrays.toString(arr));
        gnomeSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                swap(arr, i, minIndex);
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

    //-----------------------------------------------------------------------------------------------------------
    //habe ich mit hilfe von AI gemacht weiß nicht obs richtig ist!!!

    public static void cocktailShakerSort(int[] arr) {
        int min = 0;
        int max = arr.length - 1;
        int mov = min;
        boolean swapped = true;

        while (swapped) {
            swapped = false;
            for (int i = min; i < max; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, arr[i + 1]);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped=false;
            max--;

            for (int i = max; i > min; i--) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i, arr[i - 1]);
                }
                swapped = true;

            }
        }
        min++;
    }
//------------------------------------------------------------------------------------------------------------


    public static void gnomeSort(int [] arr) {
        int i = 2;

        while (i < arr.length - 1) {
            if (arr[i] > arr[i - 1]) {
                i++;
            } else
                swap(arr, i, i - 1);
            if (i > 2) {
                i--;
            }


        }
    }

}
