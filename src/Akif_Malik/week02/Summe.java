package Akif_Malik.week02;

public class Summe {
    public static void main(String[] args) {
        int a = 20;

        System.out.println("---------------------------");
        System.out.println("Summe von 20 bis 50 addiert");
        System.out.println("---------------------------");
        addieren(a);
    }

    public static void printRechnung(int a, int b, int sum) {

        System.out.printf("rechenweg %-4d + %d = %d \n", a, b, sum);

    }


    public static void addieren(int a) {
        int sum = 20;
        for (int i = 21; i <= 50; i++) {
            printRechnung(sum, i, (sum + i));
            sum = sum + i;
            System.out.println();
        }
    }
}


