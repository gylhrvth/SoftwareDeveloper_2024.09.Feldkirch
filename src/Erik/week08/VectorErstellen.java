package Erik.week08;

import java.util.Random;
import java.util.Vector;

public class VectorErstellen {
    public static Random rand = new Random();

    public static void main(String[] args) {

        Vector<Integer> rdm = fillVectorWithNumbers();
        System.out.println(">>Original Vektor<<");
        System.out.println(rdm);
        System.out.println(">>Gerade Zahlen<<");
        printEvenNumbers(rdm);
        int minValue = giveMinValue(rdm);
        int maxValue = giveMaxValue(rdm);
        System.out.println("---------------------------------");
        System.out.println("Minimum Value is: >> " + minValue);
        System.out.println("Maximum Value is: >> " + maxValue);
        System.out.println("---------------------------------");
        sortVectorDescending(rdm);
        System.out.println(">>Absteigend Sortiert<<\n" + rdm);
        deleteUnEvenNumbers(rdm);
        System.out.println("---------------------------------");
        System.out.println("Vector Integer without UnEven Numbers\n" + rdm);
    }

    public static Vector<Integer> fillVectorWithNumbers(){
        Vector<Integer> rdm = new Vector<>();
        for (int i = 0; i < 20; i++) {
            int numbers = rand.nextInt(0, 99);
            rdm.add(numbers);
        }
        return rdm;
    }

    public static void printEvenNumbers(Vector<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) { // geht einmal durch
            if (arr.get(i) % 2 == 0) {
                System.out.println("Even Numbers: >> " + arr.get(i));
            }
        }
    }

    public static int giveMinValue(Vector<Integer> arr) {
        int minValue = Integer.MAX_VALUE;

        for (int number : arr) {
            if (number < minValue) {
                minValue = number;
            }
        }
        return minValue;
    }

    public static int giveMaxValue(Vector<Integer> arr) {
        int maxValue = Integer.MIN_VALUE;

        for (int number : arr) {
            if (number > maxValue) {
                maxValue = number;
            }
        }
        return maxValue;
    }

    public static void sortVectorDescending(Vector<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = 0; j < arr.size() - 1; j++) {
                if (arr.get(j) < arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
    }

    public static void deleteUnEvenNumbers(Vector<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) { // geht einmal durch
            if (arr.get(i) % 2 != 0) {
                arr.remove(i);
                --i;
            }
        }
    }
}