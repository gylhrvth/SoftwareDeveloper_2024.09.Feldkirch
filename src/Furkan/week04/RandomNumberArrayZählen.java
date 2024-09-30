package Furkan.week04;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrayZählen {

    static Random rand = new Random();

    public static void main(String[] args) {
        int size = 10;
        int[] arrayRandom = createArrayRandom(size);
        System.out.println(Arrays.toString(arrayRandom));
        int count =countNumbersOver(arrayRandom);
        System.out.println("Die Werte über 30 sind = " + count);


    }

    public static int[] createArrayRandom(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(0, 101);
        }

        return arr;
    }

    public static int countNumbersOver(int[] arr) {
        int count = 0;
        for (int number : arr) {
            if (number > 30) {
                count++;
            }

        }
        return count;
    }
}
