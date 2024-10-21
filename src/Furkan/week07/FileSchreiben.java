package Furkan.week07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileSchreiben {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("C:/Users/dcv/IdeaProjects/SoftwareDeveloper_2024.09.Feldkirch/src/Furkan/week07/output.txt", true);
            PrintStream ps = new PrintStream(fos);
            printInput(ps);
            ps.close();


        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }


    }

    public static void printInput(PrintStream ps) {
        System.out.println("Text eingeben:");

        String userInput = " ";
        while (!userInput.isEmpty()) {
            userInput = scanner.nextLine();
            ps.println(userInput);


        }


    }
}
