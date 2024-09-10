package Akif_Malik.week01;

public class OperatorenErklärung {
    public static void main(String[] args) {
        int a = 22;
        int b = 3;

        int c = a + b;
        System.out.println("a + b =" + c);

        c = a - b;
        System.out.println("a - b = " + c);

        c = a * b;
        System.out.println("a * b = " + c);

        c = a / b;
        System.out.println("a / b = " + c);

        c = a % b;
        System.out.println("a % b =" + c);

        ++c;
        System.out.println("++c = " + c);

        --c;
        System.out.println("--c = " + c);

        c += 5; // c = c + 5
        System.out.println("c += 5 =" + c);

        c -= 4; // c = c - 4
        System.out.println("c -= 4 = "+ c);

        c *= 3 ; // c = c * 3
        System.out.println("c *= 3 = " + c);

        c /= 2 ; // c = c / 2
        System.out.println("c /= 2 0 " + c);

        System.out.println("c == 5 " + (c == 5));
        System.out.println("c != 5 " + (c != 5));
        System.out.println("c  < 5 " + (c  < 5));
        System.out.println("c <= 5 " + (c <= 5));
        System.out.println("c  > 5 " + (c  > 5));
        System.out.println("c >= 5 " + (c >= 5));

    }
}
