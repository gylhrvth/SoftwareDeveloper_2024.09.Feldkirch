package Akif_Malik.week02;

public class Pi_LeibnizReihe {
    public static void main(String[] args) {
        PiCalculator();
        piCalculatorV2();
        piCalculatorV3();
        piCalculatorFromWeb();



    }

    public static void PiCalculator() {
        double sum = 0.0;
        for (int i = 1; i < 100000; i += 4) {
            sum += 4.0 / i;
            sum -= 4.0 / (i + 2);
        }
        System.out.println("Approximate value of pi: " + sum);

    }

    public static void piCalculatorFromWeb() {
        int terms = 1000000; // Number of terms to sum
        double pi = 0.0;
        boolean add = true;

        for (int i = 0; i < terms; i++) {
            if (add) {
                pi += 4.0 / (2 * i + 1);
            } else {
                pi -= 4.0 / (2 * i + 1);
            }
            add = !add;
        }

        System.out.println("Approximate value of π: " + pi);
    }



    public static void piCalculatorV2(){
    /*    double sum = 0.0;
        for (int i = 1; i <100000 ; i+= 2) {
            int vorzeichen = 1;
            if (i % 4 == 3){
                vorzeichen = - 1;
            }
            sum += vorzeichen * 4.0 / i;
            System.out.println("Approximate value of pi: " + sum);

        }*/
    }



    public static void piCalculatorV3(){
       /* double sumMax = 4.0;
        double sumMin = 0.0;
        int i = 1;
        while (sumMax - sumMin > 0.00001) {
            sumMax = sumMin + 4.0 / i;
            sumMin = sumMax - 4.0/ (i + 2);
            i += 4;
        }
        System.out.println(sumMax + " " + sumMin);*/

    }

}
