package Erik.week01;

public class CountWithTrick {
    public static void main(String[] args) {

        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.print(i);
            }
        }

        System.out.println();
        System.out.println("==============================");

        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i);
            if (i < 10) {
                System.out.print(", ");
            }
        }
    }
}
