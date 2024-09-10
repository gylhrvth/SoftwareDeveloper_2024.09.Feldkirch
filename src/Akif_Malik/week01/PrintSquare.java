package Akif_Malik.week01;

public class PrintSquare {
    public static void main(String[] args) {
        printSquare("x", 10);
    }




    public static void printSquare(String text, int count){
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                System.out.print(text);
            }
            System.out.println();
        }

    }
}
