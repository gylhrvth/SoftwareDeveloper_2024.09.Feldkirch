package Thiemo.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        System.out.println("-----------");
        System.out.println("--Übung 1--");
        System.out.println("-----------");
        printchars("x", 10);
        System.out.println("-----------");
        System.out.println("--Übung 2--");
        System.out.println("-----------");
        printsqaure("x", 10);
        System.out.println("-----------");
        System.out.println("--Übung 3--");
        System.out.println("-----------");
        printrectangle("x", 2, 5);
        System.out.println("--Übung 4--");
        System.out.println("-----------");
        printtriangle("x", 4);
        System.out.println("-----------");
        System.out.println("--Übung 5--");
        System.out.println("-----------");
        printtriangle2("x", 5);

    }

    public static void printchars(String text, int count) {
        for (int i = 0; i <= count; ++i)
            System.out.println(text);

    }

    public static void printsqaure(String text, int count) {
        for (int row = 0; row < count; row++) {
            for (int i = 0; i < count; ++i) {
                System.out.print(text);
            }
            System.out.println();
        }
    }

    public static void printrectangle(String text, int countColumns, int countLines) {
        for (int row = 0; row < countLines; row++) {
            for (int i = 0; i < countColumns; ++i) {
                System.out.print(text);
            }
            System.out.println(text);

        }
    }

    public static void printtriangle(String text, int count) {
        for (int i = 0; i < count; i++) {
            for (int o = 0; o <= i; o++)

                System.out.print(text);
            System.out.println();
        }
    }

    public static void printtriangle2(String text, int count) {
        for (int i = 0; i < count; i++) {
            for (int o = 0; o < count; ++o)

                System.out.print(text);
            System.out.println();
        }
    }
}