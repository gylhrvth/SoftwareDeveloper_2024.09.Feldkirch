package Erik.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        System.out.println("==========Chars==========");
        printChars("X ", 10);
        System.out.println();
        System.out.println("==========Square==========");
        System.out.println();
        printSquare("X ", 10);
        System.out.println();
        System.out.println("==========Rectangle==========");
        System.out.println();
        printRect("X ", 10, 3);
        System.out.println();
        System.out.println("==========Trinangle 1==========");
        System.out.println();
        printTrinangleBottomLeft("X ", 4);
        System.out.println();
        System.out.println("==========Trinangle 2==========");
        System.out.println();
        printTriangleTopLeft("X ", 5);
        System.out.println();
        System.out.println("==========Trinangle 3==========");
        System.out.println();
        printTriangleTopRight("X ", 5);
        System.out.println();
        System.out.println("==========Trinangle 4==========");
        System.out.println();
        printTriangleBottomRight("X ", 5);
        System.out.println();
        System.out.println("===============================");
        System.out.println();
        printEmptySquare("X ", 10);
        System.out.println();


    }

    //Aufgabe 1 Print Characters
    public static void printChars(String text, int maxLetters) {
        for (int letter = 0; letter < maxLetters; letter++) {
            System.out.print(text);
        }
    }

    //Aufgabe 2 Print Square
    public static void printSquare(String text, int maxLetters) {
        for (int reihe = 0; reihe < maxLetters; reihe++) {
            for (int letter = 0; letter < maxLetters; letter++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 3 Print Rectangle
    public static void printRect(String text, int maxLetters, int maxRep) {
        for (int reihe = 0; reihe < maxRep; reihe++) {
            for (int letter = 0; letter < maxLetters; letter++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 4 Print Trinangle 1 maxRep:4
    public static void printTrinangleBottomLeft(String text, int maxRep) {
        for (int reihe = 0; reihe < maxRep; reihe++) {
            for (int letter = 0; letter < reihe + 1; letter++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 5 Print Triangle 2 || maxRep:5
    public static void printTriangleTopLeft(String text, int maxRep) {
        for (int reihe = 0; reihe < maxRep; reihe++) {
            for (int letter = 0; letter < maxRep - reihe; letter++) {
                System.out.print(text);
            }
            System.out.println();
        }

    }

    //Aufgabe 6 Print Triangle 3 || maxRep:5
    public static void printTriangleTopRight(String text, int maxRep) {
        for (int reihe = 0; reihe < maxRep; reihe++) {
            for (int point = 0; point < reihe; point++) {
                System.out.print(". ");
            }
            for (int letter = 0; letter < maxRep - reihe; letter++) {
                System.out.print(text);
            }
            System.out.println();

        }
    }

    //Aufgabe 7 Print Triangle 4 || maxRep:5
    public static void printTriangleBottomRight(String text, int maxRep) {
        for (int reihe = 0; reihe < maxRep; reihe++) {
            for (int point = 0; point < maxRep - reihe - 1; point++) {
                System.out.print(". ");
            }
            for (int letter = 0; letter <= reihe; letter++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Aufgabe 8 Print Empty Square || maxRep:10
    public static void printEmptySquare(String text, int maxRep) {
        for (int spalte = 0; spalte < maxRep; spalte++) {
            System.out.print(text);
        }
        System.out.println();
        for (int reihe = 1; reihe < maxRep - 1; reihe++) {
            System.out.print(text);
            for (int point = 0; point < maxRep - 2; point++) {
                System.out.print(". ");
            }
            System.out.println(text);
        }
        for (int spalte = 0; spalte < maxRep; spalte++) {
            System.out.print(text);
        }

    }

    //Aufgabe 8.1 Print Empty Square
}