package Furkan.week01;

public class PrintRhombus {
    public static void main(String[] args) {
        printRhombus("x", 20);
    }


    public static void printRhombus(String text, int size) {
        for (int row = 0; row < 2* size-1  ; row++) {
            for (int col = 0; col < 2 * size-1 ; col++) {
                if (row + col == size-1) {
                    System.out.print("A");
                } else if (col == row + size -1) {
                    System.out.print("B");
                } else if (row + col ==3* (size -1) ){
                    System.out.print("C");
                }else if (col == row -(size-1) ){
                    System.out.print("D");
                }







                else {
                    System.out.print(".");
                }
            }


            System.out.println();


        }

    }
}
