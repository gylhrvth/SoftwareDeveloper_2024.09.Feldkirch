package Erik.week03;

/*
        Todo:   1. Erstelle einen Randomizer. (Über der Main Funktion) ✓
                2. Erstelle ein Array und füge den Randomizer hinzu in (Methode mit For i Schleife). ✓
                3. Erstelle ein Array und speicher die Größe der zu ausgebenden Zahlen hinein. (Die in der Konsole ausgegeben werden sollen) ✓
                4. Erstelle eine Methode die nur Zahlen über "30" ausgibt. ✓
                4.1 Erstelle eine for i schleife und gib den wert von array aus. ✓
                4.2 Erstelle eine If Variante wo nur den Wert über "30" ausgibt. (kan nachher ausgeblendet werden ist nur zum vergleichen) ✓
                4.3 Erstelle eine im Main definierte Variable "counter" mit 0. ✓
                4.4 Printe nach jedem vergleich den Counter und erhöhe den Counter um 1 (counter++). ✓
 */

import java.util.Random;

public class ArrayRandomNumberCount {
    public static Random randomGen = new Random();

    public static void main(String[] args) {
        int counter = 0;
        int arraySize = 15;
        int[] randomArray = new int[arraySize]; // = new int [15] geht auch
        fillArrayWithRandomGen(randomArray);
        System.out.println("-----------------");
        printIfArrayNumbersOverThirty(randomArray, counter);


    }

    public static void fillArrayWithRandomGen(int[] array) {

        for (int i = 1; i < array.length; i++) {
            array[i] = randomGen.nextInt(50,101);
        }
    }

    public static void printIfArrayNumbersOverThirty(int[] randomArray, int counter) {

        for (int i = 0; i < randomArray.length; i++) {

            if (randomArray[i] > 30) {
                counter++;      // counter 1,2,3...
                System.out.println("Counter => " + counter);
                System.out.println(randomArray[i] + " Counter => " + counter + " ");
                System.out.println("-----------------");
//                counter++;    // counter 0,1,2...
            }
        }
    }

}

