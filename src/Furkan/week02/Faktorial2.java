package Furkan.week02;

public class Faktorial2 {
    public static void main(String[] args) {
        int start = 0;
        int end = 100;

        countbyTenth(start, end);

    }

        //Aufgabe 1 ohne verschiedene Formatstangen

//    public static void countbyTenth(int start, int end) {
//        for (float i = 0; i <= 100; i += 0.1) {
//            System.out.printf("Result = " + "%.1f%n", i);
//        }

//        for (int j = 0; j<= 100; j+=0.1){
//            System.out.printf("Ergebnis =" + "%.1f%n", j);
//        }
//
//    }

        //Aufgabe 2 mit verschiedene Formatstangen

    public static void countbyTenth(int start, int end) {
        for (float i = 0; i <= end; i += 0.1) {
            System.out.printf("Result 1 digit =" + "%5.1f\n", i);
            System.out.printf("Result 2 digit =" + "%-6.2f\n", i);

        }
    }
}


//public static void countbyTenth(int start, int end){
//    for (float i = 0; i<=100; i +=0.1){
//        System.out.printf("Result = "+"%.1f%n", i);
//    }
//
//}