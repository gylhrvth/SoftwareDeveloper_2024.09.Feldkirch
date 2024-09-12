package Erik.week01;

public class PrintChristmastree {
    public static void main(String[] args) {

        printTreeTop(9);
        printO("O ", 9);
        printBottom(2);

    }

    public static void printTreeTop(int size) {
        int tree = 1;
        int space = size - 1;
        for (int i = 0; i < size; i++) {
            Print(".", space);
            PrintLn("X", tree);
            tree = tree + 2;
            space = space - 1;
        }
    }


    public static void Print(String symbol, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
    }

    public static void PrintLn(String symbol, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    public static void printO(String symbol, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    public static void printBottom(int size) {
        int bottom = 5;
        int space = size + 4;
        for (int i = 0; i < size; i++) {
            Print(".",space);
            PrintLn("+",bottom);

        }
        System.out.println();
    }
}



