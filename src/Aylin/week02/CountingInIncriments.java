package Aylin.week02;

public class CountingInIncriments {
    public static void main(String[] args) {
        float start = 0;
        int ende = 100;
        float komma = 0.1f;

        for (start = komma; start <= ende ; start+= komma) {
            System.out.printf("%-2.1f \n", start);
        }
        System.out.println();
        System.out.println("mit Double");

        double begin = 0;
        int end = 100;
        double decimal = 0.1f;

        for (begin = decimal; begin <= end ; begin+= decimal) {
            System.out.printf("%-1.1f \n", begin);
        }
    }
}
