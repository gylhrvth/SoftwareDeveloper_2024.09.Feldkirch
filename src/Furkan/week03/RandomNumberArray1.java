package Furkan.week03;

import Gyula.ConsoleTools;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArray1 {

    static Random rand = new Random();

    public static void main(String[] args) {
        // int size = ConsoleTools.readNumber("Gib die Größe des Arrays ein:", 0, 100);
        int size = 10;
        //Aufruf von Funktion create Array...
        int[] arrayRandom = new int[size];
        arrayRandom = createArrayRandom(size);
        System.out.println(Arrays.toString(arrayRandom));
        printForEach(arrayRandom);
        printI(arrayRandom);


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
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();

    }

    public static void printI(int[] arr) {
        for (int i = 0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");

        }


    }


}
