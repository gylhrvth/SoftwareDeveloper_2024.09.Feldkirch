package Gyula.week01;

public class TriangleExample {
    public static void main(String[] args) {
        printTriangle("X ", 4);
    }

    public static void printTriangle(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print("A ");
                } else if (col == row + size - 1) {
                    System.out.print("B ");
                } else if (row == size -1){
                        System.out.print("C ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}
