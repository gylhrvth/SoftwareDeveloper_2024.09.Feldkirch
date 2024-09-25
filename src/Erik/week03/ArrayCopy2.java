package Erik.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayCopy2 {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib Die Größe deines Arrays ein: ", 0, 20);
          int[] originalArray = myOriginalArray(size);
       // int[] originalArray = new int[]{5, 6, 33, 3, 7, 9, 61, 80};
        int [] copyArray = createACopyFromMyOriginalArray(originalArray);
        System.out.println("Original: " + Arrays.toString(originalArray));
        System.out.println("Copy    : " + Arrays.toString(copyArray));
    }

    public static int [] myOriginalArray (int size){
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static int [] createACopyFromMyOriginalArray (int [] originalArray){
        int [] createACopy = new int [originalArray.length];
        for (int i = 0; i < createACopy.length; i++) {
            createACopy[i] = originalArray[i];

        }

        return createACopy;
    }

}
