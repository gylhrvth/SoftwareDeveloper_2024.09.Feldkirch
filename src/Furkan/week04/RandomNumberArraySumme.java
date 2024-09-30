package Furkan.week04;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArraySumme {

    static Random rand = new Random();

    public static void main(String[] args) {
        int size = 10;
        int[] arrayrandom= createArrayRandom(size);
        System.out.println(Arrays.toString(arrayrandom));
        int sum = countArraySumme(arrayrandom);
        System.out.println("Die Summe ist: " + sum);

    }


    public static int[] createArrayRandom(int size){
        int [] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]= rand.nextInt(0,100);

        }
        return arr;
    }

    public static int countArraySumme (int[] arr){
        int sum = 0;
        for (int number: arr) {
            sum+=number;

        }

        return sum;
    }





}
