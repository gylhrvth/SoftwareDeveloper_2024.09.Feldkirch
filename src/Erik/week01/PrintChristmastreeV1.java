package Erik.week01;

public class PrintChristmastreeV1 {
    public static void main(String[] args) {
        System.out.println("===========Print Christmas Tree=============");
        System.out.println();
        printWholeTree("*", 9);
        printBottom(2);
        System.out.println();
        System.out.println("============================================");
    }

    public static void printWholeTree(String symbol, int size) {
        for (int zeile = 0; zeile < size + 1; zeile++) {
            for (int spalte = 0; spalte < size * 2 - 1; spalte++) {
                if (zeile + spalte == size - 1) {
                    System.out.print(symbol);
                } else if (zeile == size - 1) {
                    System.out.print(symbol);
                } else if (spalte - zeile == size - 1) {
                    System.out.print(symbol);
                } else if (zeile == size - spalte % 2) {
                    System.out.print("0");
                }
                /*
                     else if (zeile == size+1) {
                    System.out.print("+");}
                */

                else {
                    System.out.print("'");
                }
            }
            System.out.println();
        }
    }


    public static void printBottom(int size) {
        int space = 6;
        int bottom = 5;
        for (int i = 0; i < size; i++) {
            Print("'", space);
            Print("+", bottom);
            System.out.println();
        }

    }

    public static void Print(String symbol, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
    }


}




/*
else if (zeile - size+1 == size % 2 ) {
                    System.out.print("0 ");
                }





    public static void printBall(String symbol, int size) {
        for (int zeile = 0; zeile < size; zeile++) {
            for (int spalte = 0; spalte < size; spalte++) {
                if (zeile == spalte + 2) {
                    System.out.print(symbol);
                } else {
                    System.out.print("' ");
                }
            }
            System.out.println();
        }
    }
}
*/