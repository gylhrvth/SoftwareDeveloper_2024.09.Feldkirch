package Thiemo.week02;

public class PiLeibnitz2 {
    public static void main(String[] args) {
        calcLeibnitz(20);
        calcLeibnitz(2000);
        calcLeibnitz(200000);
    }

    public static void calcLeibnitz(int iteration){
        double result = 0;
        for (int i = 0; i < iteration; i++) {
            if (i % 2 == 0){
                result = result + 4.0 / (2 * i + 1);
            } else {
                result = result - 4.0 / (2 * i + 1);
            }
        }
        System.out.println(result);
    }
}

