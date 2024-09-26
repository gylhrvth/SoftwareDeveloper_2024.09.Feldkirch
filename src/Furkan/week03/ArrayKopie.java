package Furkan.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayKopie {

        public static void main(String[] args) {
            int size = ConsoleTools.readNumber("Gib die größe des Arrays ein:", 0, 100);
            int[] original = realArray(size);
            int[] copyArray = createACopfromRealArray(original);
            System.out.println("Original: " + Arrays.toString(copyArray));
            System.out.println("Copy     :" + Arrays.toString(copyArray));

        }


        public static int[] realArray(int size) {
            int[] result = new int[size];
            for (int i = 0; i < result.length; i++) {
                result[i] = i;
            }
            return result;

        }

    public static int[] createACopfromRealArray(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];

        }
        return copy;

    }
}


