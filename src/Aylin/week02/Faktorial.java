package Aylin.week02;

public class Faktorial {
    public static void main(String[] args) {
        int i = 1;
        long factorial = 1;
        int count = 20;

        for (i = 1; i <= count; i++) {
            factorial = factorial * i;

            System.out.printf("%2d! = %20d \n", i, factorial);
        }
    }
}
