package Gyula.week02;

public class FensterThiemo {
    public static void main(String[] args) {
        printEmptySquare("X", 10);
    }

    public static void printEmptySquare(String text, int size){
        for (int column = 0; column < size; column++) {
            System.out.print(text);
        }
        System.out.println();

        for (int row = 0; row < size - 2; row++) {
            System.out.print(text);
            for (int column = 0; column < size - 2; column++) {
                System.out.print(" ");
            }
            System.out.println(text);
        }

        for (int column = 0; column < size; column++) {
            System.out.print(text);
        }
        System.out.println();
    }
}
