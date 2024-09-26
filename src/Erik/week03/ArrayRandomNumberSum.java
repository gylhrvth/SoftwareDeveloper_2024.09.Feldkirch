package Erik.week03;

/*
        Todo:
                1. Erstelle einen Randomizer ✓
                2. Erstelle ein Int[] (Array). ✓
                2.1 mach eine Randomizer Methode die den Array den Randomizer Wert übergibt. ✓
                3. Erstelle die Logik dass jeder einzelne ausgegebene Randomizer Wert zsm gerechnet wird. (Rechen Funktion)
                4. Erstelle eine Methode die die Summe ausgeben soll (Print Funktion)
 */

import java.util.Arrays;
import java.util.Random;

public class ArrayRandomNumberSum {
    public static Random randomGen = new Random();

    public static void main(String[] args) {

        int sum = 0;
        int arraySize = 15;
        int[] randomArray = new int[arraySize];

        fillArrayWithRandomGen(randomArray);
        System.out.println("-----------------------------------");
        printTheSumOfAllArrayValues("All Values from the Array are: ", randomArray, sum);
        System.out.println("-----------------------------------");

    }

    public static void fillArrayWithRandomGen(int[] array) {

        for (int i = 1; i < array.length; i++) {
            array[i] = randomGen.nextInt(101);
        }
    }

    public static int sumMyArrayValues(int[] randomArray, int sum) {
        boolean plus = true;

        for (int value : randomArray) {
            sum = sum + value;
            if (plus == false) {
                System.out.print(" + ");
            }
            System.out.print(sum);
            plus = false;
        }
        System.out.println();
        return sum;
    }

    public static void printTheSumOfAllArrayValues(String msg, int[] randomArray, int sum) {

//        System.out.println(Arrays.toString(randomArray) + " ");
        System.out.println(msg);
        System.out.println("The Sum from all Array Values is: " + sumMyArrayValues(randomArray, sum));

    }
}
