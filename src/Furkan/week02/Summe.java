package Furkan.week02;

public class Summe {
    public static void main(String[] args) {


//        int a = 20;
//        int b = a + 1;
//        int c = a + b + 1;

        // System.out.println(addieren(a, b));

        // doEverything(a, b, c);

        int start = 21;
        int end = 50;


        int first = 20;
        int second = 0;
        int summe = 0;

        for (int i = start; i <= end; i++) {
            second = i;

            summe = first + second;
            System.out.println("rechenweg " + first + "+" + second + "=" + summe);
            first = summe;


        }

    }
//
//    public static void doEverything(int a, int b, int c) {
//        int sum = 0;
//        printRechenweg(a, b, sum);
//        sum = addieren(a, b);
//        summeAddieren(a, b, c);
//    }
//
//    public static void printRechenweg(int a, int b, int sum) {
//        System.out.println("Rechenweg :" + a + "+" + b);
//
//    }
//
//    public static int addieren(int a, int b) {
//        int sum = 0;
//        sum = a + b;
//
//        return sum;
//
//
//    }
//
//    public static void summeAddieren(int a, int b, int c) {
//        int sum = 0;
//        sum = c + b;
//
//        System.out.println(sum);
//
//    }


}
//System.out.println("test " + first + " + " + second + " = " +summe);


