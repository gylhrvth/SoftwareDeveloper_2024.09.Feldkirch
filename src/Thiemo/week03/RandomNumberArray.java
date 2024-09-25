package Thiemo.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArray {

    public static Random randomGenerator = new Random();

    public static void main(String[] args) {

        int[] array = createAndFillArrayWithRandom(9);
        System.out.println(Arrays.toString(array));
        System.out.println();
        printArrayforeach(array);
        System.out.println();
        printArray2fori(array);
        System.out.println();
        printOutValue(array);
        System.out.println();
        printOutEvery2Value(array);
    }


    public static int[] createAndFillArrayWithRandom(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = randomGenerator.nextInt(101);
        }
        return result;
    }

    public static void printArrayforeach(int[] array) {
        boolean richtigeEingabe = true;
        System.out.print("[");
        for (int foreach : array) {
            if (!richtigeEingabe) {
                System.out.print(", ");
            }
            System.out.print(foreach);
            richtigeEingabe = false;
        }

        System.out.println("]");
    }

    public static void printArray2fori(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);

        }
        System.out.println("]");
    }

    public static void printOutValue(int[] array) {
        System.out.print("[");
        printOutSingleValue(array, 2);
        System.out.print(", ");
        printOutSingleValue(array, 5);
        System.out.print(", ");
        printOutSingleValue(array, 10);
        System.out.println("]");

    }

    public static void printOutSingleValue(int[] array, int index) {
        if (index < array.length) {
            System.out.print(array[index]);
        } else {
            System.out.print("Fahrrad");
        }
    }
    public static void printOutEvery2Value(int []array){
        System.out.print("[");
        for (int i = 1; i < array.length ; i+=2) {
            if (i > 1) {
                System.out.print(", ");
            }
            System.out.print(array[i]);


        }
        System.out.print("]");

    }

}


