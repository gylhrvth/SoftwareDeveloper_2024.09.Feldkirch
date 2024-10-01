package Aylin.week03;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class ArrayMinMaxAvg {
    public static Random random = new Random();

    public static void main(String[] args) {
        int [] array = Aylin.week03.RandomNumberArray.randomNumber(10);
        System.out.println(Arrays.toString(array));
        System.out.println("Average: " + averageArray(array));
        System.out.println();

        int minValue = findMinValue(array);
        int index = findIndexOfMinValue(array);
        int counterMinValue = countMinValueOfArray(array);
        System.out.println("MinValue in this Array is: " + minValue);
        System.out.println("MinValue found in Position: " + index);
        System.out.print("MinValue found " + counterMinValue + " time(s) at position(s): ");
        printEveryPositionOfMinValue(array);

        int maxValue = findMaxValue((array));
        int indexMaxValue = findIndexOfMaxValue(array);
        int counter = countMaxValueOfArray(array);
        System.out.println("MaxValue in this Array is: " + maxValue);
        System.out.println("MaxValue found in Position: " + indexMaxValue);
        System.out.print("MaxValue found "+ counter + " time(s) at position(s): ");
        printEveryPositionOfMaxValue(array);
    }

    public static int findMinValue(int[] arr){
        int minValue = arr[0]; // TODO: Don't touch arr[0] as long it not checked if it's available....
                               // TODO: Define result for minValue of an empty array

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public static int findIndexOfMinValue(int[] arr){
        int indexOfMinValue = -1;
        for (int i = 0; i < arr.length ; i++) {
            if((indexOfMinValue < 0) || (arr[i] < arr[indexOfMinValue])){
                indexOfMinValue = i;
            }
        }
        return indexOfMinValue;
    }

    // TODO: Search in 1 for loop (compare value[i] and value[minPos]
    public static int countMinValueOfArray(int[] arr){
        int minValue = findMinValue(arr);
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == minValue) {
                counter++;
            }
        }
        return counter;
    }

    public static void printEveryPositionOfMinValue(int[] arr){
        int minValue = findMinValue(arr);
        int size = countMinValueOfArray(arr);

        int[] index = new int[size];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if((counter < size) && (arr[i] == minValue)){
                index[counter] = i;
                counter++;
            }
        }
        System.out.println(Arrays.toString(index));
        System.out.println();
    }

    public static int findMaxValue(int[] arr){
        int maxValue = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static int findIndexOfMaxValue(int[] arr) {
        int findIndexOfMaxValue = -1;
        for (int i = 0; i < arr.length; i++) {
            if ((findIndexOfMaxValue < 0 ) || (arr[i] > arr[findIndexOfMaxValue])) {
                findIndexOfMaxValue = i;
            }
        }
        return findIndexOfMaxValue;
    }

    public static int countMaxValueOfArray(int[] arr){
        int maxValue = findMaxValue(arr);
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == maxValue) {
                counter++;
            }
        }
        return counter;
    }

    public static void printEveryPositionOfMaxValue(int[] arr){
        int maxValue = findMaxValue(arr);
        int size = countMaxValueOfArray(arr);

        int[] index = new int[size];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == maxValue){
                index[counter] = i;
                counter++;
            }
        }
        System.out.println(Arrays.toString(index));
    }

    public static float averageArray(int[] arr){
        float average = 0f;
        for (int value : arr) {
            average += value ;
        }
        return average/arr.length;
    }
}
