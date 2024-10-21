package Thiemo.week07;

import Gyula.week07.ReadFileFromRessources1;
import Thiemo.ConsoleInput;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class WriteandReadFile {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter your name:");
        String name = sc.nextLine();
        int balance = 100;
        char currency = '€';
        File file = new File("assets/Bank/" + name + ".txt");
        if (file.isFile()) {
            InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream("assets/Bank/" + name + ".txt"));
            Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();

        } else {
            System.out.print("Your Balance is: " + balance + currency);
        }

        int transaktion = ConsoleInput.readNumber("\nwant to add or subtract?", -1000000, 1000000);
        int sum = 0;
        sum = balance + transaktion;


        System.out.print(sum);
        System.out.println(currency);
//        File file2 = new File("assets/Bank/" + name + ".txt");
//        file2.getParentFile().mkdirs();

    }
}
