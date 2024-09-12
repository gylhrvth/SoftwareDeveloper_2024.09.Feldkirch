package Akif_Malik.week01;

public class PrintTriangle4 {
    public static void main(String[] args) {
        printTriangleBottomRight("x ", 5);

    }


    public static void printTriangleBottomRight(String text, int count) {

        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count - row - 1; column++) {
                System.out.print(". ");
            }
            for (int column = 0; column < row + 1; column++) {
                System.out.print(text);
            }

            System.out.println();

        }
    }
}
