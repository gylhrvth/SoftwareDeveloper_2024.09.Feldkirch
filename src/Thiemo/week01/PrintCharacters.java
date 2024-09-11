package Thiemo.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        System.out.println("-----------");
        System.out.println("--Übung 1--");
        System.out.println("-----------");
        printchars("x ", 10);
        System.out.println("-----------");
        System.out.println("--Übung 2--");
        System.out.println("-----------");
        printsqaure("x ", 10);
        System.out.println("-----------");
        System.out.println("--Übung 3--");
        System.out.println("-----------");
        printrectangle("x ", 2, 5);
        System.out.println("-----------");
        System.out.println("--Übung 4--");
        System.out.println("-----------");
        printtriangleBottomLeft("x ", 4);
        System.out.println("-----------");
        System.out.println("--Übung 5--");
        System.out.println("-----------");
        printtriangleTopLeft("x ", 5);
        System.out.println("-----------");
        System.out.println("--Übung 6--");
        System.out.println("-----------");
        printtriangleTopRight("x ", 5);
        System.out.println("-----------");
        System.out.println("--Übung 7--");
        System.out.println("-----------");
        printtriangleBottomRight("x ", 5);
        System.out.println("-----------");
        System.out.println("-Bonusübung");
        System.out.println("-----------");
        Bonusuebung("x ", 5);
        System.out.println("-----------");
        System.out.println("--Übung 8--");
        System.out.println("-----------");
        EmptySquareX("x ", 10);
        System.out.println("-----------");
        System.out.println("--Übung 9--");
        System.out.println("-----------");
        EmptySquareA("A ", 3);
        System.out.println("-----------");
        System.out.println("--Übung 10-");
        System.out.println("-----------");
        printSlash("x ", 3, true);
        printSlash("y ", 4, false);


    }

    //Übung 1 (text: x count: 10)
    public static void printchars(String text, int count) {
        for (int row = 0; row < count; ++row)
            System.out.print(text);
        System.out.println();

    }

    //Übung 2 (text: x count: 10)
    public static void printsqaure(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; ++column) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Übung 3 (text: x columns: 10 lines: 3)
    public static void printrectangle(String text, int countColumns, int countLines) {
        for (int row = 0; row < countLines; row++) {
            for (int column = 0; column < countColumns; ++column) {
                System.out.print(text);
            }
            System.out.println(text);

        }
    }

    //Übung 4 (text: x count: 4)
    public static void printtriangleBottomLeft(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column <= row; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Übung 5 (text: x count: 5)
    public static void printtriangleTopLeft(String text, int count) {
        for (int row = 0; row <= count; row++) {
            for (int column = 0; column < count - row; ++column) {
                System.out.print(text);
            }
            System.out.println();
        }

    }

    //Übung 6 (text: x count: 5)
    public static void printtriangleTopRight(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int spacebar = 0; spacebar < row; spacebar++) {
                System.out.print(". ");
            }
            for (int column = 0; column < count - row; ++column) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //Übung 7 (text: x count: 5)
    public static void printtriangleBottomRight(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int spacebar = 0; spacebar < count - row - 1; spacebar++) {
                System.out.print(". ");
            }
            for (int column = 0; column <= row; ++column) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    //BonusÜbung  (text: x count: 5)
    public static void Bonusuebung(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; ++column) {
                if (row <= column) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    //Übung 8 (text: x count: 10)
    public static void EmptySquareX(String text, int count) {
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
        for (int row = 2; row < count; row++) {
            System.out.print(text);
            for (int spacebar = 2; spacebar < count; ++spacebar) {
                System.out.print(". ");
            }
            System.out.println(text);
        }
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
            System.out.println();
    }



    //Übung 9 (text: x count: 10)
    public static void EmptySquareA(String text, int count) {
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
        for (int row = 2; row < count; row++) {
            System.out.print(text);
            for (int spacebar = 2; spacebar < count; ++spacebar) {
                System.out.print(". ");
            }
            System.out.println(text);
        }
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
    }
    //Übung 10 (text: x count: 3)
    public static void printSlashBackward(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; ++column) {
                if (row == column) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printSlashForward(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; ++column) {
                if (row + column +1 == count) {
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
