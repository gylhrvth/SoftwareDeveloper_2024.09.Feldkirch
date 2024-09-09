package Aylin.week01;

public class FunctionExample {
    public static void main(String[] args) {
        printChars("x", 10);
    }

    public static void printChars(String text, int count){
        for (int i=0; i< count; ++i){
            System.out.print("x");
        }
        System.out.println();
    }
}
