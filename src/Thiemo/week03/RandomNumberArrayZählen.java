package Thiemo.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArrayZählen {

    public static Random randomGenerator = new Random();

    public static void main(String[] args) {

        int[] array = createAndFillArrayWithRandom(10);
        System.out.println();
        System.out.println(Arrays.toString(array));
        System.out.println();
        valuebiggerthan(array);
        System.out.println();
        System.out.println("wie oft find ich 30+ = "+ valuebiggerthan(array));
    }

    public static int[] createAndFillArrayWithRandom(int size) {

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(101);
        }
        return array;
    }

    public static int valuebiggerthan(int[] array) {

        int counter = 0;
//        System.out.println("inhalt von 0 = "+array[0]);
//        int value = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 30) {
                counter++;

           //     System.out.print(array[i] + ", ");
            }
        } //System.out.println("Counter = "+ counter);
        return counter;
    }
}



//    public static void valuebiggerthan(int [] array){
//
//        System.out.print("[");
//        for (int i = 0; i < array.length; i++) {
//            if (i > 1) {
//                System.out.print(", ");}
//
//                if(array[i] < 30){
//
//                } System.out.print(array[i]);
//
//        }
//        System.out.println("]");
//
//
//    }
//}

