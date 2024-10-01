package Akif_Malik.week03;

import java.util.Arrays;

import static Akif_Malik.week03.RandomNumberArrays.random;

public class RandomNumber_Summary {

    public static void main(String[] args) {
        int[] zahlen = createAndFillArray(10);
        System.out.println(Arrays.toString(zahlen));
        int summary = sumArray(zahlen);
        System.out.println("Summe: " + summary);
    }


    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101);
        }
        return result;
    }

    public static int sumArray (int [] arr){
        int summmary = 0;
        for (int value : arr) {
            summmary += value ;
        }
        return summmary;
    }
}
