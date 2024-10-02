package Akif_Malik.week04;

import java.util.Arrays;

import static Akif_Malik.week03.RandomNumberArrays.random;

public class RandomNumberMinMaxAvg {
    public static void main(String[] args) {
        int[] zahlen = createAndFillArray(10);
        System.out.println(Arrays.toString(zahlen));

        System.out.println("Min Value found in this Array is at index position = " + minValue(zahlen));
        System.out.println();
        System.out.println("Max Value found in this Array is at index position = " + maxValue(zahlen));
        System.out.println();
        System.out.println("Avg Value found in this Array is at index position = " + avgValue(zahlen));
    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101);
        }
        return result;
    }

    public static int minValue(int[] arr) {
        int minValueArray = -1;
        for (int i = 0; i < arr.length; i++) {
            if ((minValueArray < 0) || (arr[i] < arr[minValueArray])) {
                minValueArray = i;
            }
        }
        return minValueArray;
    }

    public static int maxValue(int[] arr) {
        int maxValueArray = 1;
        for (int i = 0; i < arr.length; i++) {
            if ((maxValueArray > 0) || (arr[i] > arr[maxValueArray])) {
                maxValueArray = i;
            }
        }
        return maxValueArray;
    }

    public static int avgValue(int[] arr) {
        int avgValueArray = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((avgValueArray <= 1) || (arr[i] >= arr[avgValueArray])) {
                avgValueArray = i;
            }

        }
        return avgValueArray;
    }
}