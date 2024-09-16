package Aylin.week02;

public class Summe {
    public static void main(String[] args) {
        int a = 20;
        /*int b = a + 1;
        int c = b + 1;
        int sum = a + b;*/


        //printRechnung(a,b,sum);
        System.out.println("Summe von 20 bis 50 addiert");
        System.out.println("------------------------------");
        schleife(a);
    }
    public static void printRechnung(int a, int b, int sum){
        //System.out.println("rechenweg " + a + " + " + b + " = " + sum);
        System.out.printf("rechenweg %-4d + %d = %d \n", a, b, sum);
    }
    public static void schleife(int a){
        int sum = 20;

        for (int i = 21; i <= 50; i++) {
            printRechnung(sum, i, (sum + i));
            sum = sum + i;

            //printRechnung(sum, i, sum);
            //System.out.println(sum);
            //System.out.println(sum + i);
        }
    }
}
