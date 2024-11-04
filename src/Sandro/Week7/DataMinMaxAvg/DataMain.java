package Sandro.Week7.DataMinMaxAvg;

import java.util.Arrays;
import java.util.Random;

public class DataMain {
    static Random rand = new Random();
    public static void main(String[] args) {

        int[] input = new int[]{1, 3, 4, 5, 6, 9,};
        int[] crazyNumber = crazyRandomnumbers(10);
        int[] randNumber = createRandomArray(10);
/*
        //objekt erstellen = objekt.funktion(input)
        DataObjekt getResult = DataObjekt.calculate(input);
        //toString array sichtbar machen
        System.out.println(Arrays.toString(input));
        //sout(objekt) printen = override toString funktion der Klasse
        System.out.println(getResult);

        System.out.println("#################################");
        getResult = DataObjekt.calculate(crazyNumber);
        System.out.println(Arrays.toString(crazyNumber));
        System.out.println(getResult);
*/

    }

    public static int[] crazyRandomnumbers(int arrayspace) {
        int[] crazyRandom = new int[arrayspace];
        for (int i = 0; i < crazyRandom.length; i++) {
            int randomValue = rand.nextInt(-50, 51);
            crazyRandom[i] = randomValue;
        }

        return crazyRandom;
    }

    public static int[] createRandomArray(int arrayspace) {
        int[] result = new int[arrayspace];
        for (int i = 0; i < result.length; i++) {
            result[i] = rand.nextInt(101);
        }
        return result;
    }


}
