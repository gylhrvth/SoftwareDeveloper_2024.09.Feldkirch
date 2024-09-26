package Akif_Malik.week03;

import java.util.Arrays;

public class ArraysCopies {
    public static void main(String[] args) {
        int[] testArray = new int[]{5, 4, 8, 13, 5};
        int[] copyOfArray = makeACopy(testArray);

        System.out.println(Arrays.toString(testArray) + " " + Arrays.toString(copyOfArray));

        copyOfArray[0] = -1;
        System.out.println(Arrays.toString(testArray) + " " + Arrays.toString(copyOfArray));
    }

    public static int[] makeACopy(int[] original) {
        int[] result = new int[original.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = original[i];
        }

        return result;
    }
}
