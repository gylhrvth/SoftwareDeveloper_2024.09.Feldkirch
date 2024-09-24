package Thiemo.week01;

public class emptysquare {

    public static void main(String[] args) {

        System.out.println("-----------");
        System.out.println("--Übung 8--");
        System.out.println("-----------");
        EmptySquareX("T ", 10);
        System.out.println("-----------");
        System.out.println("--Übung 9--");
        System.out.println("-----------");
        EmptySquareA("A ", 3);
    }


    //Übung 8 (text: x count: 10)
    public static void EmptySquareX(String text, int count) {
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
        for (int row = 2; row < count; row++) {
            System.out.print(text);
            for (int spacebar = 2; spacebar < count; ++spacebar) {
                System.out.print(".");
            }
            System.out.println(text);
        }
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
    }


    //Übung 9 (text: x count: 10)
    public static void EmptySquareA(String text, int count) {
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
        for (int row = 2; row < count; row++) {
            System.out.print(text);
            for (int spacebar = 2; spacebar < count; ++spacebar) {
                System.out.print(". ");
            }
            System.out.println(text);
        }
        for (int columns = 0; columns < count; ++columns) {
            System.out.print(text);
        }
        System.out.println();
        {
        }
    }
}