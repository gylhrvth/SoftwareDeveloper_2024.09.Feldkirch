package Thiemo.week09;

import java.util.Random;
import java.util.Vector;
import java.util.stream.Collectors;


public class VectorExample {

    public static Random random = new Random();

    public static void main(String[] args) {

        Vector<Integer> randomNumbers = new Vector<>();

        fillVectorWithRandomNumbers(randomNumbers);

        System.out.println(randomNumbers + "\n");
        System.out.println("Get only even Numbers " + getEvenNumbers(randomNumbers) + "\n");
//        System.out.println(getEvenNumbers1(randomNumbers));
        System.out.println("Smallest Number [" + smallestNumberfori(randomNumbers) + "]\n");
        System.out.println("Biggest Number [" + biggestNumberfori(randomNumbers) + "]\n");
        sortVectorDescending(randomNumbers);
        System.out.println("Sorted Vector " + randomNumbers + "\n");
        deleteOddNumbers(randomNumbers);
        System.out.println("Deleted all odd Numbers " + randomNumbers + "\n");
    }

    public static Vector<Integer> getEvenNumbers(Vector<Integer> randomNumbers) {
        Vector<Integer> evenNumber = new Vector<>();
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) % 2 == 0) {
                evenNumber.add(randomNumbers.get(i));
            }
        }
        return evenNumber;
    }

    public static Vector<Integer> getEvenNumbers1(Vector<Integer> randomNumbers) {               // AI
        return randomNumbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toCollection(Vector::new));
    }

    public static int smallestNumberfori(Vector<Integer> randomNumbers) {
        int number = Integer.MAX_VALUE;
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) < number)
                number = randomNumbers.get(i);
        }
        return number;
    }

    public static int smallestNumberforeach(Vector<Integer> randomNumbers) {
        int number = Integer.MAX_VALUE;

        for (int num : randomNumbers) {
            if (num < number) {
                number = num;
            }
        }
        return number;
    }

    public static int biggestNumberfori(Vector<Integer> randomNumbers) {
        int number = Integer.MIN_VALUE;
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) > number)
                number = randomNumbers.get(i);
        }
        return number;
    }

    public static void sortVectorDescending(Vector<Integer> randomNumbers) {

        for (int i = 0; i < randomNumbers.size(); i++) {
            for (int j = 0; j < randomNumbers.size() - 1 - i; j++) {
                if (randomNumbers.get(j) < randomNumbers.get(j + 1)) {
                    int temp = randomNumbers.get(j);
                    randomNumbers.set(j, randomNumbers.get(j + 1));
                    randomNumbers.set(j + 1, temp);
//                    swap(randomNumbers, j, j + 1);
                }
            }
        }
    }

    public static void swap(Vector<Integer> randomNumbers, int i, int j) {
        if (i >= 0 && j >= 0 && i < randomNumbers.size() && j < randomNumbers.size()) {
            int temp = randomNumbers.get(i);
            randomNumbers.set(i, randomNumbers.get(j));
            randomNumbers.set(j, temp);
        }
    }

    public static void deleteOddNumbers(Vector<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            if (randomNumbers.get(i) % 2 != 0) {
                randomNumbers.remove(i);
                i--;                                                                        //i-- nach entfernen eines Elements, um das nächste Element nicht zu überspringen
            }
        }
    }

    public static void fillVectorWithRandomNumbers(Vector<Integer> randomNumbers) {
        for (int i = 0; i < 20; i++) {
            int randomNr = random.nextInt(100);
            randomNumbers.add(randomNr);
        }
    }
}
