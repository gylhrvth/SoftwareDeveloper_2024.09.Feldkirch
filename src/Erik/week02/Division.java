package Erik.week02;

public class Division {
    public static void main(String[] args) {
        int start = 0;
        int end = 5; // 20
        float komma = 0;

        System.out.println();
        System.out.println("=======Division========");
        System.out.println();
        printCalculationInt(start, end, komma);
        System.out.println();
        System.out.println("=======================");

    }

    public static void printCalculationInt(int start, int end, float komma) {
        for (int i = start; start <= end; start++) {
            System.out.printf("%2d / 5 = \n", start);
            System.out.printf("%2.1f / 5.0 = \n", komma);
           // for (float j = 0; j <= 5; j++) {
                System.out.printf("%2.1f / 5.0 = \n", komma);
            }
           // System.out.printf("%2.1f / 5.0 = \n", komma);
        }
/*
        for (float i = 0; i <= 5; i++) {
            System.out.printf("%2.1f / 5.0 = \n", i);
        }
 */
    }






/*    public static void printCalculationFloat(){
        for (float i = 0; i <= 20 ; i++) {
            System.out.printf("%2.1f / 5.0 = \n", i);
        }
    }
*/




