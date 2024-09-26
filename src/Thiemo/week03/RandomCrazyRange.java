package Thiemo.week03;

import Sandro.Colors;

import java.util.Random;


public class RandomCrazyRange {

    public static Random randomGenerator = new Random();

    public static void main(String[] args) {

        int[] array = createAndFillArrayWithRandom(50);
//        System.out.println(Arrays.toString(array));
        printArrayforeach(array);
        System.out.println();


    }

    public static int[] createAndFillArrayWithRandom(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(-1, 2);
        }
        return array;
    }

    public static void printArrayforeach(int[] array) {
        boolean richtigeEingabe = false;
        System.out.print("[");
        for (int number : array) {
            if (richtigeEingabe) {
                System.out.print(", ");
            }
            if (number < 0) {
                System.out.print(Colors.COLORS[1] + number + Colors.RESET);
            } else if (number > 0) {
                System.out.print(Colors.COLORS[4] + number + Colors.RESET);

            } else {
                System.out.print(Colors.BACKGROUND_COLORS[7]+Colors.COLORS[0]+ number + Colors.RESET);
            }
            richtigeEingabe = true;
        }

        System.out.println("]");
    }
}
