package Furkan.week07;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class FileLesenSchreiben {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Wie lautet dein Name?");

        String name = " ";
        name=scanner.nextLine();

        String dateipfad = ("/assets/bank/"+name+".txt");
        File datei = new File(dateipfad);
        System.out.println(datei);

    }


}
