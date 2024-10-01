package Gyula.week04;

import java.util.Arrays;

public class CountOccurenceOfMin {
    public static void main(String[] args) {
        int[] arr = Gyula.week03.RandomNumbers.createRandomArray(0);
        System.out.println(Arrays.toString(arr));

        System.out.println("Minumum: " + getMinimum(arr));
        System.out.println("Occurence of Minimum: " + getMinimumOccurence(arr));
    }

    public static int getMinimum(int[] arr){
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public static int getMinimumOccurence(int[] arr){
        int minValue = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue){
                minValue = arr[i];
                count = 1;
            } else if (arr[i] == minValue){
                ++count;
            }
        }
        return count;
    }
}
