package Aylin.week01;

public class FunctionExample {
    public static void main(String[] args) {
        printChars("x", 10);
        System.out.println();
        System.out.println("=============== Square");
        System.out.println();
        printSquare("x", 10);
        System.out.println();
        System.out.println("=============== Rectangle");
        System.out.println();
        printRectangle("x", 10, 3);
        System.out.println();
        System.out.println("=============== Triangle");
        System.out.println();
        printTriangleBottomLeft("A ", 4);
        System.out.println();
        System.out.println("=============== Triangle (2)");
        System.out.println();
        printTriangleTopLeft("B ", 5);
        System.out.println();
        System.out.println("=============== Triangle (3)");
        System.out.println();
        printTriangleTopRight("X ", 5);
        System.out.println();
        System.out.println("=============== Triangle (4)");
        System.out.println();
        printTriangleBottomRight("Y ", 5);
    }

    public static void printChars(String text, int count) {
        for (int i = 0; i < count; ++i) {
            System.out.print(text);
        }
    }


    public static void printSquare(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int column = 0; column < count; column++) {
                System.out.print(text);
            }
            System.out.println();
        }
    }


    public static void printRectangle(String text, int count, int row) {
        for (int j = 0; j < row; j++) {
            for (int k = 0; k < count; k++) {
                System.out.print(text);
            }
            System.out.println();
        }

    }


    public static void printTriangleBottomLeft(String text, int count) {
        for (int k=0; k<count; k++){
            for (int l= 0; l<k + 1; l++){
                System.out.print(text);
            }
            System.out.println();
        }
    }



    public static void printTriangleTopLeft(String text, int count){
        for (int row = 0; row < count; row++){
            for (int column = 0; column < count-row; column++){
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleTopRight(String text, int count){
        for (int row = 0; row < count; row++){
            for(int s = 0; s < row; s++) {
                System.out.print(". ");
            }
            for (int column = 0; column < count-row; column++){
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printTriangleBottomRight (String text, int count){
        for (int zeile = 0; zeile < count; zeile++){
            for(int p = 0; p < count - zeile - 1; p++) {
                System.out.print(". ");
            }
            for (int y = 0; y <= zeile; y++){
                System.out.print(text);
            }
            System.out.println();
        }
    }
}