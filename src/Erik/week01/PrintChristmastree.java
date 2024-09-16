package Erik.week01;

public class PrintChristmastree {
    public static void main(String[] args) {
        System.out.println("================Print X-Mas Tree================");
        System.out.println();
        printWholeTree(9);
        System.out.println();
        System.out.println("================================================");


    }

    public static void printWholeTree(int size) {
        int tree = 1;
        int space = size - 1;
        for (int i = 0; i < size; i++) {
            Print(".", space);
            PrintLn("X", tree);
            tree = tree + 2;
            space = space - 1;
        }
        for (int i = 0; i < size; i++) {
            System.out.print("0 ");
        }
        System.out.println();
        int bottom = size / 3;
        int filler = size - 3;
        for (int i = 0; i < 3; i++) {
            Print(".", filler);
            PrintLn("+", bottom);
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
}


    /* public static void printO(String symbol, int count) {
         for (int i = 0; i < count; i++) {
             System.out.print(symbol);
         }
         System.out.println();
     }

    public static void printBottom(int size) {
        int bottom = 5;
        int filler = size + 4;
        for (int i = 0; i < size; i++) {
            Print(".", filler);
            PrintLn("+", bottom);

        }
        System.out.println();
    }

     */



