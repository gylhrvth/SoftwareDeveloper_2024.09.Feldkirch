package Gyula.week02;

public class Summe {
    public static void main(String[] args) {
        printSumFromTo(20, 50);
    }

    public static void printSumFromTo(int start, int end){
        int summe = 0;
        for (int zahl = start; zahl < end + 1; zahl++) {
            summe += zahl;
            System.out.println(zahl + " " + summe);
        }
    }
}
