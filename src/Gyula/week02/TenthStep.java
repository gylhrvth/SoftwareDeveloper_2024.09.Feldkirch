package Gyula.week02;

public class TenthStep {
    public static void main(String[] args) {
        float f = 0.0f;

        for (int i = 0; i < 20; i++) {
            f += 0.1f;
            System.out.println(f);
        }


        int sum = 0; // sum ist in 0.1 Einheit
        for (int i = 0; i < 20; i++) {
            sum += 1;
            System.out.println(sum / 10.0f);
        }
    }
}
