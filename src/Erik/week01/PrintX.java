package Erik.week01;

public class PrintX {
    public static void main(String[] args) {
        System.out.println("==========Print X=============");
        System.out.println();
        printX("X", 10); //5
        System.out.println();
        System.out.println("==============================");
    }

    public static void printX(String symbol, int size) {
        if (size % 2 ==0){
            size--;}
//Falls size eine gerade Zahl ist wird Automatisch 1 abgezogen das das X bleibt und keine doppelte mitte bekommt

        for (int zeile = 0; zeile < size; zeile++) {
            for (int spalte = 0; spalte < size; spalte++) {
                if (zeile == spalte) {
                    System.out.print(symbol);
                } else if (zeile + spalte == size - 1) {
                    System.out.print(symbol);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
