package Erik.week01;

public class PrintRhombus {
    public static void main(String[] args) {
        System.out.println("===========Print Rhombus=============");
        System.out.println();
        printRhombus("I", 12);//7
        System.out.println();
        System.out.println("=====================================");


    }

    public static void printRhombus(String symbol, int size) {
        for (int zeile = 0; zeile < size * 2 - 1; zeile++) {
            for (int spalte = 0; spalte < size * 2 - 1; spalte++) {
                if (zeile + spalte == size - 1) { //funkt 1.
                    System.out.print(symbol);
                } else if (zeile - spalte == size - 1) { //funkt 2.
                    System.out.print(symbol);
                } else if (zeile + spalte == size * 3 - 3) { //funkt3.
                    System.out.print(symbol);
                } else if (spalte - zeile == size - 1) { //funkt4.
                    System.out.print(symbol);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
