package Thiemo.week04;

import Gyula.ConsoleTools;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoDArray2 {
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("How many rows should the array have?");
        int userInput = sc.nextInt();
        System.out.println("How many columns?");
        int userInput2 = sc.nextInt();

        System.out.println();
        int[][] array = createAndFillArray(userInput, userInput2);
        System.out.println("From 0 - X \n");
        print2DArray(array);
        int [] sumRow = sumY(array);
        int [] sumColum = sumX(array);
        System.out.println(Arrays.toString(sumRow) + "Sum row" );
        System.out.println(Arrays.toString(sumColum) + "Sum Column");



        int[][] arrayRandom = createAndFillArrayWithRandom(userInput, userInput2);
        System.out.println("\n\nWith Random Numbers\n");
        print2DArray(arrayRandom);
        int [] sumRowR = sumY(array);
        int [] sumColumR = sumX(array);
        System.out.println(Arrays.toString(sumRowR) + "Sum row" );
        System.out.println(Arrays.toString(sumColumR) + "Sum column");
    }

    public static int[][] createAndFillArrayWithRandom(int rowY, int colX) {
        int[][] array = new int[rowY][colX];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(10);
            }
        }
        return array;
    }

    public static int[][] createAndFillArray(int rowY, int colX) {
        int counter = 0;
        int[][] array = new int[rowY][colX];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter;
                counter++;
            }
        }
        return array;
    }

    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                if (j > 0) {
                    System.out.print(", ");
                }
                System.out.printf("%5d", array[i][j]);
            }
            System.out.println("]");
        }
    }

    public static int [] sumX( int [][] array){
        int [] sumX = new int [array.length];

        return sumX;
    }


    public static int [] sumY(int [][] array){
        int [] sumY = new int [array.length];

        return sumY;
    }
}





