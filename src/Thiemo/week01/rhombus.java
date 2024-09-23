package Thiemo.week01;

public class rhombus {
    public static void main(String[] args) {


        System.out.println("===============");
        System.out.println("==Rhombus 7X");
        System.out.println("===============");

        printrhombus("X ", 7);
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

}



