package Aylin.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib die Größe des Arrays ein: ", 0, 54);
        int[] arr = originalArray(size);
        int [] arrCopy = makeACopy(arr);
//        int [] test = new int [] {-54, 6, 89, 4, 8, 34};
//        int [] testC = makeACopy(test);

        System.out.println(Arrays.toString(arr));
        System.out.println("Copy: " + Arrays.toString(arrCopy));

        System.out.println("==============================================");
//        arrCopy[0] = -1;

//        System.out.println(Arrays.toString(test));
//        System.out.println("Copy: " + Arrays.toString(testC));

    }

    public static int[] originalArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1 + i;
        }
        return result;
    }

    public static int[] makeACopy(int [] originalArray){
        int[] copyArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            copyArray[i] = originalArray[i];
        }
        return copyArray;
    }
}
