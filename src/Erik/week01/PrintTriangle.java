package Erik.week01;

public class PrintTriangle {
    public static void main(String[] args) {
        System.out.println("=============Print Triangle Small==================");
        System.out.println();
        printTriangleSmall("I ", 3);
        System.out.println();
        System.out.println("==============Print Triangle Big===================");
        System.out.println();
        printTriangleBig("I ", 5);
        System.out.println();
        System.out.println("===================================================");


    }

    // Triangle Small || size:3 (0-2)
    public static void printTriangleSmall(String symbol, int size) {
        for (int reihe = 0; reihe < size; reihe++) {
            for (int spalte = 0; spalte < size * 2 - 1; spalte++) {
                if (reihe + spalte == size - 1) {
                    System.out.print(symbol);
                } else if (spalte == size - 1 + reihe) {
                    System.out.print(symbol);

                } else if (reihe == size - 1) {
                    System.out.print(symbol);
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public static void printTriangleBig(String symbol, int size) {
        for (int reihe = 0; reihe < size; reihe++) {
            for (int spalte = 0; spalte < size * 2 - 1; spalte++) {
                if (reihe + spalte == size - 1) {
                    System.out.print(symbol);
                } else if (spalte == size - 1 + reihe) {
                    System.out.print(symbol);

                } else if (reihe == size - 1) {
                    System.out.print(symbol);
                } else {
                    System.out.print("* ");
                }

            }
            System.out.println();
        }
    }
}
