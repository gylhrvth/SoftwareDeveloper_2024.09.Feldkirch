package Furkan.week04;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrayMinMaxAvg {

    static Random rand = new Random();

    public static void main(String[] args) {
        int size = 10;
        int[] arrayRandom = createArrayRandom(size);
        System.out.println(Arrays.toString(arrayRandom));
        System.out.println("Minimum ist: " + findMinValue(arrayRandom));
        System.out.println("Maximum ist: " + findMaxValue(arrayRandom));
        System.out.println("Durchschnitt ist: " + findAvgValue(size, arrayRandom));
        System.out.println("Index Minimum ist: " + findIndexMin(arrayRandom));
    }

    public static int[] createArrayRandom(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(0, 101);

        }
        return arr;
    }

    public static int findMinValue(int[] arr) {
        int minValue = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];

            }

        }
        return minValue;
    }

    public static int findMaxValue(int[] arr) {
        int maxValue = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }

        }
        return maxValue;
    }


    public static int findAvgValue(int size, int[] arr) {
        int avgValue = 0;

        for (int summe : arr) {
            avgValue += summe;
        }
        return avgValue / size;

    }

    public static int findIndexMin(int []indexMin){
        int index= 0;

        for (int i = 0; i < indexMin.length; i++) {
            if (indexMin[i] < indexMin[index]){
                index=i;
            }

        }
        return index;



    }

}



