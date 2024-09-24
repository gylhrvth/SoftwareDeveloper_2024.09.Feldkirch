package Aylin.week03;

//Weihnachtsbaum Furkan und Aylin

public class Weihnachtsbaum {
    public static void main(String[] args) {
        printTree(46);
    }

    public static void printTree(int size) {
        if(size % 2 == 0){
            size--;
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col <= 2 * size - 2; col++) {
                if ((row + col + 1>= size) && (col < size + row)) {
                    System.out.print("*");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }

        for (int kugel = 0; kugel <size; kugel++) {
            System.out.print("O ");
        }
        System.out.println();

        if(size > 2 && size < 5) {
            System.out.print("  +");
        }else if(size < 3 && size > 0) {
            System.out.print("+");
        }else{
            for (int stammHöhe = 0; stammHöhe < size / 4; stammHöhe++) {
                for (int stammBreite = 0; stammBreite < 3 * (size /2) ; stammBreite++) {
                    if (stammBreite > size / 2) {
                        System.out.print("+");
                    } else
                        System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
