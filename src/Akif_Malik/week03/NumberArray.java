package Akif_Malik.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class NumberArray {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib die Größe ein!", 0, 100);
        int[] zahlen = createAndFillArray(size);
        for (int i = 0; i < zahlen.length; i++) {
            //System.out.println(zahlen[i]);
        }
        System.out.println(Arrays.toString(zahlen));
    }

    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}

