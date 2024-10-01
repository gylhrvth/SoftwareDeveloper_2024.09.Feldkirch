package Aylin.week04;

import java.util.Arrays;

public class Bubblesort {
    public static void main(String[] args) {
        int [] arr = Aylin.week03.RandomNumberArray.randomNumber(20);
        bubblesort(arr);
    }

    public static void bubblesort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    System.out.println(Arrays.toString(arr));
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println(j + " und " + (j + 1) + " müssen getauscht werden");
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
