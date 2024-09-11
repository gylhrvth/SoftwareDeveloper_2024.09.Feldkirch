package Furkan.week01;

public class Rewind {
    public static void main(String[] args) {
        int countLoops = 10;

        for (int i = 10; i >= -10; --i) {
            System.out.println(i);
        }

        System.out.println("--------------------------------------------");

        int i = 10;
        while (i >= -10) {
            System.out.println(i);
            --i;
        }
    }
}
