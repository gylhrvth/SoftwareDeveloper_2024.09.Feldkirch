package Erik.week04;

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

import Erik.week03.ArrayRandomNumberCount;

import java.util.Arrays;

public class ArrayRandomNumberMinMaxAvg_Edited {
    public static void main(String[] args) {

        int arraySize = 11; // randomArray.length => 11
        int[] randomArray = new int[arraySize];

        ArrayRandomNumberCount.fillArrayWithRandomGen(randomArray);
        System.out.println("-----------------Version 1------------------");
        System.out.println(Arrays.toString(randomArray));
        System.out.println("--------------------------------------------");
        System.out.printf("Minimum Value from the Array is: >> " + giveMinValueFromTheArray(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("Maximum Value from the Array is: >> " + giveMaxValueFromTheArray(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("Average Value from the Array is: >> " + giveAverageValueFromTheArray(randomArray) + "\n");
        System.out.println("============================================");
        System.out.println("----------------Index Stuff-----------------");
        System.out.println(Arrays.toString(randomArray));
//        System.out.println("[0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10] Index Veranschaulichung");
        System.out.println("--------------------------------------------");
        System.out.printf("Minimum Value Index is: >> " + giveIndexFromMinValue(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("Maximum Value Index is: >> " + giveIndexFromMaxValue(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("The Index Positions from the Minimum Values are: >> " + Arrays.toString(givesMeAllIndexPositionsFromMinValue(randomArray)) + "\n");
        System.out.println();
        System.out.println("--Bonus--");
        System.out.printf("The Count of Minimum Value Index Positions are: >> " + giveTheCountOfAllMinValueIndices(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("The Count of Maximum Value Index Positions are: >> " + giveTheCountOfAllMaxValueIndices(randomArray) + "\n");
        System.out.println("--------------------------------------------");
    }


    public static int giveMinValueFromTheArray(int[] randomArray) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < minValue) {
                minValue = randomArray[i];
            }
        }
        return minValue;
    }

    public static int giveMaxValueFromTheArray(int[] randomArray) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] > maxValue) {
                maxValue = randomArray[i];
            }
        }
        return maxValue;
    }

    public static int giveAverageValueFromTheArray(int[] randomArray) {
        int averageValue = Integer.MAX_VALUE;
        int sum = 0;

        for (int value : randomArray) {
            sum = sum + value;
            value = sum / randomArray.length;
            averageValue = value;
        }
        return averageValue;
    }

    public static int giveIndexFromMinValue(int[] randomArray) {
        int minIndex = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < randomArray[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int giveIndexFromMaxValue(int[] randomArray) {
        int maxIndex = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] > randomArray[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int[] givesMeAllIndexPositionsFromMinValue(int[] randomArray) {
        int minValue = giveMinValueFromTheArray(randomArray);
        int range = giveTheCountOfAllMinValueIndices(randomArray);
        int indexCount = 0;
        int[] indexPositionsFromMinValues = new int[range]; //new int[randomArray.length]

        for (int i = 0; i < randomArray.length; i++) { // Geht einmal durch das ganze Array
            if (randomArray[i] == minValue) {
                indexPositionsFromMinValues[indexCount] = i;
                indexCount++;
            }
        }
        return indexPositionsFromMinValues;
    }

    public static int giveTheCountOfAllMinValueIndices(int[] randomArray) { //Nicht in der Aufgabenstellung
        int minValue = giveMinValueFromTheArray(randomArray);
        int indexCounter = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == minValue) {
                indexCounter++;
            }
        }
        return indexCounter;
    }

    public static int giveTheCountOfAllMaxValueIndices(int[] randomArray) { //Nicht in der Aufgabenstellung
        int maxValue = giveMaxValueFromTheArray(randomArray);
        int indexCounter = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] == maxValue) {
                indexCounter++;
            }
        }
        return indexCounter;
    }

}