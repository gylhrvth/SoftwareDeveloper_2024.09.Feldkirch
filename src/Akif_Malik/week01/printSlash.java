package Akif_Malik.week01;

public class printSlash {
    public static void main(String[] args) {
        printslash("x ", 9, false);
        System.out.println(" .-. .-. .-. .-. .-. .-. .-. ");
        System.out.println();
        printslash("y ", 10, true);

    }

    public static void printslash(String text, int maxRep, boolean isBackslash) {
        if (isBackslash){
            printBackSlash(text, maxRep);
        } else {
            printForwardSlash(text, maxRep);
        }
    }

    public static void printBackSlash(String text, int maxRep) {
        for (int row = 0; row < maxRep ; row++) {
            for (int column = 0; column < row; column++) {
                System.out.print(". ");
            }
            System.out.println(text);

        }
    }

    public static void printForwardSlash(String text, int maxRep) {
        for (int row = 0; row < maxRep ; row++) {
            for (int column = 0; column < maxRep-row - 1  ; column++) {
                System.out.print(". ");
            }
            System.out.println(text);
        }
        System.out.println();

    }

}
