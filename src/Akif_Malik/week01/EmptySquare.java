package Akif_Malik.week01;

public class EmptySquare {
    public static void main(String[] args) {
        printEmptySquare("x ", 10);

    }

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
}
