package Furkan;

public class EmptySquare {
    public static void main(String[] args) {
        printEmptySquare("x ", 10);
    }

    //erste zeile
    public static void printEmptySquare(String text, int count) {
        for (int colm = 0; colm < count; colm++) {
            System.out.print(text);
        }
        System.out.println();

        //Mitllere zeilen
        for (int row=0; row< count -2; row++){
            System.out.print("x ");
            for (int col= 0; col < count -2 ; col++){
                System.out.print(". ");
            }
            System.out.println("x ");
        }


        //letze Zeile
        for (int colm = 0; colm < count; colm++) {
            System.out.print(text);
        }
        System.out.println();
    }

}