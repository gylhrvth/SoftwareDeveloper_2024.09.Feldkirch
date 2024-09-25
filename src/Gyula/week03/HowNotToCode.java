package Gyula.week03;

public class HowNotToCode {
    public static void main(String[] args) {
        int a = -2;

        System.out.println(a++);
        System.out.println(++a);
        System.out.println(5/a);
        System.out.println(a *= 3);
        System.out.println(a);

        int b = 3;
        System.out.println(b);
        b = a++;
        System.out.println(b);
        b = 3 + 2 * ++a;
        System.out.println(b);

        int y = 5;
        int x = y + 3;
        x *= 2;
        System.out.println(x);


        for (int i = 0; i < 5; i++) {
            System.out.print("A");
        }
        System.out.println();
    }
}
