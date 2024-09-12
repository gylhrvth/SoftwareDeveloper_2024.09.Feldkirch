package Akif_Malik.week01;

public class PrintX {
    public static void main(String[] args) {
        printX("x ", 5);

    }


    public static void printX(String text, int amount) {
        if (amount % 2 == 0) {
            amount--;
        }
        for (int row = 0; row < amount; row++) {
            for (int column = 0; column < amount; column++) {
                if (row == column || row + column == amount - 1 ) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

}


