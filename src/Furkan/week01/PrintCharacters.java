package Furkan.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        printChars("x", 10);
        System.out.println("-----------------------");
        printSquare("A ", 3);
        System.out.println("------------------------");
        printRect("B ", 10, 3);
        System.out.println("------------------------");
        printTriangleBottomLeft("C", 4);
        System.out.println("------------------------");
        printTriangleTopLeft("C", 5);
        System.out.println("------------------------");
        printTriangleTopRight("D ", 5);
        System.out.println("------------------------");
        printTriangleBottomRight("F ", 5);


    }

    public static void printChars(String text, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(text);
        }
        System.out.println();
    }


    public static void printSquare(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }


    public static void printRect(String text, int countColumns, int countRows) {
        for (int row = 0; row < countRows; row++) {
            for (int column = 0; column < countColumns; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleBottomLeft(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < 1 + row; column++) {
                System.out.print(text);
            }
            System.out.println();
        }

    }

    //hier wird gezählt wie viel zeilen übrig sind, ist eine andere Methode
    public static void printTriangleTopLeft(String text, int count) {
        for (int rowLeft = count; rowLeft >= 1; rowLeft--) {
            for (int column = 0; column < rowLeft; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleTopRight(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < row + 1; column++) {
                System.out.print(". ");
            }
            for (int column = 0; column < count - row; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleBottomRight (String text,int count){
        for (int row=0; row< count; row++){
            for (int column = 0; column < count - row -1; column++){
                System.out.print(". ");
            }
            for (int column = 0; column < row +1; column++){
                System.out.print(text);
            }
            System.out.println();
        }

    }


}


