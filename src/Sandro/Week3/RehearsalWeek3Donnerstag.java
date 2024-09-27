package Sandro.Week3;

import java.util.Random;

public class RehearsalWeek3Donnerstag {

    static Random rand = new Random();

    public static void main(String[] args) {

        int[] testArray = createRandomNumbArray(10);
        printDividerLine("Choose Index from Array and Print");
        printArrayWithForI(testArray);
        printAnyIndex(testArray, 4, 6, 14);
        printDividerLine("Print Array in Steps");
        printArrayWithForEach(testArray);
        printSteps(testArray, 2);
        printDividerLine("MaxValue Example");
        printArrayWithForI(testArray);
        int max = maxValue(testArray);
        System.out.println("Max Value found in this Array is = " + max);
        int[] index = findIndexMax(testArray, max);
        System.out.print("Index position found the highest Number: ");
        printArrayWithForI(index);
        int maxIndex = findMaxValue(testArray);
        System.out.println("Max Value found at " + maxIndex);

    }

    public static int maxValue(int[] arr) {
        int max = 0;
        if (arr.length > 0) {
            max = arr[0];

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }

    public static int[] findIndexMax(int[] arr, int max) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                counter++;
            }
        }
        int index = 0;
        int[] indexArr = new int[counter];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                indexArr[index] = i;
                index++;
            }

        }
        return indexArr;
    }

    public static int findMaxValue(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        return index;
    }

    public static void printDividerLine(String text) {
        int charcounter = text.length();
        int linecounter = 50;
        String symbol = "#";
        int left = 0;
        int right = 0;
        if (charcounter % 2 == 0) {
            left = (linecounter - charcounter) / 2;
            right = (linecounter - charcounter) / 2;
        } else {
            left = ((linecounter - charcounter) / 2);
            right = ((linecounter - charcounter) / 2);
        }

        System.out.println(symbol.repeat(left) + text + symbol.repeat(right));

    }

    private static void printSteps(int[] arr, int step) {
        for (int i = 0; i < arr.length; i++) {
            if (i % step == 0) {
                System.out.println("Position " + (i + 1) + ") " + "Index " + i + " -- > [" + arr[i] + "]");
            }
        }

    }

    private static void printAnyIndex(int[] arr, int index1, int index2, int index3) {
        if (index1 > arr.length) {
            System.out.println("Your input [" + index1 + "] could not be processed!");
        } else if (index2 > arr.length) {
            System.out.println("Your input [" + index2 + "] could not be processed!");
        } else if (index3 > arr.length) {
            System.out.println("Your input [" + index3 + "] could not be processed!");
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == index1 - 1 || i == index2 - 1 || i == index3 - 1) {
                System.out.println("Position " + (i + 1) + ") " + "Index " + i + " -- > [" + arr[i] + "]");
            }
        }
    }

    public static void printArrayWithForEach(int[] arr) {
        int counter = 0;
        System.out.print("[");
        for (int number : arr) {
            if (counter == 0) {
                System.out.print(number);
            } else {
                System.out.print(", " + number);
            }
            counter++;
        }
        System.out.print("]");
        System.out.println();
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
