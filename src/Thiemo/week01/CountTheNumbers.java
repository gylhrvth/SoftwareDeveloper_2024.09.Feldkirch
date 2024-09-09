package Thiemo.week01;

public class CountTheNumbers {
    public static void main(String[] args) {

        int countLoops = 5;
        System.out.println(countLoops);
        System.out.println("Count loops is " + countLoops);

        countLoops = 7;
        System.out.println("Count loops is " + countLoops);

        countLoops = countLoops + 1;
        System.out.println("Count loops is " + countLoops);
        ++countLoops;
        System.out.println("Count loops is " + countLoops);

        System.out.println("");
        System.out.println("Übung1");
        System.out.println("");
        for (int i = 1; i < 10; ++i) {

            System.out.println("Yeah" + i);
        }
        System.out.println("");
        System.out.println("Übung2");
        System.out.println("");
        int h = 0;
        while (h <= 10) {
            System.out.println(h);
            ++h;
        }
        System.out.println("");
        System.out.println("Übung 3");
        System.out.println("");
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            } else {
                System.out.println("Hello");
            }
        }
        System.out.println("");
        System.out.println("Übung 4");
        System.out.println("");
        for (int u = -10; u <= 10; u++) {

            System.out.println(u);
        }
    }
}
