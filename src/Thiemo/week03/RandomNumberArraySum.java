package Thiemo.week03;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberArraySum {


    public static Random randomGenerator = new Random();

    public static void main(String[] args) {

        int[] array = createAndFillArrayWithRandom(10);
        System.out.println();
        System.out.println(Arrays.toString(array));
        System.out.println();
        int result = sumOfValues(array);
//        sumOfValues(array);
        System.out.println(" The end result = " + result);
    }

    public static int[] createAndFillArrayWithRandom(int size) {

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomGenerator.nextInt(101);
        }
        return array;
    }

    //    public static int sumOfValues(int[] array) {
//        int sum = 0;
//        for (int zaehlen = 0; zaehlen < array.length; ++zaehlen) {
//            sum += array[zaehlen];
//            System.out.print(sum + " ");
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5};
//        int result = sumOfValues(array);
//        System.out.println("\nTotal Sum: " + result);
//    }
    public static int sumOfValues(int[] array) {
        int sum = 0;
        for (int zaehlen : array) {
            sum += zaehlen;
        }

        return sum;
    }
}


//    public static int sumOfValues(int[] array) {
//        int sum = 0;
//        for (int zaehlen = 0; zaehlen < array.length ; ++zaehlen) {
//            sum += array[zaehlen];
////            System.out.print(sum + "   ");  // print out every sum with the next number GG
//        }
//        return sum;
//    }
//}
