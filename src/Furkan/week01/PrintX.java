package Furkan.week01;

public class PrintX {
    public static void main(String[] args) {
        printX("x", 5);

    }


    public static void printX(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size; col++) {
                if (col == row) {
                    System.out.print(text);
                } else if (row + col == size -1){
                    System.out.print(text);

                }else{
                    System.out.print(".");
                }

            }
            System.out.println();
        }

    }
}
