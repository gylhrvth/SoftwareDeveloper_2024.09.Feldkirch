package Akif_Malik.week01;

public class PrintTriangle5 {
    public static void main(String[] args) {
        printTriangle("x ", 3);
    }


        public static void printTriangle(String text, int maxRep) {
            for (int row = 0; row < maxRep ; row++) {
                for (int column = 0; column < row; column++) {
                    System.out.print(". ");
                }
                System.out.println(text);

            }

        }






    }
