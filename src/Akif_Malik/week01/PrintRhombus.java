package Akif_Malik.week01;

public class PrintRhombus {
    public static void main(String[] args) {
        printRhombus("x", 7);

    }



    public static void printRhombus(String text, int maxRep) {
        for (int row = 0; row < maxRep ; row++) {
            for (int column = 0; column < row; column++) {
                System.out.print(". ");
            }
            System.out.println(text);

        }
        for (int row = 0; row < maxRep ; row++) {
            for (int column = 0; column < maxRep-row - 1  ; column++) {
                System.out.print(". ");
            }
            System.out.println(text);
        }

    }
}
