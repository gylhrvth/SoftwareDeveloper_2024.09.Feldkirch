package Erik.week02;

public class Faktorial {
    public static void main(String[] args) {
        int start = 1;
        int end = 20;
        System.out.println();
        System.out.println("=======================Faktorial Start=====================");
        System.out.println();
        calculate(start, end);
        System.out.println();
        System.out.println();
        System.out.println("=======================Faktorial End=======================");
        System.out.println();
        System.out.println("====================Faktorial Bonus Start==================");
        System.out.println();
        //Everything();
        printFaktorialBonus(start, end);
        System.out.println();
        System.out.println("===================Faktorial Bonus End====================");
    }



    public static void calculate(int start, int end) {
        long sum = 1;
        for (int i = start; i <= end; i++) {
            System.out.print(sum * i);
            System.out.print(" ");
            sum = sum * i;
        }
    }

    public static void printFaktorialBonus(int start, int end) {
        long sum = 1;
        for (int i = start; i <= end; i++) {
            sum = sum * i;
            System.out.printf("%2d! ===> %25d \n", +i, +sum);
        }
        //return sum;
    }
}


/*
    public static void calculate(int start, int end) {
        long sum = 1;
        for (int i = start; i <= end; i++) {
            System.out.print(sum * i);
            System.out.print(" ");
            sum = sum * i;

         System.out.print(i + " ");
         System.out.println(i *i);
         sum = i * i;
    }
        public static void Everything(int start, int end) {
        calculate(start, end);
        printFaktorialBonus(start, end);
    }


    public static void printFaktorialBonus(int start, int end) {
        for (int i = start; i <= end; i++) {
          //  System.out.printf("%2d ! \n", +i, + sum);
        }
    }
*/







