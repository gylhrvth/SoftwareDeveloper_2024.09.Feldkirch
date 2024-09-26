package Erik.week03;

/*
        Todo:   1. Erstelle ein RandomGen.✓
                2. Erstelle eine Array Size variable, für die Ausgabe. ✓
                3. Erstelle ein int Array. ✓
                4. Erstelle eine Methode wo die Randomzahlen von -50 bis 50 in ein Array eingelesen wird. ✓
                4.1 Versuche ob die Randomzahl einlese Methode funktioniert. ✓
                5. Erstelle eine For Each Schleife um diese Randomzahlen ausgegeben werden. ✓
 */


import java.util.Random;

public class ArrayRandomNumberCrazyRange {
    public static Random randomGen = new Random();

    public static void main(String[] args) {

        int arraySize = 15;



        int[] randomArray = new int[arraySize];

        fillArrayWithRandomGen(randomArray);
        System.out.println("-------------------------------------------------------------------");
        printRandomArrayWithForEach("Print Randomizer -50 to 50 with For Each Schleife: " + arraySize + " Times", randomArray);
        System.out.println("-------------------------------------------------------------------");
    }


    public static void fillArrayWithRandomGen(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = randomGen.nextInt(-50,51 );
//            System.out.print(array[i] + " ");
        }
    }

    public static void printRandomArrayWithForEach(String msg,int[] randomArray){
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


}
