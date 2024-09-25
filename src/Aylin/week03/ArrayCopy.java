package Aylin.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib die Größe des Array ein: ", 0, 54);
        int[] arr = originalArray(size);
        System.out.println(Arrays.toString(arr));
        int [] arrCopy = makeACopy(originalArray(size));
        System.out.println("Copy: " + Arrays.toString(arrCopy));
    }

    public static int[] originalArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1 + i;
        }
        return result;
    }

    public static int [] makeACopy(int [] originalArray){
        int [] copiedArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            copiedArray[i] = 1 + i;
        }
        return copiedArray;
    }
}
