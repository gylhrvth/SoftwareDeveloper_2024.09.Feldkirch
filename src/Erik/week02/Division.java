package Erik.week02;

public class Division {
    public static void main(String[] args) {
        int start = 0;
        int end = 20; // 20
        double dezi = 5.0;
        int withoutdezi = 5;


        System.out.println();
        System.out.println("=======Division========");
        System.out.println();
        printLoopWithCalculation(start, end, withoutdezi, dezi);
        System.out.println();
        System.out.println("=======================");
        //  test(start, end, dezi, withoutdezi);

    }

    public static void printLoopWithCalculation(int start, int end, int withoutdezi, double dezi) {
        for (int i = start; start <= end; start++) {
            System.out.printf("%d / 5 => ", start);   // %d / 5 <--- würde nur auf ganze zahlen dividieren
            System.out.println(start / withoutdezi);
            System.out.printf("%d / 5.0 = ", start);  // %d / 5.0 <-- würde auf dezimalzahlen dividieren
            System.out.println(start / dezi);
        }
    }
}
/*
    public static void test (int start, int end, double dezi, int withoutdezi){
        for (int i = start; i <= end ; i++) {
            System.out.println(i/withoutdezi);
            System.out.println(i/dezi);
        }
    }

    public static void printCalculationFloat(){
        for (float i = 0; i <= 20 ; i++) {
            System.out.printf("%2.1f / 5.0 = \n", i);
        }
    }

        for (float i = 0; i <= 5; i++) {
            System.out.printf("%2.1f / 5.0 = \n", i);
        }
*/





