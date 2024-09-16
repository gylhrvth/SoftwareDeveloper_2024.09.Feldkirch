package Erik.week02;

public class Summe {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        System.out.println("Summe von 20 bis 50 addiert");
        System.out.println("---------------------------------");

        int start = 20;
        int start1 = 21;
        int end = 50;
        int sum = add(start, start1);
        add(start, start1);

       doEverything(start,start1, end, sum);

        //printRechnung(start, start1, end, sum);
        //printRechnen(start, start1, end, sum);
        // printRechnung(start, start1, end, sum);

    }

    public static void doEverything(int start,int start1, int end, int sum) {
        sum = add (start,start1);
        printRechnen(start, start1, end, sum);

    }


    public static int add(int start, int start1) {
        int sum = 0;
        sum = start + start1;

        return sum;
    }

    public static void printRechnen(int start, int start1, int end, int sum) { //sum 41
        //System.out.println("Rechenweg : " + start + " + " + start1 + " = " + sum);
        //System.out.println("Rechenweg : " + sum + " + " + start + " = "  );
        for (int i = start; i <= end; i++) {
            System.out.print("Rechenweg : " + sum + " + " + i + " = " );
            sum += i;
            System.out.print(sum);
            System.out.println();
        }
    }

}
   /* public static int printRechnung (int start, int start1, int end, int sum){

        for (int i = 21; i <= end ; i++) {
            System.out.println("Rechenweg : " + sum + " + " + i + " = " );
            sum += i;
            return i;
        }

        return i;
    }
}

   /* public static void printRechnung(int start, int start1, int end, int sum) {
        //System.out.println("Rechenweg : " + start + " + " + 21 + " = " + sum);
        for (int i = 0; i <= end; i++) {
            sum += i;
            System.out.println("Rechenweg : " + start + " + " + start1 + " = " + sum);
        }

    }

    public static int Rechnen(int start, int ende) {


    }
*/



