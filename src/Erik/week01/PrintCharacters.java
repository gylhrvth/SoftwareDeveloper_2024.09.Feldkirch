//================================================================================================ 10.09
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
        System.out.println("=========Empty Square 1=========");
        System.out.println();
        printEmptySquare("X ", 10);
        System.out.println();
        System.out.println("=========Empty Square 2=========");
        System.out.println();
        printEmptySquare2("A ", 3);
        System.out.println();
        System.out.println("=========Print Slash=============");
        System.out.println();
        printSlash("A ", 3, true);
        System.out.println();
        System.out.println("=========Print backslash=========");
        System.out.println();
        printSlash("B ", 3, false);
        System.out.println();
        System.out.println("=========Print Slash 2============");
        System.out.println();
        printSlash2("Y ", 4, true);
        System.out.println();
        System.out.println("=========Print backslash 2=========");
        System.out.println();
        printSlash2("X ", 4, false);
        System.out.println();
        System.out.println("==================================");
        System.out.println();
        //printTriangleSmall("x ", 3);
        System.out.println();
        System.out.println("==================================");
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

    //Aufgabe 4 Print Trinangle 1 maxRep:4 Backslash
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

    //================================================================================================ 10.09

    //================================================================================================ 11.09

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

    //Aufgabe 8.1 Print Empty Square || maxRep:3
    public static void printEmptySquare2(String text, int maxRep) {
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

    //Aufgabe Print Slash
    // Print Slash Original (/) || maxRep:3
    public static void printForwardSlash(String text, int maxRep) {
        for (int reihe = 0; reihe < maxRep; reihe++) {
            for (int spalte = 0; spalte < maxRep - reihe - 1; spalte++) {
                System.out.print(" ");
            }
            System.out.print(text);
            System.out.println();
        }
    }

    //Print backSlash (\)  || maxRep:3
    public static void printBackSlash(String text, int maxRep) {
        for (int zeile = 0; zeile < maxRep; zeile++) {
            for (int spalte = 0; spalte < zeile; spalte++) {
                System.out.print(" ");
            }
            System.out.print(text);
            System.out.println();
        }
    }

    public static void printSlash(String text, int maxRep, boolean isBackSlash) {
        if (isBackSlash) {
            printBackSlash(text, maxRep);
        } else {
            printForwardSlash(text, maxRep);
        }
    }

    //Print Forward Slash 2 (/) ||  maxRep:4
    public static void printForwardSlash2(String text, int maxRep) {
        for (int zeile = 0; zeile < maxRep; zeile++) {
            for (int spalte = 0; spalte < maxRep; spalte++) {
                if (zeile + spalte == maxRep - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //Print Backward Slash 2 (\) || maxRep:4
    public static void printBackSlash2(String text, int maxRep) {
        for (int zeile = 0; zeile < maxRep; zeile++) {
            for (int spalte = 0; spalte < maxRep; spalte++) {
                if (spalte == zeile) {
                    System.out.print(text);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    //If-Else + Boolean
    public static void printSlash2(String text, int maxRep, boolean isBackSlash2) {
        if (isBackSlash2) {
            printBackSlash2(text, maxRep);
        } else {
            printForwardSlash2(text, maxRep);
        }
    }
}
    //================================================================================================ 11.09

    //================================================================================================ 12.09






