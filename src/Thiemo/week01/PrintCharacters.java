package Thiemo.week01;

public class PrintCharacters {
    public static void main(String[] args) {
        System.out.println("--Übung 1--");
        printchars("x", 10);
        System.out.println("-----------");}

    public static void printchars(String text, int count) {
        for (int i = 0; i <= count; ++i)
            System.out.println(text);
    }

}


