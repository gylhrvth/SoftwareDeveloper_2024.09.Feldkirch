package Aylin.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArray {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] randomArray = randomNumber(13);
        System.out.println(Arrays.toString(randomArray));
        printArray(randomArray);
        printArray2(randomArray);
        printArraySpecificNumbers(randomArray);
        printEverySecondNumber(randomArray);
    }

    public static int[] randomNumber(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    public static void printArray(int[] array){
        boolean firstNumber = true;

        System.out.print("[");
        for (int value : array){
            if(!firstNumber){
                System.out.print(", ");
            }
            System.out.print(value);
            firstNumber = false;
        }
        System.out.println("]");
    }

    public static void printArray2(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if(i >0){
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println("]");
    }

    public static void printArraySpecificNumbers(int[] array){
        System.out.print("[");
        printIth(array, 2);
        System.out.print(", ");
        printIth(array, 5);
        System.out.print(", ");
        printIth(array, 10);
        System.out.print("]");
    }

    public static void printIth(int[] arr, int idx){
        if (idx < arr.length){
            System.out.print(arr[idx]);
        } else {
            System.out.print("nicht vorhanden");
        }
    }

    public static void printEverySecondNumber(int[] arr){
        System.out.println();
        System.out.print("[");
        for (int i = 1; i < arr.length; i += 2) {
            if (i > 1){
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}