package Aylin.week03;

import java.util.Scanner;

public class menu {
    public static void main(String[] args) {
        System.out.println("Welcome to my Assingments. \nWhat would you like to print?" +
                        "1) XmasTree" +
                "2) Square" +
                "3) Rhombus");

        int selectSymbol = number ("Bitte wählen Sie nun: ", 1, 3);
        if(selectSymbol == 1){
            sizeXmasTree();
        }else if(selectSymbol == 2){
            sizeSquare();
        }else if (selectSymbol == 3){
            sizeRhombus();
        }
    }

    public static int sizeXmasTree (int size){
        Scanner sc = new Scanner(System.in);
        System.out.print("Wie Groß soll das XmasTree sein? ");
        int size = sc.nextInt();

        Aylin.week01.PrintChristmastree.printChristmastree(size);
        return size;
    }

    public static int sizeSquare (int size){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie Groß soll der Square sein? ");
        int size = sc.nextInt();

        Aylin.week01.Square.printEmptySquare(size);
        return size;
    }

    public static int sizeRhombus (int size){
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie Groß soll der Rhombus sein? ");
        int size = sc.nextInt();

        Aylin.week01.Rhombus.printRhombus(size);
    }

    public static int number (String text, int firstNumber, int lastNumber){
        int number = 0;
        Scanner sc = new Scanner(System.in);
        return number;
    }
}
