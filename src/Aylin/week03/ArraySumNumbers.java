package Aylin.week03;

import java.util.Arrays;
import java.util.Random;

public class ArraySumNumbers {
    public static Random random = new Random();

    public static void main(String[] args) {
        int [] array = randomNumber(10);
        System.out.println(Arrays.toString(array));

        int sum = sumArray(array);
        System.out.println("Sum: " + sum);
    }

    public static int[] randomNumber(int size){
        int [] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(101);
        }
        return arr;
    }

    public static int sumArray (int [] arr){
        int sum = 0;
        for (int value : arr) {
            sum += value ;
        }
        return sum;
    }


}
