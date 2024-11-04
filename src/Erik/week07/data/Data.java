package Erik.week07.data;

import java.util.Random;

public class Data {

    // Attribute min max average
    private int minValue;
    private int maxValue;
    private int averageValue;

    // Konstruktor
    public Data() {
        this.minValue = 0;
        this.maxValue = 0;
        this.averageValue = 0;
    }

    @Override
    public String toString() {
        return "Min Value of the Array is: >> " + minValue +
                "\nMax Value of the Array is: >> " + maxValue +
                "\nAverage Value of the Array is: >> " + averageValue;
    }


    // Getter, Setter

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getAverageValue() {
        return averageValue;
    }


    //eine funktion min, max, avg ausrechnen
    public static Data calculateEverything(int[] arr) {

        Data test = new Data();

        if (arr[0] > 0) {

            test.minValue = arr[0];
            test.maxValue = arr[0];
            test.averageValue = 0;

            int sum = 0;

            for (int i = 0; i < arr.length ; i++) {
                sum += arr[i];
                test.minValue = Math.min(test.minValue, arr[i]);
                test.maxValue = Math.max(test.maxValue, arr[i]);
            }
            test.averageValue = sum / arr.length;
        }
        return test;
    }

/*
    public static int giveMinValueFromArray(int[] minArray) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < minArray.length; i++) {
            if (minArray[i] < minValue) {
                minValue = minArray[i];
            }
        }
        return minValue;
    }

    public static int giveMaxValueFromArray(int[] maxArray) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < maxArray.length; i++) {
            if (maxArray[i] > maxValue) {
                maxValue = maxArray[i];
            }
        }
        return maxValue;
    }

    public static int giveAverageValueFromArray(int[] avgArray) {
        int avgValue = 0;
        int sum = 0;

        for (int value : avgArray) {
            sum = sum + value;
            value = value / avgArray.length;
            avgValue = value;
        }
        return avgValue;
    }
*/
}
