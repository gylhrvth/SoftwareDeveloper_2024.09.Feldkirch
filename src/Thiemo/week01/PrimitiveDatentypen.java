package Thiemo.week01;

public class PrimitiveDatentypen {
    public static void main(String[] args) {
        System.out.println("-----------");
        System.out.println("---Summe---");
        System.out.println("-----------");
        printsum(21, 50,20);
    }

    public static void printsum(int start, int end, int sum ) {
        for (int i = start; i <= end; i++) {
            int oldsum = sum;
            sum += i;
            System.out.println("Rechenweg: " +oldsum + " + " + i + " = " + sum);



        }

    }
}
