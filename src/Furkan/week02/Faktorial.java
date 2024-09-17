package Furkan.week02;

public class Faktorial {
    public static void main(String[] args) {


        int start = 1;
        int end = 20;


      //  int second = 0;
        long summe = 1;


        for (int i = start; i <= end; i++) {
            start = i;

            summe = start * summe;
            System.out.println(i + "!=" + summe);

        }


    }


}
