package Erik.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        printChars("x ", 10);
        System.out.println();
        System.out.println("============================"); //Ende erste Aufgabe
        printSquare("x", 10);
        System.out.println("============================"); //Ende zweite Aufgabe
        printRect("A ", 10, 3);
        System.out.println("============================"); //Ende dritte Aufgabe
        printTrinangleBottomLeft("X ", 4);
        System.out.println("============================"); //Ende vierte Aufgabe
        printTriangleTopLeft("x ", 5);
        System.out.println("============================"); //Ende fünfte Aufgabe
        printTriangleTopRight("x", 5);

    }

    //Aufgabe 1 Print Characters
    public static void printChars(String text, int menge) {
        for (int i = 0; i < menge; i++) {
            System.out.print(text);
        }
    }

    //Aufgabe 2 Print Square
    public static void printSquare(String text, int menge) {
        for (int repB = 0; repB < menge; repB++) {
            for (int rep = 0; rep < menge; rep++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 3 Print Rectangle
    public static void printRect(String text, int maxBlock, int maxRep) {
        for (int repB = 0; repB < maxRep; repB++) {
            for (int block = 0; block < maxBlock; block++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 4 Print Trinangle 1
    public static void printTrinangleBottomLeft(String text, int maxRep) {
        for (int repB = 0; repB < maxRep; repB++) {
            for (int block = 0; block < repB + 1; block++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 5 Print Triangle 2
    public static void printTriangleTopLeft(String text, int maxRep) {
        for (int repB = 0; repB < maxRep; repB++) {
            for (int block = 0; block < maxRep - repB; block++) {
                System.out.print(text);
            }
            System.out.println();
        }

    }

    //Aufgabe 6 Print Triangle 3 || maxRep 5
    public static void printTriangleTopRight(String text, int maxRep) {
        for (int repBM = 0; repBM < maxRep; repBM++) {
            for (int repP = 0; repP < repBM; repP++) {
                System.out.print(".");
            }
            for (int repBS = 0; repBS < maxRep - repBM; repBS++) {
                System.out.print(text);
            }
            System.out.println();

        }
    }
    //Aufgabe 7 Print Triangle 4 || maxRep 5


}