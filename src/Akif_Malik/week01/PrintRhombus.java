package Akif_Malik.week01;

public class PrintRhombus {
    public static void main(String[] args) {
        printRhombus("x ", 7);

    }


    public static void printRhombus(String text, int size) {
        if(size % 2 == 0) {
            size--;
        }for(int row = 0; row < size; row++){
            for(int column = 0; column < size; column++){
                if (row + size /2 == column) {
                    System.out.print(text);
                }else if(column + size / 2 == row) {
                    System.out.print(text);
                }else if(row + column == size / 2) {
                    System.out.print(text);
                }else if(row + column - (size / 2) == size -1) {
                    System.out.print(text);
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
