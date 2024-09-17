package Erik.week02;

public class CountToOneHundred {
    public static void main(String[] args) {
        int first = 0;
        int second = 100; //100
        float start = 0;
        float end = 100; //100
        System.out.println();
        System.out.println("=========Count to One Hundred with Digit's=========");
        System.out.println("Variante 1 (mit int)");
        System.out.println();
        CountToOneHundred(first, second);
        System.out.println();
        System.out.println("Variante 2 (mit float/double)");
        System.out.println();
        CountToOneHundredWithDigits(start, end);
        System.out.println();
        System.out.println("===================================================");
        System.out.println();
        System.out.println("======Count to One Hundred with Digit's Bonus======");
        System.out.println();
        CountToOneHundredBonus(start, end);
        System.out.println();
        System.out.println("===================================================");
    }

    public static void CountToOneHundred(int first, int second) {

        for (int i = first = 0; first <= second; first++) {

            System.out.println(first / 1.0f); // bei Kaufmännischen berechnungen "int" verwenden
        }
    }

    public static void CountToOneHundredWithDigits(float start, float end) {
        for (float i = start; i <= end; i += 0.1f) {    //Bei Physicalischer Rechnungen "float oder double" verwenden
            System.out.printf("%.2f \n", +i);           // %.2f zeigt mir zwei komma stellen an
            // System.out.printf("%.1f \n", + i);       // %.1f zeigt mir eine komma stelle an
            // System.out.printf("%f \n", + i);         // %f komische formatierung nach 2.8.......
            // System.out.println(i);
        }
    }

    public static void CountToOneHundredBonus(float start, float end) {
        for (float i = start; i <= end; i += 0.1f) {
            //System.out.print("Count ");
            System.out.printf("Counting %5.2f \n", +i);
        }
    }

}
