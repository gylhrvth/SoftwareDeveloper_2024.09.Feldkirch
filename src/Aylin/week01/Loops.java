package Aylin.week01;

public class Loops {
    public static void main(String[] args) {
        System.out.println("Aufgabe 1");
        System.out.println();
        System.out.println("1.1");
        int h = 10;
        for (int i = 0; i <= h; i++) {
            if(i<h) {
                System.out.print(i + ", ");
            }
                else{
                    System.out.println(i);
                }
        }

        System.out.println();
        System.out.println("1.2");
        int a = 0;
        int k = 10;
        while (a <= k) {
            if(a<k) {
                System.out.print(a + ", ");
            }
            else{
                System.out.println(a);
            }
            ++a;
        }

        System.out.println();
        System.out.println("Aufgabe 2");
        int p = 9;
        for (int l=0; l<=p; l++){
            if(l<p) {
                System.out.print(l + ", ");
            }
            else{
                System.out.println(l);
            }
        }

        System.out.println();
        System.out.println("Aufgabe 3");
        System.out.println();
        System.out.println("3.1");
        int r = 10;
        for (int b = 0; b<=r; b++) {
            if (b % 2 ==0){
                if(b<r) {
                    System.out.print(b + ", ");
                }
                else{
                    System.out.println(b);
                }
            }
        }

        System.out.println();
        System.out.println("3.2");
        int u= 10;
        for(int g=0; g<=u;g+=2) {
            if(g<r) {
                System.out.print(g + ", ");
            }
            else{
                System.out.println(g);
            }
        }


        System.out.println();
        System.out.println("Aufgabe 4");
        int x = 10;
        int y = -10;
        for (int c=x; c>=y; c--){
            if(c>y) {
                System.out.print(c + ", ");
            }
            else{
                System.out.println(c);
            }
        }
    }
}
