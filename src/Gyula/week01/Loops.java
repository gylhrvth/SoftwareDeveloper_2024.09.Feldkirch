package Gyula.week01;

public class Loops {
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


        for (int i = 0; i < 10; ++i){
            System.out.println("Gyula " + i);
        }

        int j = 0;
        while (j < 10){
            System.out.println("Akif " + j);
            ++j;
        }

    }
}
