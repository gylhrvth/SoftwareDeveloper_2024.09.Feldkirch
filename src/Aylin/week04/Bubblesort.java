package Aylin.week04;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = Aylin.week03.RandomNumberArray.randomNumber(10);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        int[] arrayCopyForSort = Arrays.copyOf(arr, arr.length);
        bubblesort(arrayCopyForSort);
        System.out.println();
        int[] arrayCopyForBackwardsSort = Arrays.copyOf(arr, arr.length);
        bubblesortBackwards(arrayCopyForBackwardsSort);
    }

    public static void bubblesort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
//                    System.out.println(Arrays.toString(arr));
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    System.out.println(j + " und " + (j + 1) + " müssen getauscht werden");
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubblesortBackwards(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] < arr[j + 1]){
//                    System.out.println(Arrays.toString(arr));
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
//                    System.out.println(j + " und " + (j + 1) + " müssen getauscht werden");
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
