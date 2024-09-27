package Aylin.week03;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class ArrayMinMaxAvg {
    public static Random random = new Random();

    public static void main(String[] args) {
        int size = 4;
        int [] array = randomNumber(size);
        System.out.println(Arrays.toString(array));
        System.out.println("Average: " + averageArray(array, size));
        System.out.println();

        findMinValue(array);
        System.out.println("MinValue in this Array is: " + findMinValue(array));

        findIndexOfMinValue(array, findMinValue(array));
        int minValue = findMinValue(array);
        int index = findIndexOfMinValue(array, minValue);
        int counterMinValue = countMinValueOfArray(array, minValue);
        System.out.println("MinValue found in Position: " + index);
        System.out.print("MinValue found " + counterMinValue + " time(s) at position(s): ");
        printEveryPositionOfMinValue(array, minValue, counterMinValue);
        System.out.println();

        findMaxValue(array);
        int maxValue = findMaxValue((array));
        int indexMaxValue = findIndexOfMaxValue(array, maxValue);
        int counter = countMaxValueOfArray(array, maxValue);
        System.out.println("MaxValue in this Array is: " + findMaxValue(array));
        System.out.println("MaxValue found in Position: " + indexMaxValue);
        System.out.print("MaxValue found "+ counter + " time(s) at position(s): ");
        printEveryPositionOfMaxValue(array, maxValue, counter);

    }

    public static int[] randomNumber(int size){
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    public static int findMinValue (int [] arr){
        int minValue = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }

    public static int findIndexOfMinValue(int[] arr, int minValue){
        int position = 0;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == minValue){
                position = i;
            }
        }
        return position;
    }

    public static int countMinValueOfArray(int[] arr, int minValue){
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == minValue) {
                counter++;
            }
        }
        return counter;
    }

    public static void printEveryPositionOfMinValue (int[] arr, int minValue, int size){
        int[] index = new int[size];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == minValue){
                index[counter] = i;
                counter++;
            }
        }
        System.out.println(Arrays.toString(index));
    }

    public static int findMaxValue (int [] arr){
        int maxValue = arr[0];

        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    public static int findIndexOfMaxValue(int[] arr, int maxValue) {
        int position = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxValue) {
                position = i;
            }
        }
        return position;
    }

    public static int countMaxValueOfArray(int[] arr, int maxValue){
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == maxValue) {
                counter++;
            }
        }
        return counter;
    }

    public static void printEveryPositionOfMaxValue (int[] arr, int maxValue, int size){
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

    public static int averageArray (int [] arr, int size){
        int average = 0;
        for (int value : arr) {
            average += value ;
        }
        return average/size;
    }
}
