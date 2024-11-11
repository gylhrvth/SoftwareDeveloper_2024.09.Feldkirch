package Akif_Malik.week08.Vectors;

import java.util.Random;
import java.util.Vector;

public class VectorErstellen1 {
    private static Random rand = new Random();

    public static void main(String[] args) {
        Vector<Integer> numbers = new Vector<>();

        for (int i = 0; i < 20; i++) {
            numbers.add(rand.nextInt(0,99));
        }
        System.out.println(numbers);
    }
}
