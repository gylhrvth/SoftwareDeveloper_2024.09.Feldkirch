package Thiemo.week01;

public class justprint {
    public static void main(String[] args) {
        System.out.println("-----------");
        System.out.println("--printrhombus--");
        System.out.println("-----------");
        printrhombus("x ", 7);
        System.out.println("-----------");
        System.out.println("--print X--");
        System.out.println("-----------");
        printX("X ", 5);
        System.out.println("-----------");
        System.out.println("--Christmastree--");
        System.out.println("-----------");
        christmastree("X ", 9);

    }


    public static void printrhombus(String text, int size) {
        for (int reihe = 0; reihe < 2 * size - 1; reihe++) {
            for (int zeile = 0; zeile < 2 * size - 1; ++zeile) {
                if (reihe + zeile == size - 1) {
                    //   System.out.print("A ");
                    System.out.print(text);
                } else if (zeile == reihe + size - 1) {
                    //   System.out.print("B ");
                    System.out.print(text);
                } else if (reihe == zeile + size - 1) {
                    //  System.out.print("C ");
                    System.out.print(text);
                } else if (reihe + zeile == (size - 1) * 3) {
                    //System.out.print("D ");
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

    public static void christmastree(String text, int size) {
        for (int reihe = 0; reihe < size; ++reihe) {
            for (int zeile = 0; zeile < size; zeile++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}

