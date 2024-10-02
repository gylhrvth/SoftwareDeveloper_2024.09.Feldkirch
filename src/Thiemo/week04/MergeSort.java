package Thiemo.week04;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = Thiemo.week03.RandomNumberArray.createAndFillArrayWithRandom(10);
        System.out.println("Original Array " + Arrays.toString(array));
        System.out.println();
        int[] arrayCopyAsc = makeACopy(array);
//        System.out.println("Sorting Array in Ascending Order:");
        mergeSortAscending(arrayCopyAsc, 0, arrayCopyAsc.length);
        System.out.println();
        System.out.println("Sorted Array (Ascending):" + Arrays.toString(arrayCopyAsc));
        System.out.println();

        int[] arrayCopyDesc = makeACopy(array);
//        System.out.println("Sorting Array in Descending Order:");
        mergeSortDescending(arrayCopyDesc, 0, arrayCopyDesc.length);
        System.out.println();
        System.out.println("Sorted Array (Descending) : " + Arrays.toString(arrayCopyDesc));
        System.out.println();
        System.out.println("Original Array : " + Arrays.toString(array));

    }

    public static void mergeSortAscending(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;

        }
        int mid = low + (high - low) / 2;
        mergeSortAscending(array, low, mid);
        mergeSortAscending(array, mid, high);

        mergeAscending(array, low, mid, high);

    }


    public static void mergeSortDescending(int[] array, int low, int high) {
        if (high - low <= 1) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSortDescending(array, low, mid);
        mergeSortDescending(array, mid, high);

        mergeDescending(array, low, mid, high);
    }

    public static void mergeAscending(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int i = low, j = mid, k = 0;

//        System.out.println("Merging (Ascending) from " + low + " to " + high);
        while (i < mid && j < high) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j < high) {
            temp[k++] = array[j++];
        }
//        System.arraycopy(temp,0,array,low,temp.length);
        for (int index = 0; index < temp.length; index++) {
            array[low + index] = temp[index];
        }
//        System.out.println("Merged (Ascending): " + Arrays.toString(temp) +  " into original array: " + Arrays.toString(array));
    }

    public static void mergeDescending(int[] array, int low, int mid, int high) {
        int[] temp = new int[high - low];
        int i = low, j = mid, k = 0;

//        System.out.println("Merging (Descending) from " + low + " to " + high);
        while (i < mid && j < high) {
            if (array[i] >= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i < mid) {
            temp[k++] = array[i++];
        }
        while (j < high) {
            temp[k++] = array[j++];
        }
//        System.arraycopy(temp, 0, array, low, temp.length);
        for (int index = 0; index < temp.length; index++) {
            array[low + index] = temp[index];
        }
//        System.out.println("Merged (Descending): " + Arrays.toString(temp) + " into original array: " + Arrays.toString(array));
    }


    public static int[] makeACopy(int[] originalarr1) {
        int[] copy = new int[originalarr1.length];
        for (int i = 0; i < originalarr1.length; i++) {
            copy[i] = originalarr1[i];
        }
        return copy;
    }
}


//public class MergeSort {
//    public static void mergeSort(int[] array, int lo, int hi) {
//        if (hi - lo <= 1) {
//            return; // base case
//        }
//        int mid = (lo + hi) / 2; // middle element
//        mergeSort(array, lo, mid); // sort first half
//        mergeSort(array, mid, hi); // sort second half
//
//        // Merge the sorted halves
//        int[] B = new int[hi - lo];
//        int i = lo, j = mid, k = 0; // running indexes
//        while (i < mid && j < hi) {
//            if (array[i] < array[j]) {
//                B[k++] = array[i++];
//            } else {
//                B[k++] = array[j++];
//            }
//        }
//        while (i < mid) {
//            B[k++] = array[i++];
//        }
//        while (j < hi) {
//            B[k++] = array[j++];
//        }
//        // Copy back to the original array
//        System.arraycopy(B, 0, array, lo, hi - lo);
//    }
//
//    public static void main(String[] args) {
//        int[] array = Thiemo.week03.RandomNumberArray.createAndFillArrayWithRandom(10);;
//        mergeSort(array, 0, array.length);
//        for (int i : array) {
//            System.out.print(i + " ");
//        }
//    }
//}



