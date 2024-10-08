package Thiemo.week01;

public class PrintCharacters {
    public static void main(String[] args) {
//        System.out.println("-----------");
//        System.out.println("--characters--");
//        System.out.println("-----------");
//        printchars("x ", 10);
//        System.out.println("-----------");
//        System.out.println("--suqare--");
//        System.out.println("-----------");
//        printsqaure("x ", 10);
//        System.out.println("-----------");
//        System.out.println("--rectangle--");
//        System.out.println("-----------");
//        printrectangle("x ", 2, 5);
//        System.out.println("-----------");
//        System.out.println("--trinagle--");
//        System.out.println("-----------");
//        printtriangleBottomLeft("x ", 4);
//        System.out.println("-----------");
//        System.out.println("--triagnelBottomleft--");
//        System.out.println("-----------");
//        printtriangleTopLeft("x ", 5);
//        System.out.println("-----------");
//        System.out.println("--triangleTopright--");
//        System.out.println("-----------");
//        printtriangleTopRight("x ", 5);
//        System.out.println("===================");
//        System.out.println("--triangleBottomright--");
//        System.out.println("===================");
//        printtriangleBottomRight("x ", 10);
//        System.out.println("-----------");
//        System.out.println("-Bonusübung");
//        System.out.println("-----------");
//        Bonusuebung("x ", 5);
//        System.out.println("-----------");
//        System.out.println("--emtpySquare--");
//        System.out.println("-----------");
//        EmptySquareX("x ", 10);
//        System.out.println("-----------");
//        System.out.println("--emtpySquareA--");
//        System.out.println("-----------");
//        EmptySquareA("A ", 3);
//        System.out.println("-----------");
//        System.out.println("--printslash-");
//        System.out.println("-----------");
//        printSlash("x ", 3, true);
//        printSlash("y ", 4, false);
//        System.out.println("-----------");
//        System.out.println("--triangle 3X-");
//        System.out.println("-----------");
//        printtriangle1("x ", 3);
//        System.out.println("===============");
//        System.out.println("==triangle 5X");
//        System.out.println("===============");
//        printtriangle2("x ", 5);
        System.out.println("===============");
        System.out.println("==Rhombus 7X");
        System.out.println("===============");
        printrhombus("X ", 7);
//        System.out.println("===============");
//        System.out.println("==PrintX 5X");
//        System.out.println("===============");
//        printX("x ", 6);
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
                System.out.print(".");
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
                System.out.print(".");
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
                if (row + column + 1 == count) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();

        }
    }

    public static void printSlash(String text, int count, boolean isBackslash) {
        if (isBackslash) {
            printSlashBackward(text, count);
        } else {
            printSlashForward(text, count);
        }
    }

    public static void printtriangle1(String text, int size) {
//        System.out.println();
//        System.out.println("  x  ");
//        System.out.println(" x x ");
//        System.out.println("xxxxx");
//        System.out.println();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < 2 * size - 1; column++) {
                if (row + column == size - 1) {
                    System.out.print(text);
                } else if (column == row + size - 1) {
                    System.out.print(text);
                } else if (row == size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printtriangle2(String text, int size) {
        for (int reihe = 0; reihe < size; reihe++) {
            for (int zeile = 0; zeile < 2 * size - 1; ++zeile) {
                if (reihe + zeile == size - 1) {
                    System.out.print(text);
                } else if (zeile == reihe + size - 1) {
                    System.out.print(text);
                } else if (reihe == size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

    }

    public static void printrhombus(String text, int size) {
        for (int reihe = 0; reihe < 2 * size - 1; reihe++) {
            for (int zeile = 0; zeile < 2 * size - 1; ++zeile) {
                if (reihe + zeile == size - 1) {
                    //   System.out.print("A ");
//                    System.out.print(zeile + reihe);
                    System.out.print(text);
                } else if (zeile == reihe + size - 1) {
                    //   System.out.print("B ");
//                    System.out.print(zeile);
                    System.out.print(text);
                } else if (reihe == zeile + size - 1) {
                    //  System.out.print("C ");
//                    System.out.print(reihe);
                    System.out.print(text);
                } else if (reihe + zeile == (size - 1) * 3) {
                    //System.out.print("D ");
//                    System.out.print(zeile + reihe);
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void printX(String text, int size) {
        if (size % 2 == 0) {
            size = size - 1;
            // size--;

        }
        for (int reihe = 0; reihe < size; reihe++) {
            for (int zeile = 0; zeile < size; zeile++) {
                if (reihe == zeile) {
                    System.out.print(text);
                } else if (reihe == size - zeile - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }

            }
            System.out.println();
        }
    }
}