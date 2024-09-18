package Thiemo.week02;

public class vonbisZählenerweitert {
    public static void main(String[] args) {
        float start = 0;
        float ende = 100.0f;
        float erweitern = 0.1f;

        for (start = 0 ; start <= ende ; start+= erweitern) {
            System.out.printf("%5.1f \n", start);
        }
        System.out.println();
        System.out.println("2. Variante");

        for (int start2 = 0; start2 <= 1000; start2++) {
            System.out.println(start2 / 10.0f);
        }
    }
}


