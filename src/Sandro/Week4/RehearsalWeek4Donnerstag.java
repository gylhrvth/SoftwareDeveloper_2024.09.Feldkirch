package Sandro.Week4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RehearsalWeek4Donnerstag {
    static Random rand = new Random();
    public static void main(String[] args) {
        /*
        System.out.println(Arrays.toString(test));
        printArrays(test);
        System.out.println(Arrays.toString(row));
        */
        System.out.println("type All, show everything");
        System.out.println("type Row, show Sum of Rows");
        System.out.println("type Col, show Sum of Col");
        String userInput = userInput("choose something...");
        /*
        if(userInput.equals("Row")){
            System.out.println("test erfolgreich...");
            System.out.println("schlte boolean row auf true");
        }else {
            System.out.println("fail");
        }
        */

        int[][] test = create2DArray(5,2);
        int [] row = sumRow(test);
        int[] col = sumCol(test);
        printStructure(test,row,col,userInput);

    }
    public static String userInput (String msg){
        String result = "";
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        result = sc.next();

        return result;
    }
    public static int[][] create2DArray(int row, int col){
        int[][] result = new int[row][col];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
              result [i][j]= rand.nextInt(101);
            }
        }
        return result;
    }

    public static void printArrays(int [][] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%5d ",arr[i][j]);

            }

            System.out.println();
        }


    }

    public static int[] sumRow (int [][] arr){
        int[]sum = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length; j++) {
                sum[i]+= arr[i][j];
            }
        }
        return sum;
    }

    public static int[] sumCol (int [][] arr){
        int []sum = new int[arr[0].length];
        // sum [ 0, 0]
        // links ... rechts
        // sum[0]... sum[1]
        //  31   ....  74
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
