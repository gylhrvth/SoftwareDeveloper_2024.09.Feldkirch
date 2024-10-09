package Akif_Malik.week04;

import java.util.Random;
import java.util.Scanner;


public class TwoDimensionalArray {
    static Random rand = new Random();

    public static void main(String[] args) {

        System.out.println("type both for, show everything");
        System.out.println("type row for, show Sum of Rows");
        System.out.println("type col for, show Sum of Col");
        String userInput = userInput("choose something...");

        int[][] test = create2DArrays(10, 2);

        //printArrays(test);
        int row[] = sumRow(test);
        int col[] = sumCol(test);
        printStructure(test, row, col, userInput);
    }

    public static int[][] create2DArrays(int row, int col) {
        int[][] array = new int[row][col];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = rand.nextInt(101);
            }
        }
        return array;
    }


    /*public static void printArrays(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }*/

    public static int[] sumRow(int[][] arr) {
        int[] sum = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum[i] += arr[i][j];
            }
        }
        return sum;
    }

    public static String userInput (String msg){
        String result = "";
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        result = sc.next();

        return result;
    }

    public static int[] sumCol(int[][] arr) {
        int[] sum = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum[j] += arr[i][j];
            }
        }
        return sum;
    }

    public static void printStructure (int [][] arr, int[]row, int[]col,String input){
        boolean showRows = false;
        boolean showCols = false;

        if(input.equals("Row")){
            showRows = true;
        } else if (input.equals("Col")) {
            showCols = true;
        } else if (input.equals("All")) {
            showRows = true;
            showCols = true;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j == 0){
                    System.out.printf("%3d ",arr[i][j]);
                }else{
                    System.out.printf("| %3d ",arr[i][j]);
                }
            }
            if(showRows == true){
                System.out.printf("= %3d",row[i]);
            }
            System.out.println();
        }
        System.out.println("--------------------");
        if(showCols == true){
            for (int i = 0; i < col.length; i++) {
                if(i == 0){
                    System.out.printf("%3d ",col[i]);
                }else {
                    System.out.printf("| %3d ",col[i]);
                }

            }
        }


    }
}
