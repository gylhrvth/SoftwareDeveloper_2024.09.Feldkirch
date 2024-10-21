package Akif_Malik.week07;

import Gyula.ConsoleTools;

import java.io.*;
import java.util.Scanner;

public class ReadAndWriteBank {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File f = new File("assets/bank/name.txt");
            f.getParentFile().mkdirs();

            FileOutputStream fos = new FileOutputStream(f, true);  // Append mode
            PrintStream ps = new PrintStream(fos);

            System.out.println("Welcome");
            String customerName = getNameForAccount();
            int accouunt = readAccountState(customerName);
            accouunt = transaction(accouunt);
            writeAccountState(customerName, accouunt);

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }


    public static String getNameForAccount() {
        System.out.println("Please enter your name....");
        String userInput = sc.nextLine();
        return "Akif";
    }

    public static int readAccountState(String name) {
        File f = getFileForAccountName(name);
        int result = 100;
        if (f.exists() && f.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                Scanner scanner = new Scanner(fis);
                if (scanner.hasNext()) {
                    String accountValueAsText = scanner.nextLine();
                    result = Integer.parseInt(accountValueAsText);
                }
            } catch (FileNotFoundException e) {

            }
        } else {
            System.out.println("Welcome %s! Danke, dass du unser Bank gewählt hast");
        }
        return result;
    }

    public static int transaction(int oldAccountState) {
        System.out.printf("Dein aktueller Kontostand %d.\n", oldAccountState);
        int value = ConsoleTools.readNumber("Was für eine Transaktion möchtest du ausführen? >>> ", -10000, 10000);
        int newAccountState = oldAccountState + value;
        System.out.printf("Dein neuer Kontostand ist %d.\n", newAccountState);
        return newAccountState;
    }

    public static void writeAccountState(String name, int newAccountState) {
        File fileToWrite = getFileForAccountName(name);
        try {
            FileOutputStream fos = new FileOutputStream(fileToWrite, false);
            PrintStream ps = new PrintStream(fos);
            ps.println(newAccountState);
            ps.close();

            System.out.println("Account has saved...");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static File getFileForAccountName(String name) {
        String fileName = "assets/bank" + name.toLowerCase() + ".txt";
        File f = new File(fileName);
        f.getParentFile().mkdirs();

        return f;
    }
}
