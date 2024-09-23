package Gyula.week03;

import java.util.Random;

public class UseRandom {
    public static Random randomGenerator = new Random();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int number = randomGenerator.nextInt(100);
            System.out.println(number);
        }
    }
}
