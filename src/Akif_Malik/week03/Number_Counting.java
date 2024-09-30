package Akif_Malik.week03;

import java.util.Arrays;

import static Akif_Malik.week03.RandomNumberArrays.random;

public class Number_Counting {
    public static void main(String[] args) {
        int target = 70;
        int[] zahlen = createAndFillArray(10);
        System.out.println(Arrays.toString(zahlen));
        int counter = counting(zahlen,target);
        System.out.println("Counter is: "+counter);



    }


    public static int[] createAndFillArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = random.nextInt(101);
        }
        return result;
    }

    public static int counting(int[] arr,int target){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > target){
                count++;
            }
        }
        return count;
    }

}

