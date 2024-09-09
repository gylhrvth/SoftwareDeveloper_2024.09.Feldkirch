package Furkan.week01;

public class Zählen {
    public static void main(String[] args) {
        int countLoops = 10;
        System.out.println(countLoops);
        System.out.println("Count loops is " + 10);

        for (int i = 0; i <= 10; ++i) {
            System.out.println(i);
        }
        System.out.println();

        int i = 1;
        while (i <= 10) {
            System.out.println( i);
            ++i;
        }
    }
}
