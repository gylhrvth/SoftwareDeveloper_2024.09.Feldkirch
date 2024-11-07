package Furkan.week09;

import java.util.Random;
import java.util.Vector;

public class VectorErstellen {
    public static Random random = new Random();

    public static void main(String[] args) {
        randomVector();
        System.out.println(randomVector2());
        System.out.println();
        System.out.println(evenNumber(randomVector()));
        System.out.println("============================");
        System.out.println("Smallest Number is: " + smallestNumber(randomVector()));
        System.out.println("============================");
        System.out.println("Biggest Number is: " + biggestNumber(randomVector()));
        System.out.println("============================");
        ;
        sortNumbers(randomVector());
        sortNumbers(randomVector2());
        System.out.println("Sorted Vector: " + randomVector());
        System.out.println("Sorted Vector: " + randomVector2());
        System.out.println();
        System.out.println("==============================");
        deleteOddNumber(randomVector());
        System.out.println(randomVector());


    }

    public static Vector<Integer> randomVector() {
        Vector<Integer> randomVector = new Vector<>();

        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100);
            randomVector.add(randomNumber);
        }
        return randomVector;
    }

    public static Vector<Integer> randomVector2() {
        Vector<Integer> randomVector2 = new Vector<>();

        for (int i = 0; i < 20; i++) {
            int randomNumber = random.nextInt(100);
            randomVector2.add(randomNumber);
        }
        return randomVector2;
    }

    public static Vector<Integer> evenNumber(Vector<Integer> vector) {
        Vector<Integer> evenNumber = new Vector<>();

        for (int num : vector) {
            if (num % 2 == 0) {
                evenNumber.add(num);
            }

        }
        return evenNumber;
    }

    public static int smallestNumber(Vector<Integer> vector) {
        int number = Integer.MAX_VALUE;

        for (int num : vector) {
            if (num < number) {
                number = num;
            }
        }
        return number;
    }

    public static int biggestNumber(Vector<Integer> vector) {
        int number = Integer.MIN_VALUE;

        for (int num : vector) {
            if (num > number) {
                number = num;
            }
        }
        return number;
    }

    public static void sortNumbers(Vector<Integer> vector) {
        for (int i = 0; i < vector.size(); i++) {
            for (int j = 0; j < vector.size() - i - 1; j++) {
                if (vector.get(j) > vector.get(j + 1)) {
                    swap(vector, j, j + 1);
                }
            }
        }
    }

    public static void swap(Vector<Integer> vector, int i, int j) {
        if (i >= 0 && j >= 0 && i < vector.size() && j < vector.size()) {
            int temp = vector.get(i);
            vector.set(i, vector.get(j));
            vector.set(j, temp);
        }
    }

    public static void deleteOddNumber(Vector<Integer> vector) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) % 2 != 0) {
                vector.remove(i);
                i--;
            }


        }

    }
}