package Furkan.week03;

import java.util.Random;

public class RandomNumberArrayCrazyRange {

    static Random rand = new Random();

    public static void main(String[] args) {
        int size = 10;
        int[] arrayRandom = new int[size];
        arrayRandom = createArrayRandom(size);
        printForEach(arrayRandom);

    }

    public static int[] createArrayRandom(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(-51, 51);
        }

        return arr;
    }


    public static int[] printForEach(int[] arr) {
        for (int number : arr) {
            System.out.println("Die Zugallszahlen sind  : "+ number + " ");
        }
        System.out.println();

        return arr;
    }


}
