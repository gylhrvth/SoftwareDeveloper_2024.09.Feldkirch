package Thiemo.week02;

public class Faktorial {

    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        long sum = 1;
        System.out.println("===============================");
        System.out.println("=====      Faktorial      =====");
        System.out.println("===============================");
        faktorial(start, end, sum);
        System.out.println();
        System.out.println("===============================");
        System.out.println("===== Faktorial erweitert =====");
        System.out.println("===============================");
        faktorialerweitert(start, end, sum);
    }


    public static void faktorial(int start, int end, long sum) {
        for (int i = start; i <= end; i++) {
            System.out.print(sum * i + " , ");
            sum = sum * i;

        }
        System.out.println();
    }


    public static void faktorialerweitert(int start, int end, long sum) {
        for (int i = start; i <= end; i++) {
            sum = sum * i;
            System.out.printf("%2d! = %25d \n", i, sum);

        }

    }
}
