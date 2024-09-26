package Aylin.week03;

import Sandro.Colors;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrayCrazyRange {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] arrayRandom = randomNumber(10);
//        System.out.println(Arrays.toString(arrayRandom));
        printArray(arrayRandom);
    }

    public static int[] randomNumber(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(-50, 50);
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
            if (value>0){
                System.out.print(Colors.COLORS[2] + value + Colors.RESET);
            }else if (value==0) {
                System.out.print(Colors.COLORS[4] + value + Colors.RESET);
            }else {
                System.out.print(Colors.COLORS[1] + value + Colors.RESET);
            }
            firstNumber = false;
        }
        System.out.println("]");
    }
}
