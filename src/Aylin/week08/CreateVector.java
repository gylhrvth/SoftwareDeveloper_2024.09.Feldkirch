package Aylin.week08;

import java.util.Random;
import java.util.Vector;

public class CreateVector {
    public static Random random = new Random();

    public static void main(String[] args) {
        Vector <Integer> randomNumbers = new Vector<>();

        for (int i = 0; i < 20; i++) {
            int randomNr = random.nextInt(100);
            randomNumbers.add(randomNr);
        }
        System.out.println(randomNumbers);
    }
}
