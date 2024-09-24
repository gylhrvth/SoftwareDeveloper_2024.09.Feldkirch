package Erik.week03;

import Gyula.ConsoleTools;
import java.util.Arrays;

public class ArrayNumber {
    public static void main(String[] args) {
        int size = ConsoleTools.readNumber("Gib die Größe des Array's ein: ", 0, 10);
        int[] ar = createAndFillArray(size);
        System.out.println(Arrays.toString(ar));
        System.out.println("===============================");
        int size_2 = ConsoleTools.readNumber("Gib die Größe des 2. Array's ein: ", 0, 10);
        int[] ar_2 =createAndFillArray_2(size_2);
        System.out.println(Arrays.toString(ar_2));
    }

    public static int[] createAndFillArray(int size){
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static int[] createAndFillArray_2 (int size_2){
        int [] result = new int [size_2];
        for (int i = 0; i < result.length ; i++) {
            result[i] = size_2 - i;
        }

        return result;
    }
}
