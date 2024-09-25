package Thiemo.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayNumber {
    public static void main(String[] args) {


        int size = ConsoleTools.readNumber("Size:", 0, 999);
        int[] array = createAndFillArray(size);
        System.out.println(Arrays.toString(array));

        int[] array2 = createAndFillArrayBackwards(size);
        System.out.println(Arrays.toString(array2));

    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1 + i;
        }
        return result;
    }

    public static int[] createAndFillArrayBackwards(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
//            size --;
//            result[i] = size;
            result[i] = /* size--; size - i;*/result.length - i;

        }
        return result;

    }


}

