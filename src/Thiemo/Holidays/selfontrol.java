package Thiemo.Holidays;

public class selfontrol {
    public static void main(String[] args) {
        fori();
        whileloop();
        printSomething("X ", 10);
        whileloopadvanced("X", 3);
    }

    public static void printSomething(String sign, int count) {
        System.out.println(sign.repeat(count));
    }

    public static void fori() {
        for (int i = -30; i < 30; i++) {

            if (i % 3 == 0) {

                System.out.println(i);

            }
        }
    }

    public static void whileloop() {
        int count = 0;
        while (count <= 10) {
            System.out.println(count);
            if (count > 5) {
                System.out.println("\n");
            }
            count++;
        }
    }

    public static void whileloopadvanced(String sign, int count) {
        
    }
}



