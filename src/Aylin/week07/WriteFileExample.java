package Aylin.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class WriteFileExample {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try{
            File f = new File("assets/tmp/output.txt");
            f.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(f , false);
            PrintStream ps = new PrintStream(fos);

            printAnything(ps);
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void printAnything(PrintStream ps){
//        ps.println("Good Morning");
//        ps.printf("Today's Date: %1$te.%1$tm.%1$tY - %1$tH:%1$tM:%1$tS \n", new GregorianCalendar().getTime());
        System.out.println("Please enter your text: ");

        String text = "X";

        while(!text.isEmpty()){
            text = sc.nextLine();
            ps.println(text);
        }
    }
}
