package Erik.week02;

public class BonusTaskPiCalculationLeibniz {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("========Calculate Pi=========");
        System.out.println();
        calculatePi();
        System.out.println();
        System.out.println("=============================");
    }

    public static void calculatePi() {
        double pi = 0.0;
        double denominator = 1.0;
        int iteration = 500000; // um Pi auf 5 Dezimalstellen zu generieren brauche ich 500.000 durchläufe

        for (int i = 0; i < iteration; i++) {
            if (i % 2 == 0) {
                pi = pi + 4.0 / denominator;
            } else {

            }
            System.out.println("Pi => " + pi);
        }
    }
}

/*
    public static void main(String[] args) {
        double pi = 0.0;
        double denominator = 1.0;
        int iterations = 1000000; // Anzahl der Iterationen

        for (int i = 0; i < iterations; i++) {
            if (i % 2 == 0) {
                pi += 4.0 / denominator;
            } else {
                pi -= 4.0 / denominator;
            }
            denominator += 2.0;
        }

        System.out.println("Annäherung von Pi: " + pi);
    }
}
 */