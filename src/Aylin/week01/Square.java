package Aylin.week01;

public class Square {
    public static void main(String[] args) {
        System.out.println("Print Empty Square");
        System.out.println();
        printEmptySquare(10);
    }

    public static void printEmptySquare(int breite) {
        for (int zeile = 0; zeile < breite; zeile++) {
            for (int spalte = 0; spalte < breite; spalte++) {
                if (spalte == 0 || zeile == 0 || spalte == breite - 1 ||  zeile == breite - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
