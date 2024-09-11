package Thiemo.week01;

public class GyulaExamples {
    public static void main(String[] args) {
        System.out.println("==============");
        printEmptySquere("x ", 10);
        System.out.println("==============");
        printEmptySquere2("y ", 5);
        System.out.println("==============");
    }

    public static void printEmptySquere(String text, int size){
        // Erste Zeile
        for (int col = 0; col < size; col++) {
            System.out.print(text);
        }
        System.out.println();

        // Mittlere Teil
        for (int row = 0; row < size - 2; row++) {
            // Erste X in der Zeile
            System.out.print(text);
            // Leer in der Mitte
            for (int col = 0; col < size - 2; ++col){
                System.out.print(". ");
            }
            // Letzte X in der Zeile
            System.out.println(text);
        }

        // Letze Zeile
        for (int col = 0; col < size; col++) {
            System.out.print(text);
        }
        System.out.println();

    }

    public static void printEmptySquere2(String text, int size){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if ((col == 0) || (row == 0) || (col == size - 1) || (row == size - 1)) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}
