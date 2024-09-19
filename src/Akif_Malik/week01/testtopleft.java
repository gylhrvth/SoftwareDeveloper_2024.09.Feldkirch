package Akif_Malik.week01;

public class testtopleft {
    public static void main(String[] args) {
        printTriangleTopLeft("x", 5);

    }




    public static void printTriangleTopLeft (String text, int size){
        for (int row = 0; row < size; row++) {
            for (int columns = 0; columns <size-row ; columns++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }
}
