package Furkan.week04;

import java.util.Arrays;

public class ArrayAufgabe2D {
    public static void main(String[] args) {
        int[] number = new int[10];
        for (int i = 0; i < number.length; i++) {
            number[i] = 100;
        }
        System.out.println(Arrays.toString(number));

        double[] doubles = new double[10];
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = 0.5;
        }
        System.out.println(Arrays.toString(doubles));

        int [] [] arrayOfArray = new int[10][];
        for (int i = 0; i < arrayOfArray.length; i++) {
            arrayOfArray[i]= new int[1+3*i];
            for (int j = 0; j < arrayOfArray[i].length; j++) {
                arrayOfArray[i][j]=j+1;
            }
        }
        System.out.println(Arrays.toString(arrayOfArray));

        print2DArray(arrayOfArray);
        System.out.println("--------------------------------------------------------------------------");

    }


    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }


    }


}

