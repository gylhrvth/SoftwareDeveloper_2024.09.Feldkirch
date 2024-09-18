package Gyula.week02;

public class CirclePythagoras {
    public static void main(String[] args) {
        printCirclePythagoras(30);
    }

    public static void printCirclePythagoras(int size){
        double factorXY = 2.6;
        for (int row = -size+1; row < size; row++) {
            for (double col = -factorXY*size+1; col < factorXY*size; col++) {
                if (row * row + (col/factorXY) * (col/factorXY) < size * size){
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
