package Thiemo.week04;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = Thiemo.week03.RandomNumberArray.createAndFillArrayWithRandom(10);
        System.out.println(Arrays.toString(array));
        int [] arrayCopy = makeACopy(array);
        int low = 0;
        int high = array.length;
        mergeSortAscending(arrayCopy,low,high);
//        System.out.println(Arrays.toString(array));
        mergeSortDescending(arrayCopy);

        System.out.println("Original Array \n" + Arrays.toString(array));
        System.out.println();
    }


    public static void mergeSortAscending(int [] array,int low,int high){


    }


    public static void mergeSortDescending(int[] array){


    }


    public static int[] makeACopy(int[] originalarr1) {
        int[] copy = new int[originalarr1.length];
        for (int i = 0; i < originalarr1.length; i++) {
            copy[i] = originalarr1[i];
        }
        return copy;
}
}
//    public class MergeSort {
//        public static void mergeSort(int[] array, int lo, int hi) {
//            if (hi - lo <= 1) {
//                return; // base case
//            }
//            int mid = (lo + hi) / 2; // middle element
//            mergeSort(array, lo, mid); // sort first half
//            mergeSort(array, mid, hi); // sort second half
//
//            // Merge the sorted halves
//            int[] B = new int[hi - lo];
//            int i = lo, j = mid, k = 0; // running indexes
//            while (i < mid && j < hi) {
//                if (array[i] < array[j]) {
//                    B[k++] = array[i++];
//                } else {
//                    B[k++] = array[j++];
//                }
//            }
//            while (i < mid) {
//                B[k++] = array[i++];
//            }
//            while (j < hi) {
//                B[k++] = array[j++];
//            }
//            // Copy back to the original array
//            System.arraycopy(B, 0, array, lo, hi - lo);
//        }
//
//        public static void main(String[] args) {
//            int[] array = {5, 2, 4, 7, 1, 3, 2, 6};
//            mergeSort(array, 0, array.length);
//            for (int i : array) {
//                System.out.print(i + " ");
//            }
//        }
//    }



