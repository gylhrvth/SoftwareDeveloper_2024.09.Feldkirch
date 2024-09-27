package Sandro.Week3;

import java.util.Arrays;
import java.util.Random;

public class MinMaxAvg {
    static Random rand = new Random();

    public static void main(String[] args) {
        int[] randomArray = createRandomNumbArray(10);
        int[] test = createRandomNumbArray(0);
        printArrayWithForI(randomArray);
        int maxValue = findMaxValue(randomArray);
        int countMax = countMaxValue(randomArray, maxValue);
        int[] indexMax = findIndexOfValue(randomArray, maxValue, countMax);


        printMaxStatistics(maxValue, countMax, indexMax);

    }

    public static void printMaxStatistics(int maxValue, int maxCounter, int[] index) {

        System.out.println("The max Value is  : " + maxValue);
        System.out.println("Max Value found   : " + maxCounter);
        System.out.println("Position of Index : " + Arrays.toString(index));

    }

    public static int countMaxValue(int[] arr, int maxValue) {
        int count = 0;


        return count;
    }

    public static int findMaxValue(int[] arr) {
        //int maxValue = 0;
        int maxValue = arr[0];                                           //Why is 0 not good? What happens if you use arr[0] instead and you get a empty Array?
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }
        return maxValue;
    }


    public static int[] findIndexOfValue(int[] arr, int value, int count) {
        int[] indexArr = new int[count];


        return indexArr;
    }


    public static void printArrayWithForI(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }

        }
        System.out.print("]");
        System.out.println();
    }

    public static int[] createRandomNumbArray(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(80, 101);
        }
        return arr;
    }
}
