package Akif_Malik.week01;

public class PrintTrinangle1 {
    public static void main(String[] args) {
        printTriangleTopLeft("x ",4);
    }


    public static void printTriangleTopLeft(String text, int count){
        for (int row = 0; row <count ; row++) {
            for (int column = 0; column < row + 1; column++) {
                System.out.print(text);
            }
            System.out.println();

        }
    }
}
