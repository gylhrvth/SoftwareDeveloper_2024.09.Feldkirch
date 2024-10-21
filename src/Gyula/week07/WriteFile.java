package Gyula.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class WriteFile {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File f = new File("assets/tmp/output.txt");
            f.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintStream ps = new PrintStream(fos);

            writeTextFromConsole(ps);

            ps.close();
        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
    }

    public static void writeTextFromConsole(PrintStream ps){
        System.out.println("Bitte den Text eingeben!");

        String text = "X";
        while (!text.isEmpty()){
            text = scanner.nextLine();
            ps.println(text);
        }
    }
}
