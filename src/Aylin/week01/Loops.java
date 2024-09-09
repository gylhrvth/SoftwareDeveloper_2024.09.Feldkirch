package Aylin.week01;

public class Loops {
    public static void main(String[] args) {
        System.out.println("Aufgabe 1");
        System.out.println();
        System.out.println("1.1");
        for (int i = 0; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("1.2");
        int a = 0;
        while (a <= 10) {
            System.out.print(a + " ");
            ++a;
        }


        System.out.println();
        System.out.println();
        System.out.println("Aufgabe 2");
        for (int l=0; l<10; l++){
            System.out.print(l+" ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Aufgabe 3");
        System.out.println();
        System.out.println("3.1");

        for (int b = 0; b<=10; b++) {
            if (b % 2 ==0){
                System.out.print(b + " ");
            }
        }

        System.out.println();
        System.out.println();
        System.out.println("3.2");
        for(int g=0; g<=10;g+=2) {
            System.out.print(g + " ");
            }


        System.out.println();
        System.out.println();
        System.out.println("Aufgabe 4");
        for (int c=10; c>=-10; c--){
            System.out.print(c+ " ");
        }

    }
}
