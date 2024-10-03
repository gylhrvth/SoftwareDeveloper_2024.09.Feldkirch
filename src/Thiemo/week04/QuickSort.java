package Thiemo.week04;


import java.util.Arrays;

    public class QuickSort {

        public static void main(String[] args) {
            int [] array = Thiemo.week03.RandomNumberArray.createAndFillArrayWithRandom(10);
            System.out.println("\nOriginal Array : \n" + Arrays.toString(array));
            int n = array.length;
            quicksort(array, 0, n-1);
            System.out.println("\nSorted array : \n" + Arrays.toString(array));

        }

        public static void quicksort (int [] array,int left, int right){
            if (left >= right)
                return;

            int pivotIndex = pickPivotPos(array,left,right);
//            System.out.println("Pivot chosen (value): " + array[pivotIndex] + " at index: " + pivotIndex);

            int partitionIndex = partition(array,left,right,pivotIndex);
//            System.out.println("Array after partitioning: " + Arrays.toString(array));
//            System.out.println("Partition index: " + partitionIndex + "\n");

            quicksort(array,left,partitionIndex - 1);
            quicksort(array,partitionIndex + 1,right);

        }

        public static int partition( int [] array, int left, int right, int pivotIndex){
            int pivot = array[pivotIndex];
            swap(array, pivotIndex,right);
//            System.out.println("Moved pivot to end: " + Arrays.toString(array));

            int i = left;
            for (int j = left; j < right; j++) {
                if (array[j] <= pivot){
                    swap(array,i,j);
//                    System.out.println("Swapped " + array[i] + " and " + array[j] + ": " + Arrays.toString(array));
                    i++;
                }
            }
            swap(array,i,right);
//            System.out.println("Placed pivot " + pivot + " in correct position: " + Arrays.toString(array));
            return i;
        }
        public static void swap(int [] array, int i, int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        public static int pickPivotPos(int [] array, int left , int right){
            return right;
        }
    }

