package Thiemo.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;

public class ArrayKopie {
    public static void main(String[] args) {

//            int array[] = {6, 7, 8, 9, 10};
//
//            Arrays.fill(array, 5);                 //overwrite the array with 5 instead of the given numbers
//
//            System.out.println(Arrays.toString(array));


        int size = ConsoleTools.readNumber("Array Size:", 0, 999);
        int[] array1 = createAndFillArray(size);
        System.out.println(Arrays.toString(array1));
        System.out.println();

        int[] array2 = createAndFillArrayBackwards(size);

        System.out.println(Arrays.toString(array2));
        System.out.println();
        array2[0]=50;
        array2[1]=25;
        int[] arraykopie = makeACopy(array1);
        int[] arraykopie2 = makeACopy(array2);

        System.out.println(Arrays.toString(arraykopie) + "\n" +"\n" +(Arrays.toString(arraykopie2))+"\n");

        int[]funarray = {100,50,25};
        System.out.println(Arrays.toString(funarray));
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
//        System.arraycopy(originalarr1, 0, copy, 0, originalarr1.length);
        return copy;

    }
}



