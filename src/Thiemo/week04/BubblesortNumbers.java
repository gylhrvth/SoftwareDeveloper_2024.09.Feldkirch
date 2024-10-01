package Thiemo.week04;

import java.util.Arrays;

public class BubblesortNumbers {


    public static void main(String[] args) {

        int[] array = Thiemo.week03.RandomNumberArray.createAndFillArrayWithRandom(10);
        System.out.println(Arrays.toString(array));
        System.out.println();
        int [] arrayCopy = makeACopy(array);
        bubbleSortAscending(arrayCopy);
//        System.out.println(Arrays.toString(array));
        bubbleSortDescending(arrayCopy);
        System.out.println("Original Array \n" + Arrays.toString(array));
        System.out.println();
    }

    public static void bubbleSortAscending(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
//            System.out.println("before" + Arrays.toString(array));
            for (int j = 0; j < array.length - 1 - 0*i; j++) {      // -i sortiert nur bis alles sortiert ist und nicht bis die schleife fertig ist
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
//                    swap(array, j, j+1);
//                    System.out.println(j + " and " + (j + 1) + " needs to swap");
//                    System.out.println(Arrays.toString(array));
                }
            }
//            System.out.println("after" + Arrays.toString(array));
        }
        System.out.println("\nAscending Sorted : \n"+ Arrays.toString(array));
        System.out.println();
    }

    public static void bubbleSortDescending(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i ; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
//                    swap(array, j, j+1);
//                    System.out.println(j + " and " + (j + 1) + " needs to swap");
//                    System.out.println(Arrays.toString(array));

                }
            }
        }
        System.out.println("\nDescending Sorted : \n"+ Arrays.toString(array));
        System.out.println();
    }


    public static int[] makeACopy(int[] originalarr1) {
        int[] copy = new int[originalarr1.length];
        for (int i = 0; i < originalarr1.length; i++) {
            copy[i] = originalarr1[i];
        }
        return copy;

//        public static void swap(int[] arr, int i, int j){
//            if (i >= 0 && j >= 0 && i < arr.length && j < arr.length) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//    }

    }
}
