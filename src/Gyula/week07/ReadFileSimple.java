package Gyula.week07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileSimple {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("assets/tmp/output.txt");
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()){
                String text = scanner.nextLine();
                System.out.println(text);
            }
            scanner.close();
        } catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
    }
}
