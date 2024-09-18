package Gyula.week02;

public class Leibnitz {
    public static void main(String[] args) {
        //calculatePi();
        //calculatePiV2();
        calculatePiV3(0.01);
        calculatePiV3(0.000000001);
    }

    public static void calculatePi(){
        double sum = 0.0;
        for (int i = 1; i < 10000; i += 2) {
            int vorzeichnen = 1;
            if (i % 4 == 3){
                vorzeichnen = -1;
            }
            sum += vorzeichnen * 4.0 / i;
            System.out.println(sum);
        }
        System.out.println(sum);
    }

    public static void calculatePiV2(){
        double sum = 0.0;
        for (int i = 1; i < 100000; i += 4) {
            sum += 4.0 / i;
            sum -= 4.0/(i + 2);
        }
        System.out.println(sum);
    }


    public static void calculatePiV3(double precision){
        double sumMax = 4.0;
        double sumMin = 0.0;
        int i = 1;
        while (sumMax - sumMin > precision) {
            sumMax = sumMin + 4.0 / i;
            sumMin = sumMax - 4.0/(i + 2);
            i += 4;
        }
        System.out.println(sumMax + " " + sumMin);
    }
}
