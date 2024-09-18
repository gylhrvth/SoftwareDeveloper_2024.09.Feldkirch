package Gyula.week02;

public class Nilakanta {
    public static void main(String[] args) {
        calcNilacanta();
    }

    public static void calcNilacanta(){
        double result = 3.0;
        for (int i = 1; i < 100; i++) {
            double part = 4.0 / ((2 * i) * (2 * i + 1) * (2 * i + 2));
            if (i % 2 == 0){
                result -= part;
            } else {
                result += part;
            }
            System.out.println(result);
        }
    }
}
