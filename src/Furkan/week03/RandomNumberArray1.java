package Furkan.week03;

//import Gyula.ConsoleTools;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArray1 {

    static Random rand = new Random();

    public static void main(String[] args) {
        // int size = ConsoleTools.readNumber("Gib die Größe des Arrays ein:", 0, 100);
        int size = 10;
        //Aufruf von Funktion create Array...
        int[] arrayRandom = createArrayRandom(size);
        System.out.println(Arrays.toString(arrayRandom));
        printForEach(arrayRandom);
        printI(arrayRandom);
        // System.out.println();
      //  prinValue(arrayRandom);
        printSelectedValues(arrayRandom);
        printEverySecond(arrayRandom);


    }

    //funktion create Array mit Random Numbers
    public static int[] createArrayRandom(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(0, 101);
        }

        return arr;
    }


    //funktion print Array

    public static void printForEach(int[] arr) {
        //int [] arr   ... int, int, int, int
        System.out.print("[");
        for (int number : arr) {
            System.out.print(number );
            if (number!= arr[arr.length -1]){
                System.out.print(", ");
            }
        }

        System.out.print("]");
        System.out.println();

    }

    public static void printI(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i!= arr.length-1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println();

    }


//    public static void prinValue(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            //System.out.println("Der Wert vom Array " + i + "ist: " + arr[i]);
//
//        }
//    }

    public static void printSelectedValues(int[] arr) {
        int[] indices = {1, 4, 9};          // da man von 0 aus anfängt zu zählen, schreibt man die gewünschte Zahl einmal kleiner.
        for (int i : indices) {
            if (i < arr.length) {
                System.out.println("Der Wert an Position " + (i + 1) + " ist: " + arr[i]);
            } else {
                System.out.println("Der Wert an Position " + (i + 1) + " ist: nicht vorhanden");
            }
        }
    }

    public static void printEverySecond(int[] arr) {
        for (int i = 0; i < arr.length; i += 2) {

            System.out.println("Der Wert jeder zweiten Position ist: " + i + " = " + arr[i]);
        }
    }
}

