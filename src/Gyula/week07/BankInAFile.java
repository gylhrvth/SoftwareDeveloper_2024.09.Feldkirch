package Gyula.week07;

import Gyula.ConsoleTools;

import java.io.*;
import java.util.Scanner;

public class BankInAFile {
    public static void main(String[] args) {
        System.out.println("Hallo in DCV Bank in Feldkirch!");
        String customerName = getNameForAccount();
        int accouunt = readAccountState(customerName);
        accouunt = transaction(accouunt);
        writeAccountState(customerName, accouunt);
    }


    public static String getNameForAccount(){
        return "gyula";
    }

    public static int readAccountState(String name){
        File f = getFileForAccountName(name);
        int result = 100;
        if (f.exists() && f.isFile()){
            try {
                FileInputStream fis = new FileInputStream(f);
                Scanner scanner = new Scanner(fis);
                if (scanner.hasNext()) {
                    String accountValueAsText = scanner.nextLine();
                    result = Integer.parseInt(accountValueAsText);
                }
            } catch (FileNotFoundException fnfe) {
                // Nothing to do...
            }
        } else {
            System.out.printf("Welcome %s! Danke, dass du unser Bank gewählt hast.", name);
        }

        return result;
    }

    public static int transaction(int oldAccountState){
        System.out.printf("Dein aktueller Kontostand %d.\n", oldAccountState);
        int value = ConsoleTools.readNumber("Was für eine Transaktion möchtest du ausführen? >>> ", -10000, 10000);
        int newAccountState = oldAccountState + value;
        System.out.printf("Dein neuer Kontostand ist %d.\n", newAccountState);
        return newAccountState;
    }

    public static void writeAccountState(String name, int newAccountState){
        File fileToWrite = getFileForAccountName(name);

        try {
            FileOutputStream fos = new FileOutputStream(fileToWrite, false);
            PrintStream ps = new PrintStream(fos);
            ps.println(newAccountState);
            ps.close();
            System.out.println("Account has saved...");
        } catch (FileNotFoundException fnfe){
            System.out.println("Cannot save account");
        }
    }

    public static File getFileForAccountName(String name){
        String fileName = "assets/bank/" + name.toLowerCase() + ".txt";
        File f = new File(fileName);
        f.getParentFile().mkdirs();

        return f;
    }
}
