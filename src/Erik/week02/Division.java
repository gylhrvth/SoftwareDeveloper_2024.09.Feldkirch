package Erik.week02;

public class Division {
    public static void main(String[] args) {
        int start = 0;
        int end = 5; // 20


        System.out.println();
        System.out.println("=======Division========");
        System.out.println();
        printLoop(start, end);
        System.out.println();
        System.out.println("=======================");

    }

    public static void printLoop(int start, int end) {
        for (int i = start; start <= end; start++) {
            System.out.printf("%d / 5 => \n", start);   // %d / 5 <--- würde nur auf ganze zahlen dividieren
            System.out.printf("%d / 5.0 = \n", start);  // %d / 5.0 <-- würde auf dezimalzahlen dividieren
        }
    }
}

/*    public static void printCalculationFloat(){
        for (float i = 0; i <= 20 ; i++) {
            System.out.printf("%2.1f / 5.0 = \n", i);
        }
    }

    /*
        for (float i = 0; i <= 5; i++) {
            System.out.printf("%2.1f / 5.0 = \n", i);
        }
*/





