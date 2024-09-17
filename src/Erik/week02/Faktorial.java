package Erik.week02;

public class Faktorial {
    public static void main(String[] args) {
        System.out.println();
        System.out.println("========Faktorial===========");
        System.out.println();

        int start = 1;
        int end = 20;//20

        calculate(start, end);

        System.out.println();
        System.out.println();
        System.out.println("========Faktorial Bonus===========");
        System.out.println();
        printFaktorialBonus(start, end);
    }

    public static void Everything() {
       // calculate(start, end);
    }


   public static void printFaktorialBonus(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.printf("%2d ! \n", + i);
        }
    }


    public static void calculate(int start, int end) {
        long sum = 1;
        for (int i = start; i <= end; i++) {
            System.out.print(sum * i);
            System.out.print(" ");
            sum = sum * i;
        }
        //return sum;
    }
}


    /*
         System.out.print(i + " ");
         System.out.println(i *i);
         sum = i * i;
    }
    */






