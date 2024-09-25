package Aylin.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib die Größe des Array ein: ", 0, 54);
        int[] arr = createAndFillArray(size);
        System.out.println(Arrays.toString(arr));
        int[] array = createAndFillArrayTheOtherWay(size);
        System.out.println(Arrays.toString(array));
    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1 + i;
        }
        return result;
    }

    public static int[] createAndFillArrayTheOtherWay(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = result.length - i;
        }
        return result;
    }
}
