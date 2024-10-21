package Akif_Malik.week07.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileWriting {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File f = new File("assets/tmp/output.txt.");
            f.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(f, false);
            PrintStream ps = new PrintStream(fos);

            printUserOutput(ps);

            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void printUserOutput(PrintStream ps) {
        String userInput = "initialized";
        System.out.println("Give me a word to save...");
        System.out.println("note: press enter to stop the program");

        while (!userInput.equals("")) {
            userInput = sc.nextLine();
            ps.println(userInput);
        }
    }
}

