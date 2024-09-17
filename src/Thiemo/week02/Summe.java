package Thiemo.week02;

public class Summe {
    public static void main(String[] args) {
        System.out.println("===========================");
        System.out.println("Summe von 20 bis 50 addiert");
        System.out.println("===========================");

        printsumfromto(21,50);
    }

    public static void printsumfromto(int start, int end) {
        int sum = 20;
        for (int zahl = start;  zahl < end ; zahl++) {
            int oldsum = sum;
            sum += zahl;
            System.out.println("Rechenweg: " +oldsum + " + " + zahl + " = " + sum);

        }
    }

}