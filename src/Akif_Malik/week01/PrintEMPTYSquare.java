package Akif_Malik.week01;

public class PrintEMPTYSquare {
    public static void main(String[] args) {
        System.out.println("     ");
        printEmptySquare("x", 10);
        System.out.println("     ");

    }





    public static void printEmptySquare(String text, int count) {
        for (int i = 0; i < 10 ; i++) {
            System.out.print(text);


        }
    }
}
