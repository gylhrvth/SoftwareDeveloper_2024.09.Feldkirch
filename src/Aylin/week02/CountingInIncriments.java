package Aylin.week02;

public class CountingInIncriments {
    public static void main(String[] args) {
        float start = 0;
        int ende = 100;
        float komma = 0.1f;

        for (start = 0.1f; start <= ende ; start+= 0.1f) {
            System.out.printf("%-2.1f \n", start);
        }
        System.out.println();
        System.out.println("mit Double");

        double begin = 0;
        int end = 100;

        for (begin = 0.1; begin <= end ; begin+= 0.1) {
            System.out.printf("%1.1f \n", begin);
        }
    }
}
