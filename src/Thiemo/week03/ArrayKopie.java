package Thiemo.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayKopie {
    public static void main(String[] args) {


        int size = ConsoleTools.readNumber("Array Size:", 0, 999);
        int[] array = createAndFillArray(size);
        System.out.println(Arrays.toString(array));
        System.out.println();

        int[] array2 = createAndFillArrayBackwards(size);
        System.out.println(Arrays.toString(array2));
        System.out.println();
        int[] arraykopie = makeACopy(array);
        int[] arraykopie2 = makeACopy(array2);
        System.out.println(Arrays.toString(arraykopie)+"\n"+"\n"+(Arrays.toString(arraykopie2)));
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

    public static int[] makeACopy(int[] originalarr1) {

        int[] copy = new int[originalarr1.length];
        for (int i = 0; i < originalarr1.length; i++) {
            copy[i] = originalarr1[i];
        }
        return copy;

    }
}



