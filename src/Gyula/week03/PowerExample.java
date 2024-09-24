package Gyula.week03;

public class PowerExample {
    public static void main(String[] args) {
        long l = myPower(5, 2);
        System.out.println("Result: " + l);

        float f = (float) Math.pow(25, 0.5);
        System.out.println("Result: " + f);
    }

    public static long myPower(int base, int power){
        long result = 1;
        for (int i = 0; i < power; i++) {
            result *= base;
        }
        return result;
    }
}
