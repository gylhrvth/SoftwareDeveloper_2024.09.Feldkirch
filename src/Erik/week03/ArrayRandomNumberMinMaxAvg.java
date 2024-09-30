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
        System.out.printf("Minimum Value from the Array is: >> " + giveMinValueFromTheArray(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("Maximum Value from the Array is: >> " + giveMaxValueFromTheArray(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("Average Value from the Array is: >> " + giveAverageValueFromTheArray(randomArray) + "\n");
        System.out.println("============================================");
        System.out.println("----------------Index Stuff-----------------");
        System.out.println(Arrays.toString(randomArray));
        System.out.println("[0 , 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10] Index Veranschaulichung");
        System.out.println("--------------------------------------------");
        System.out.printf("Minimum Value Index is: >> " + giveIndexFromMinValue(randomArray) + "\n");
        System.out.println("--------------------------------------------");
        System.out.printf("Maximum Value Index is: >> " + giveIndexFromMaxValue(randomArray) + "\n");
        System.out.println("--------------------------------------------");
    }

    public static int giveMinValueFromTheArray(int[] minArray) {
        int minValue = minArray[0];

        for (int i = 0; i < minArray.length; i++) {
            if (minArray[i] < minValue) {
                minValue = minArray[i];
            }
        }
        return minValue;
    }

    public static int giveMaxValueFromTheArray(int[] maxArray) {
        int maxValue = maxArray[0];

        for (int i = 0; i < maxArray.length; i++) {
            if (maxArray[i] > maxValue) {
                maxValue = maxArray[i];
            }
        }
        return maxValue;
    }

    public static int giveAverageValueFromTheArray(int[] averageArray) {
        int averageValue = averageArray[0];
        int sum = 0;

        for (int value : averageArray) {
            sum = sum + value;
            value = sum / averageArray.length;
            averageValue = value;
        }
        return averageValue;
    }

    public static int giveIndexFromMinValue(int[] randomArray) {
        int minIndex = 0;

        for (int i = 0; i < randomArray.length; i++) {
            if (randomArray[i] < randomArray[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int giveIndexFromMaxValue(int[] randomArray){
        int maxIndex = 0;

        for (int i = 0; i < randomArray.length ; i++) {
            if (randomArray[i] > randomArray[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int giveIndexFromMoreMinOrMaxValues(int[] randomArray){
        int moreIndexPos = 0;

        for (int i = 0; i < randomArray.length; i++) {

        }


        return 0;
    }
}
//        int minValueIndex = indexArray[0];
//        System.out.print(msg);
//
//        for (int minValueIndex : indexArray){
//            System.out.print(minValueIndex);
//            System.out.print(" ");
//        }

//        for (int i = 0; i < indexArray.length; i++) {
//            if (minValueIndex < minArrayNumber) {
//
//            }
//        }
//        return 0;
