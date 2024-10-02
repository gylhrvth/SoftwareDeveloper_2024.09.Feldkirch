package Gyula.week04;

public class FaktorialRekursiv {
    public static void main(String[] args) {
        System.out.println("10! = " + factorialRecursive(10));
    }

    public static long factorialRecursive(int n){
        if (n == 0) {
            return 1;
        } else {
            return factorialRecursive(n - 1) * n;
        }
    }
}
