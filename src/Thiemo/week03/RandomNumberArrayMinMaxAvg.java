package Thiemo.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrayMinMaxAvg {

    public static Random randomGenerator = new Random(101);

    public static void main(String[] args) {
        int size = 10;

        int[] array = createAndFillArrayWithNumber(size);
        System.out.println();
        System.out.println(Arrays.toString(array));
        System.out.println();
        int min = findMin(array);
        System.out.println("Smallest Number = " + min);
        System.out.println();
        int max = findMax(array);
        System.out.println("Highest Number = " + max);
        System.out.println();
        int avg = findAvg(array,size);
        System.out.println("Averge Number = " + avg);
        System.out.println();
        int indexMin = findIndexMin(array);
        System.out.println("Index Number of Min = " + indexMin);
        System.out.println();
        int indexMax = findIndexMax(array);
        System.out.println("Index Number of Max" + indexMax);
        System.out.println();
    }

    public static int[] createAndFillArrayWithNumber(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(101);
        }

        return array;
    }

    public static int findMin(int[] value) {
        int min = value[0];

        for (int i = 1; i < value.length; i++) {
            if (value[i] < min) {
                min = value[i];
            }
        }

//        for (int num : value) {
//            if (num < min) {
//                min = num;
//            }
//        }
        return min;

    }

    public static int findMax(int[] array) {

        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }


        return max;
    }

    public static int findAvg(int[] value, int size) {
        int avg = 0;
        for (int sum : value) {
            avg += sum;

        }


        return avg/size;
    }

    public static int findIndexMin(int[] indexMin) {
        int min = indexMin[0];

        for (int i = 0; i < indexMin.length; i++) {
            if (indexMin[i] < min) {
                min = indexMin[i];
            }
        }
        return min;
    }

    public static int findIndexMax(int[] indexMax) {
        int max = indexMax[0];

        for (int i = 0; i < indexMax.length; i++) {
            if (indexMax[i] < max) {
                max = indexMax[i];
            }
        }
        return max;

    }
}

