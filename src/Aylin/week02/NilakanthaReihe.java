package Aylin.week02;

public class NilakanthaReihe {
    public static void main(String[] args) {
        nilakanthaReihe(1000);
    }

    public static void nilakanthaReihe(int count){
        double sum = 3.0;
        for (int i = 1; i < count; i++) {
            double part = 4.0 / ((2 * i) * (2 * i + 1) * (2 * i + 2));
            if(i % 2 == 0){
                sum -= part;
            }else{
                sum += part;
            }
        }
        System.out.println(sum);
    }
}
