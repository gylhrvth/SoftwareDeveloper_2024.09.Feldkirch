package Akif_Malik.week07.tests;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;

public class FileExamplesFromGyula {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Akif_Malik\\week07\\FileExamplesFromGyula.txt", true);
            PrintStream ps = new PrintStream(fos);

            printHello(ps);

            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void printHello(PrintStream ps) {
        ps.printf("%1$tY.%1$tm.%1$te. %1$tH:%1$tM:%1$tS \n", new GregorianCalendar().getTime());
        ps.println("Hello World!");
    }
}
