package Erik.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Wie groß soll der Array sein? 1-10 ", 0, 10);
         //Erik.week03.ArrayNumber.createAndFillArray(size);
        int[] original = new int[]{5, 6, 33, 3, 7, 9};
        int[] originalCopy = makeACopy(original);

        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copy: " + Arrays.toString(originalCopy));

    }

    public static int[] makeACopy(int[] original) {
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original [i]; // copy[i] = original [i] Copy array original array mit [i] inhalt
        }
        return copy;
    }
}
