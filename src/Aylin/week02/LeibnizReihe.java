package Aylin.week02;

public class LeibnizReihe {
    public static void main(String[] args) {
        printPi(20000);
    }
    public static void printPi(int count){
        double sum = 0;
        for (int i = 0; i < count; i++) {
            if(i % 2 ==0){
                sum = sum + 4.0 / (2 * i + 1);
            }else{
                sum = sum - 4.0 / (2 * i + 1);
            }
        }
        System.out.println(sum);
    }
}
