package Aylin.week04;

import java.util.Arrays;

public class GnomeSort {
    public static void main(String[] args) {
        int[] arr = Aylin.week03.RandomNumberArray.randomNumber(5);
        System.out.println(Arrays.toString(arr));
        System.out.println();
        int[] arrayCopyForSort = Arrays.copyOf(arr, arr.length);
        gnomeAlg(arrayCopyForSort);
        System.out.println("Sortiertes Array: " + Arrays.toString(arrayCopyForSort));
    }

    public static void gnomeAlg(int[] arr){
        int i = 1;
        while(i < arr.length){
            if(arr[i] >= arr[i - 1]){
                i++;
            }else{
                Aylin.week04.CocktailShaker.swap(arr, i, i - 1);
                if(i > 1){
                    i--;
                }
            }
        }
    }
}
