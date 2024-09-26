package Erik.week03;

/*
        Todo:
                1. Erstelle einen Randomizer ✓
                2. Erstelle ein Int[] (Array) und gib diesem den Randomizer Wert ✓
                3. Erstelle eine Methode die den Array ausgibt. ✓
                4. Erstelle eine Min, Max und Average Methode. (sollen nur den Rückgabewert geben)
                4.1 Rufe die Einzelnen Methoden im Main Block aus und gib die Werte aus.
                --------------------------------------------------------------------------
                5. Erstelle zwei weitere Methoden die den Index Min und Max zurückgeben.
                6. Erstelle eine weitere Methode die mehrere Index Positionen von Mix un Max Werten die mehrmals vorkommen zurückgibt.
 */


import java.util.Arrays;
import java.util.Random;

public class ArrayRandomNumberMinMaxAvg {
    public static Random randomGen = new Random();

    public static void main(String[] args) {
        int arraySize = 15; // randomArray.length => 15
        int[] randomArray = new int[arraySize];

        fillArrayWithRandomeGen(randomArray);
        System.out.println("----------------------------------");
        printWholeArray(randomArray);
        System.out.println("--------");
        giveMinValueFromTheArray("Min Value is: ", randomArray);


    }

    public static void fillArrayWithRandomeGen(int[] array) {
        Erik.week03.ArrayRandomNumberCount.fillArrayWithRandomGen(array);
    }

    public static void printWholeArray(int[] randomArray) {

        System.out.println(Arrays.toString(randomArray));

    }

    public static void giveMinValueFromTheArray(String msg, int[] randomArray) {

//        int min = randomArray[0];
        System.out.println(msg);
        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < randomArray[0]) {
                randomArray[0] = randomArray[i];

            }
            System.out.println("Min Wert vom Array ist: " + randomArray[i]);
//            System.out.print(randomArray[2] + " ");
        }

    }
}
