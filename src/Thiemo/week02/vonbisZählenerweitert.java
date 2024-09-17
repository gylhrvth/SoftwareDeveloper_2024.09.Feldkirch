package Thiemo.week02;

public class vonbisZählenerweitert {
    public static void main(String[] args) {
        float start = 0;
        float ende = 100.0f;
        float increment = 0.1f;

        for (start = increment; start <= ende ; start+= increment) {
            System.out.printf("%5.1f \n", start);
        }
        System.out.println();
        System.out.println("2. Variante");

        for (int sum = 0; sum <= 1000; sum++) {
            System.out.println(sum / 10.0f);
        }
    }
}


