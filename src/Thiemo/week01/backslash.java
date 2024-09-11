package Thiemo.week01;


public class backslash {
    public static void main(String[] args) {
        System.out.println("--Übung 10-");
        System.out.println("-----------");
        printSlash("x ", 3, false);
        printSlash("y ", 4, false);

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
}