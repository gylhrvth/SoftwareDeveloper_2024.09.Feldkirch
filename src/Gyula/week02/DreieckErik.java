package Gyula.week02;

public class DreieckErik {
    public static void main(String[] args) {
        meinDreieck("X", 7);
    }

    public static void meinDreieck(String symbol, int size){
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < row; column++) {
                System.out.print(" ");
            }
            for (int column = 0; column < size - row; column++) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
