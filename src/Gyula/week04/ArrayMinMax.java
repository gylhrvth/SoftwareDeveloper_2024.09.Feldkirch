package Gyula.week04;

import java.util.Arrays;

public class ArrayMinMax {
    public static void main(String[] args) {
        int[] array = Gyula.week03.RandomNumbers.createRandomArray(10);
        System.out.println(Arrays.toString(array));

        System.out.println("Index of min value: " + findIndexOfMinValue(array));
        System.out.printf(
            "Index of min value: %s\n",
            findIndexOfMinValue(array));
    }

    public static int findIndexOfMinValue(int[] arr){
        int indexOfMinValue = -1;
        for (int i = 0; i < arr.length; i++) {
            if ((indexOfMinValue < 0) || (arr[i] < arr[indexOfMinValue])){
                indexOfMinValue = i;
            }
        }
        return indexOfMinValue;
    }
}
