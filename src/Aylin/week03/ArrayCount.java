package Aylin.week03;

import java.util.Arrays;
import java.util.Random;

public class ArrayCount {
    public static Random random = new Random();

    public static void main(String[] args) {
        int[] arrayRandom = randomNumber(10);
        System.out.println(Arrays.toString(arrayRandom));
        countArray(arrayRandom, 30);

        int counter = countArray(arrayRandom, 50);
        System.out.println("Numbers greater than 30 are: " + counter);
    }

    public static int[] randomNumber(int size){
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1, 101);
        }
        return arr;
    }

    public static int countArray(int[] arr, int value){
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > value) {
                counter++;
                //counter
            //   System.out.print(arr[i]);
            }
        }
        return counter;
    }
}
