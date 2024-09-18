package Aylin.week02;

public class CountingPart2 {
    public static void main(String[] args) {
        float number = 0;
        int ende = 54;

        for (number = 0.0f; number <= ende; number+= 0.1f) {
            System.out.printf("Result 1 digit = %-5.1f \n", number);
            System.out.printf("Result 2 digit = %8.2f \n", number);
        }
    }
}
