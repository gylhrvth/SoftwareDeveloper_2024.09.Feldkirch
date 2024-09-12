package Akif_Malik.week01;

public class PrintTriangle2 {
    public static void main(String[] args) {
        printTriangleTopLeft("x ", 5);

    }



    public static void printTriangleTopLeft(String text, int count){
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count - row; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}
