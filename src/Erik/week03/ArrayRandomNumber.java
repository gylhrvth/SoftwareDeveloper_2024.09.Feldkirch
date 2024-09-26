package Erik.week03;

import java.util.Scanner;
import java.util.Random;

/*
       Todo:    1. Erstelle einen RandomGenerator. ♥
                2. Erstelle ein Array mit "selbst eingegebenen Zufallszahlen" und gib dieses aus.♥
                3. Erstelle eine Methode/Funktion die Zufallszahlen von 0-100 vom RandomGen in die Array zu implementieren.
                3.1 Zufallszahlen mit einer For i Schleife in ein Array implementieren.
                4. Erstelle eine Variable um die Länge des Arrays zu definieren für die Ausgabe zb. 5 Zufallszahlen ausgeben.
                5. Mache eine for each-Schleife und gib die Zufallszahlen aus.
                6. Mache das selbe wie bei 5. nur mit einer for i-Schleife.
                7. Gib nur den zweiten, fünften und zehnten Wert des Arrays aus.
                8. Gib jeden zweiten Wert des Arrays mit Hilfe einer Schleife aus. (for i)
*/

public class ArrayRandomNumber {
    public static Random randomGen = new Random();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int arraySize = 15;
        int[] randomArray = new int[arraySize];
//        int randomNumbers = randomGen.nextInt(100);

        fillArrayWithRandomGen(randomArray);
        System.out.println("-------------------------------------------------------------------");
        printArrayWithForEach("Print Array with For-Each Schleife", randomArray);
        System.out.println("-------------------------------------------------------------------");
        printArrayWithForI("Print Array with For-I Schleife", randomArray);
        System.out.println("-------------------------------------------------------------------");
        printPickedArrayValue("Print out the Second, Fifth and tenth Index Out", randomArray);
        System.out.println("-------------------------------------------------------------------");
        printEverySecondArrayValue("Just Print every Second Index from the Array", randomArray);

//        printPickedArrayValueWithUserInput(randomArray);


//        int [] arrRandom = new int[]{5, 3, 20, 11, 7, 90, 80};
    }

    public static void fillArrayWithRandomGen(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = randomGen.nextInt(100);
        }
    }

    public static void printArrayWithForEach(String msg, int[] randomArray) {
        System.out.println(msg);
        boolean komma = true;

        System.out.print("[");
        for (int value : randomArray){
            if(!komma){  // (!komma) = (komma == false)
                System.out.print(", ");
            }
            System.out.print(value);
            komma = false;
        }
        System.out.println("]");
    }

    public static void printArrayWithForI(String msg, int[] randomArray) {
        System.out.println(msg);
        System.out.print("[");
        for (int i = 0; i < randomArray.length; i ++) {
            if (i > 0){
                System.out.print(", ");
            }
            System.out.print(randomArray[i]);
        }
        System.out.println("]");
    }

    public static void printPickedArrayValue(String msg, int[] randomArray) {
        System.out.println(msg);
        System.out.print("[");
        testPickedArray(randomArray, 1);
        System.out.print(", ");
        testPickedArray(randomArray, 4);
        System.out.print(", ");
        testPickedArray(randomArray, 9);
        System.out.println("]");
    }

    public static void printEverySecondArrayValue(String msg, int[] randomArray) {
        System.out.println(msg);
        System.out.print("[");
        for (int i = 0; i < randomArray.length; i += 2) {
            if (i > 0){
                System.out.print(", ");
            }
            System.out.print(randomArray[i]);
        }
        System.out.println("]");
    }

    public static void testPickedArray(int[] randomArray, int indexArray) {

        if (indexArray < randomArray.length) {
            System.out.print(randomArray[indexArray]);
        } else {
            System.out.println("Not Available");
        }

    }

    public static void printPickedArrayValueWithUserInput(int[] randomArray) {
        System.out.print("Gib den Index des gewünschten Elements ein: >> ");
        int index = sc.nextInt();
        boolean vailidIndex = false;

        while (!vailidIndex) {
            if (index >= 0 && index < randomArray.length) {
                System.out.println("Der Wert an Index " + index + " ist: " + randomArray[index]);
                vailidIndex = true;
            } else {
                System.out.println("Ungültiger Index. Bitte einen Wert zwischen 0 und " + (randomArray.length - 1) + " eingeben.");
            }
        }
    }
}
