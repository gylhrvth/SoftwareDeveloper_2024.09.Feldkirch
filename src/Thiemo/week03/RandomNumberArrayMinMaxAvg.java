package Thiemo.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrayMinMaxAvg {

    static Random randomGenerator = new Random();

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
        int avg = findAvg(array, size);
        System.out.println("Averge Number = " + avg);
        System.out.println();
        int indexMin = findIndexMin(array);
        System.out.println("Index position of smallest Number  = " + indexMin);
        System.out.println();
        int indexMax = findIndexMax(array);
        System.out.println("Index Position of highest Number = " + indexMax);
        System.out.println();
        int counter = count(array);
        System.out.println("Counter = " + counter);
        System.out.println();
        int moreThan1Index = findMorethan1Index(array);
        System.out.println("How often and which Position = " + moreThan1Index);
    }

    public static int[] createAndFillArrayWithNumber(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(5);
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
        int max = 0;
        if (array.length > 0) {
            max = array[0];

            for (int i = 0; i < array.length; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }
        return max;
    }

    public static int findAvg(int[] value, int size) {
        int avg = 0;
        for (int sum : value) {
            avg += sum;

        }


        return avg / size;
    }

    public static int findIndexMin(int[] indexMin) {
        int index = 0;
//        int min = indexMin[index];

        for (int i = 0; i < indexMin.length; i++) {
            if (indexMin[i] < indexMin[index]) {                            ////if add >= instead of > it will give the last lowest number in array

                index = i;
//                index = i;
            }
        }
        return index;
    }

    public static int findIndexMax(int[] indexMax) {
        int index = 0;
        for (int i = 0; i < indexMax.length; i++) {
            if (indexMax[i] > indexMax[index]) {                                     //if add >= instead of > it will give the last highest number in array

                index = i;
            }

        }
        return index;

    }

    public static int count(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == count) {
                count++;
            }
        }
        return count;
    }


    public static int findMorethan1Index(int[] morethan1Index) {
        int morethan1 = 0;


        return morethan1;
    }
}

