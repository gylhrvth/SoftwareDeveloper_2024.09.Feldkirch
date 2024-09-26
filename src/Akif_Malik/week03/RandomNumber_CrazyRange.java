package Akif_Malik.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumber_CrazyRange {

    public static Random random = new Random();

    public static void main(String[] args) {
        int[] zahlen = createAndFillArray(10);
        System.out.println(Arrays.toString(zahlen));

    }


    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(-50,51);
        }
        return result;
    }
}
