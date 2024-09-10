package Thiemo.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        System.out.println("-----------");
        System.out.println("--Übung 1--");
        System.out.println("-----------");
        printchars("x", 10);
        System.out.println("-----------");
        System.out.println("--Übung 2--");
        System.out.println("-----------");
        printsqaure("x", 10);
        System.out.println("-----------");
        System.out.println("--Übung 3--");
        System.out.println("-----------");
        printrectangle("x", 2, 5);
        System.out.println("--Übung 4--");
        System.out.println("-----------");
        printtriangle("x", 4);
        System.out.println("-----------");
        System.out.println("--Übung 5--");
        System.out.println("-----------");
        printtriangle2("x", 5);
        System.out.println("-----------");
        System.out.println("--Übung 6--");
        System.out.println("-----------");
        printtriangle3("x", 5);
        System.out.println("-----------");
        System.out.println("--Übung 7--");
        System.out.println("-----------");
        printtriangle4("x", 5);
        System.out.println("-----------");
        System.out.println("-Bonusübung");
        System.out.println("-----------");
        printtriangle4("x", 5);

    }

    public static void printchars(String text, int count) {
        for (int r = 0; r <= count; ++r)
            System.out.print(text);
        System.out.println();

    }

    public static void printsqaure(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int c = 0; c < count; ++c) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printrectangle(String text, int countColumns, int countLines) {
        for (int row = 0; row < countLines; row++) {
            for (int c = 0; c < countColumns; ++c) {
                System.out.print(text);
            }
            System.out.println(text);

        }
    }

    public static void printtriangle(String text, int count) {
        for (int r = 0; r < count; r++) {
            for (int c = 0; c <= r; c++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printtriangle2(String text, int count) {
        for (int r = 0; r <= count; r++) {
            for (int c = 0; c < count - r; ++c) {
                System.out.print(text);
            }
            System.out.println();
        }

    }

    public static void printtriangle3(String text, int count) {
        for (int r = 0; r < count; r++) {
            for (int s = 0; s < r; s++) {
                System.out.print(".");
            }
            for (int c = 0; c < count - r; ++c) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printtriangle4(String text, int count) {
        for (int r = 0; r < count; r++) {
            for (int s = 0; s < count - r - 1; s++) {
                System.out.print(".");
            }
            for (int c = 0; c <= r; ++c) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void BonusÜbung(String text, int count) {
        for (int r = 0; r < count; r++) {
            for (int s = 0; s < count - r - 1; s++) {
                System.out.print(".");
            }
            for (int c = 0; c <= r; ++c) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
    }