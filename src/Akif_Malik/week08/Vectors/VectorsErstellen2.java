package Akif_Malik.week08.Vectors;

import java.util.Random;
import java.util.Vector;

public class VectorsErstellen2 {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Vector<Integer> numbers = generateVectorRandom(20);
        System.out.println(numbers);

        System.out.println("Anzahl der geraden Zahlen: " + countEvenNumbers(numbers));

    }

    public static int countEvenNumbers(Vector<Integer> vector) {
        int number = 0;

        if (number % 2 == 0) {
            number ++;
        }else {
        }

        return 0;
    }

    public static Vector<Integer> generateVectorRandom(int size) {
        Vector<Integer> zahlen = new Vector<>();

        for (int i = 0; i < size; i++) {
            zahlen.add(rand.nextInt(0, 100));

        }
        return zahlen;
    }

    public static int getVectorDescending(Vector<Integer> vector) {
        return 0;
    }

    public static int getVectorAscending(Vector<Integer> vector) {
        return 0;
    }

    public static void sortVectorElementsDescending(Vector<Integer> vector) {
    }

    public static void deleteEvenNumbersFromVector(Vector<Integer> vector) {
        //Vielleicht mit .remove
    }
}
