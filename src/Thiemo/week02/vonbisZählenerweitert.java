package Thiemo.week02;

public class vonbisZählenerweitert {
    public static void main(String[] args) {
        float start = 0;
        float ende = 100.0f;
        float komma = 0.1f;

        for (start = komma; start <= ende ; start+= komma) {
            System.out.printf("%-2.1f \n", start);
        }
        System.out.println();
        System.out.println("2. Variante");

        for (int sum = 0; sum <= 1000; sum++) {
            System.out.println(sum / 10.0f);
        }
    }
}

}
