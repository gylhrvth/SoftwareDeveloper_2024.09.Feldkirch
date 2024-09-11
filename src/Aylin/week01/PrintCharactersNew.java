package Aylin.week01;

public class PrintCharactersNew {
    public static void main(String[] args) {
        System.out.println("Print Characters");
        printChars(10);
        System.out.println();
        System.out.println("Print Square");
        System.out.println();
        printSquare("x", 10);
        System.out.println();
        System.out.println("Print Rectangle");
        System.out.println();
        printRectangle("x", 10, 3);
        System.out.println();
        System.out.println("Print Triangle (1)");
        System.out.println();
        printTriangleBottomLeft("X ", 4);
        System.out.println();
        System.out.println("Print Triangle (2)");
        System.out.println();
        printTriangleTopLeft("A ", 5);
        System.out.println();
        System.out.println("Print Triangle (3)");
        System.out.println();
        printTriangleTopRight("T ", 5);
        System.out.println();
        System.out.println("Print Triangle (4)");
        System.out.println();
        printTriangleBottomRight("Y ", 5);
        System.out.println();
        System.out.println("Print Empty Square");
        System.out.println();
        printEmptySquare("c ", 10);
        System.out.println();
        System.out.println("Print Slash");
        System.out.println();
        printSlash("D ", 4, false);
    }

    public static void printChars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("x");
        }
    }

    public static void printSquare(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printRectangle(String text, int count, int row) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleBottomLeft(String text, int count) {
        for (int zeile = 0; zeile < count; zeile++) {
            for (int z = 0; z < zeile + 1; z++) {
                System.out.print(text);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTriangleTopLeft(String text, int count) {
        for (int zeile = 0; zeile < count; zeile++) {
            for (int a = 0; a < count - zeile; a++) {
                System.out.print(text);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTriangleTopRight(String text, int count) {
        for (int zeile = 0; zeile < count; zeile++) {
            for (int t = 0; t < count; t++) {
                if (t >= zeile) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printTriangleBottomRight(String text, int count) {
        for (int zeile = 0; zeile < count; zeile++) {
            for (int p = 0; p < count; p++) {
                if (p + zeile < count - 1) {
                    System.out.print(". ");
                } else {
                    System.out.print(text);
                }
            }
            System.out.println();
        }
    }

    public static void printEmptySquare(String text, int breite) {
        for (int zeile = 0; zeile < breite; zeile++) {
            for (int spalte = 0; spalte < breite; spalte++) {
                if (spalte == 0 || zeile == 0 || spalte == breite - 1 ||  zeile == breite - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printSlashForward(String text, int count) {
        for (int zeile = 0; zeile < count; zeile++) {
            for (int spalte = 0; spalte < count; spalte++) {
                if (zeile + spalte + 1 == count) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printSlashBackward(String text, int count) {
        for (int zeile = 0; zeile < count; zeile++) {
            for (int spalte = 0; spalte < count; spalte++) {
                if ( zeile == spalte) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printSlash(String text, int count, boolean isBackslash){
        if (isBackslash){
            printSlashBackward(text, count);
        } else {
            printSlashForward(text, count);
        }

    }

}
