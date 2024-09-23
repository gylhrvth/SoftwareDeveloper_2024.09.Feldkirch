package Aylin.week01;

public class Rhombus {
    public static void main(String[] args) {
        System.out.println("Print Rhombus ");
        System.out.println();
        printRhombus(20);
    }

    public static void printRhombus(int count){
        if(count % 2 == 0) {
            count--;
        }
        for(int row = 0; row < count; row++){
            for(int column = 0; column < count; column++){
                if (row + count /2 == column) {
                    System.out.print("a");
                }else if(column + count / 2 == row) {
                    System.out.print("a");
                }else if(row + column == count / 2) {
                    System.out.print("a");
                }else if(row + column - (count / 2) == count -1) {
                    System.out.print("a");
                }else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
