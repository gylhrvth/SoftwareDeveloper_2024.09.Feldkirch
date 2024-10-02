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
        int indexMin = findIndexMin(array);
        System.out.println("Index position of first smallest Number  = " + indexMin);
        int[] positionsMin = findMinPositions(array);
        System.out.println("Positions = " + Arrays.toString(positionsMin));
        int counter = countMinValue(array);
        System.out.println("Counter = " + counter);
        System.out.println();
        int max = findMax(array);
        System.out.println("Highest Number = " + max);
        int indexMax = findIndexMax(array);
        System.out.println("Index Position of first highest Number = " + indexMax);
        int[] positionsMax = findMaxPositions(array);
        System.out.println("Positions of Max Value = " + Arrays.toString(positionsMax));
        int counter2 = countMaxValue(array);
        System.out.println("Counter = " + counter2);
        System.out.println();
        int avg = findAvg(array, size);
        System.out.println("Averge Number = " + avg);
        System.out.println();


    }

    public static int[] createAndFillArrayWithNumber(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(5);
        }

        return array;
    }

    public static int findMin(int[] array) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

//        for (int num : array) {
//            if (num < min) {
//                min = num;
//            }
//        }
        return min;

    }

    public static int findMax(int[] array) {
        int max = Integer.MIN_VALUE;


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

    public static int countMinValue(int[] array) {
        int count = 0;
        int findMin = findMin(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findMin) {
                count++;
            }
        }
        return count;
    }


    public static int countMaxValue(int[] array) {
        int count = 0;
        int findMax = findMax(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == findMax) {
                count++;
            }
        }
        return count;
    }

    public static int[] findMinPositions(int[] array) {
        int min = findMin(array);
        int arraysize = countMinValue(array);

        int[] indexposition = new int[arraysize];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                indexposition[counter] = i;
                counter++;
            }
        }
        return indexposition;
    }

    public static int[] findMaxPositions(int[] array) {
        int max = findMax(array);
        int arraysize = countMaxValue(array);

        int[] indexposition = new int[arraysize];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) {
                indexposition[counter] = i;
                counter++;
            }
        }
        return indexposition;
    }
}
