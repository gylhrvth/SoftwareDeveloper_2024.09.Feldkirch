package Erik.week04;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class PascalDreieck {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        int minValue = 2;
        int maxValue = 17;
        int userInput = controlUserInput("",2,17);
        int[][] arr = create2DArray(10); //17 ist die max Size für den int
        System.out.println("========================================================");
        controlUserInput("Wie groß soll das Pascal Dreieck werden? Size >> 2-17", 2, 17);
        printPascalArray(arr);


    }

    public static int[][] create2DArray(int size) {
        int[][] result = new int[size][size];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {

            }
        }
        return result;
    }

    public static void printPascalArray(int[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
//                    arr[i][j] = arr[i][j - 1] + arr[j][i - 1];  [i][j] richtig || [j][i] falsch
                }
                System.out.printf("%7d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static int controlUserInput(String msg, int minValue, int maxValue) {
        int userInput = 0;
        boolean validNumber = false;

        while (!validNumber) {
            try {
                System.out.println(msg);
                userInput = sc.nextInt();
                if (userInput >= minValue && userInput <= maxValue)
                    validNumber = true;
                else {
                    System.out.println("Außerhalb des Bereichs");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Error! Zahleneingabe!");
            }
            sc.nextLine();
        }
        return userInput;
    }

    public static void printPascalDreieckWithUserInput(int[][] arr, int userInput,int minValue, int maxValue) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (userInput >= minValue && userInput <= maxValue){
                    printPascalArray(arr);
                } else{
                    System.out.println("error");
                }
            }
        }
    }

}
