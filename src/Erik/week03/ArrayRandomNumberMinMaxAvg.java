package Erik.week03;

/*
        Todo:
                1. Erstelle einen Randomizer ✓
                2. Erstelle ein Int[] (Array) und gib diesem den Randomizer Wert ✓
                3. Erstelle eine Methode die den Array ausgibt. ✓
                4. Erstelle eine Min, Max und Average Methode. (sollen nur den Rückgabewert geben)
                4.1 Erstelle eine For I Schleife und frag alle array schubladen ab und speicher sie im minValue ab
                4.2 Gib diesen Wert zurück. und ruf ihn oben aus zum gegen checken.
                5. Mache das selbe von 4.1-.2 nur mit MaxValue und einmal mit AverageValue.
                6. Rufe die Einzelnen Methoden im Main Block aus und gib die Werte aus.
                --------------------------------------------------------------------------
                7. Erstelle zwei weitere Methoden die den Index des jeweiligen min und max wert zurückgeben.
                7.1 Gib diesen Index mit dem jeweiligem Wert aus.
                8. Erstelle eine weitere Methode die mehrere Index Positionen von Mix un Max Werten die mehrmals vorkommen zurückgibt.
 */

import java.util.Arrays;

public class ArrayRandomNumberMinMaxAvg {
    public static void main(String[] args) {

        int arraySize = 11; // randomArray.length => 11
        int[] randomArray = new int[arraySize];

        Erik.week03.ArrayRandomNumberCount.fillArrayWithRandomGen(randomArray);
        System.out.println("-----------------Version 1------------------");
        System.out.println(Arrays.toString(randomArray));
        System.out.println("--------------------------------------------");
        int minArrayNumber = giveMinValueFromTheArray("Minimum Value from the Array is: >> ", randomArray);
        System.out.println(minArrayNumber);
        System.out.println("--------------------------------------------");
        int maxArrayNumber = giveMaxValueFromTheArray("Maximum Value from the Array is: >> ", randomArray);
        System.out.println(maxArrayNumber);
        System.out.println("--------------------------------------------");
        int averageArrayNumber = giveAverageValueFromTheArray("Average Value from the Array is: >> ", randomArray);
        System.out.println(averageArrayNumber);
        System.out.println("============================================");
        System.out.println("----------------Index Stuff-----------------");
    }

    public static int giveMinValueFromTheArray(String msg, int[] minArray) {
        int minValue = minArray[0];
        System.out.print(msg);

        for (int i = 0; i < minArray.length; i++) {

            if (minArray[i] < minValue) {
                minValue = minArray[i];
            }
        }
        return minValue;
    }

    public static int giveMaxValueFromTheArray(String msg, int[] maxArray) {
        int maxValue = maxArray[0];
        System.out.print(msg);

        for (int i = 0; i < maxArray.length; i++) {
            if (maxArray[i] > maxValue) {
                maxValue = maxArray[i];
            }
        }
        return maxValue;
    }

    public static int giveAverageValueFromTheArray(String msg, int[] averageArray) {
        int averageValue = averageArray[0];
        int sum = 0;
        System.out.print(msg);

        for ( int value : averageArray) {
            sum = sum + value;
            value = sum / averageArray.length;
            averageValue = value;
        }
        return averageValue;
    }
}
