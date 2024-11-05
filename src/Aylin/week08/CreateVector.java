package Aylin.week08;

import Sandro.Colors;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class CreateVector {
    public static Random random = new Random();

    public static void main(String[] args) {

        randomVector1();
        System.out.println(randomVector2());
        System.out.println();
        System.out.println(evenNumbers(randomVector1()));
        System.out.println("===========================");
        System.out.println("smallest Number: " + Colors.COLORS[3]+smallestNumber(randomVector1())+Colors.RESET);
        System.out.println("===========================");
        System.out.println("biggest Number: " + Colors.COLORS[4]+biggestNumber(randomVector1())+Colors.RESET);
        System.out.println("===========================");
        sortVector(randomVector1());
        sortVector(randomVector2());
        System.out.println("sorted Vector: " + randomVector1());
        System.out.println("sorted Vector: " + randomVector2());
        System.out.println("===========================");
        System.out.println("Merged and sorted Vectors: " + mergeAndSortVectors(randomVector1(), randomVector2()));
        System.out.println("===========================");
        deleteOddNumbers(randomVector1());
        System.out.println(randomVector1());
        System.out.println("===========================");
//        randomVector1().trimToSize();
//        System.out.println(randomVector1());
//        for (int num : randomVector1()){
//            System.out.println("Number: " + num);
//        }
//        System.out.println("===========================");
    }

    public static Vector <Integer> randomVector1(){
        Vector <Integer> randomVector1 = new Vector<>();

        for (int i = 0; i < 20; i++) {
            int randomNr = random.nextInt(100);
            randomVector1.add(randomNr);
        }
        return randomVector1;
    }

    public static Vector <Integer> randomVector2(){
        Vector <Integer> randomVector2 = new Vector<>();

        for (int i = 0; i < 20; i++) {
            int randomNr = random.nextInt(100);
            randomVector2.add(randomNr);
        }
        return randomVector2;
    }

    public static Vector <Integer> evenNumbers(Vector <Integer> vector){
        Vector <Integer> evenNr = new Vector<>();

        for (int num : vector){
            if(num % 2 == 0){
                evenNr.add(num);
            }
        }
        return evenNr;
    }

    public static int smallestNumber (Vector <Integer> vector){
        int number = Integer.MAX_VALUE;

        for (int num : vector) {
            if(num < number){
                number = num;
            }
        }
        return number;
    }

    public static int biggestNumber (Vector <Integer> vector){
        int number = Integer.MIN_VALUE;

        for (int num : vector) {
            if(num > number){
                number = num;
            }
        }
        return number;
    }

    public static void sortVector (Vector <Integer> vector){
        for (int i = 0; i < vector.size() ; i++) {
            for (int j = 0; j < vector.size() - i - 1; j++) {
                if(vector.get(j) > vector.get(j+1)) {
                    swap(vector, j, j + 1);
                }
            }
        }
    }

    public static void swap(Vector <Integer> vector, int i, int j) {
        if (i >= 0 && j >= 0 && i < vector.size() && j < vector.size()) {
            int temp = vector.get(i);
            vector.set(i, vector.get(j));
            vector.set(j, temp);
        }
    }

    public static void deleteOddNumbers(Vector <Integer> vector){
        for (int i = 0; i < vector.size() ; i++) {
            if(vector.get(i) % 2 != 0){
                vector.remove(i);
                i--;                                                                        //i-- nach entfernen eines Elements, um das nächste Element nicht zu überspringen
            }
        }
    }

    public static Vector <Integer> mergeAndSortVectors(Vector <Integer> randomVector1, Vector <Integer> randomVector2){
        Vector <Integer> mergedVector = new Vector<>();
        mergedVector.addAll(randomVector1);
        mergedVector.addAll(randomVector2);
        Collections.sort(mergedVector);                                                    //Durch Collections.sort() werden die beiden zuvor zusammengefügten Vektoren gemeinsam sortiert.
        return mergedVector;
    }
}
