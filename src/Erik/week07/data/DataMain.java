package Erik.week07.data;

import java.util.Arrays;
import java.util.Random;

public class DataMain {
    public static Random rand = new Random();

    public static void main(String[] args) {

        // Array erstellen und befüllen
        int[] testArr = new int[]{3, 6, 9, 12, 15, 18, 21};
        int[] randArr = fillArrayWithRandomNumbers(12);
        int[] crazyArr = fillArrayWithCrazyRandNumbers(12);


        // Objekte erstellen
        Data randResult = Data.calculateEverything(randArr);
        System.out.println(Arrays.toString(randArr));
        System.out.println("Random Array Min/Max/Avg\n" + randResult);
        System.out.println("x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
        Data crazyResult = Data.calculateEverything(crazyArr);
        System.out.println(Arrays.toString(crazyArr));
        System.out.println(crazyResult);


        // Methoden aufruf



    }

    // Arrays befüllen und zurückgeben
    public static int[] fillArrayWithRandomNumbers(int arraySize) {
        int[] randArr = new int[arraySize];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = rand.nextInt(100);
        }
        return randArr;
    }

    public static int[] fillArrayWithCrazyRandNumbers(int arraySize) {
        int[] randArr = new int[arraySize];
        for (int i = 0; i < randArr.length; i++) {
            randArr[i] = rand.nextInt(-50, 50);
        }
        return randArr;
    }

}

/*
        Data minValue = new Data(Data.giveMinValueFromArray(testArr));
        Data maxValue = new Data(Data.giveMaxValueFromArray(testArr));
        Data avgValue = new Data(Data.giveAverageValueFromArray(testArr));
 */
