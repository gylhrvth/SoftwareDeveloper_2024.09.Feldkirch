package Sandro.Week1;

public class Rhombus {
    public static void main(String[] args) {


        PrintRhombus("X", 7, true);
        System.out.println();
        PrintRhombus("X",7,false);

    }

    public static void PrintRhombus(String symbol, int size, boolean showgrid) {

        if (showgrid) {
            for (int i = 0; i < 2 * size - 1; i++) {
                for (int j = 0; j < 2 * size - 1; j++) {
                    if (i + j == size - 1) {                            //wann ergibt i + j == size-1           (0 + 6 == 6)(1 + 5 == 6) etc
                        System.out.print(i + j);
                    } else if (j == size + i - 1) {                     //wann ergibt size +i -1 == j           (7 == 7+1 -1) (8 == 7+2 -1) etc
                        System.out.print(j);
                    } else if (j == i - size + 1) {                     //wann ergibt i-size +1 == j            (1 == 7 - 7 +1) (2 == 8 -7 +1) etc
                        System.out.print(j);
                    } else if (i + j == 3 * (size - 1)) {               //wann ergibt i + j == 3* (size-1)      (7+11 == 18(3*6) (8+10 == 18)
                        System.out.print(i + j);

                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }

        } else {
            for (int i = 0; i < 2 * size - 1; i++) {
                for (int j = 0; j < 2 * size - 1; j++) {
                    if (i + j == size - 1) {
                        // System.out.print("A");
                        System.out.print(symbol);
                    } else if (j == size + i - 1) {
                        //System.out.print("B");
                        System.out.print(symbol);
                    } else if (j == i - size + 1) {
                        //System.out.print("C");
                        System.out.print(symbol);
                    } else if (i + j == 3 * (size - 1)) {
                        //  System.out.print("D");
                        System.out.print(symbol);
                    } else {
                        System.out.print(".");
                    }

                }
                System.out.println();
            }
        }


    }
}