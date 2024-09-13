package Akif_Malik.week01;

public class ChristmasTree {
    public static void main(String[] args) {
        printChristmasTree("* ", 9);

    }

    public static void printChristmasTree(String text, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < 2 * size - 1; col++) {
                if (row + col == size - 1) {
                    System.out.print(text);
                } else if (col == row + size - 1) {
                    System.out.print(text);
                } else if (row == size - 1) {
                    System.out.print(text);
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        for (int leaves = 0; leaves < size; leaves++) {
            System.out.print("O   ");
            ;

        }

        for (int trunk = 0;trunk  < size/2; trunk++) {
            System.out.printf("%13d ++++ \n", size);


        }


    }


}
