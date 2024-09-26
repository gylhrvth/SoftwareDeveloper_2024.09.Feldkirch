package Gyula.week03;

import java.util.Random;

public class RandomNumbers {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] arr = createRandomArray(20);
        printArray(arr);
    }

    public static int[] createRandomArray(int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(101);
        }

        return arr;
    }

    public static void printArray(int[] arr){
        System.out.println("Hello World!");
    }
}
