package Thiemo.week07;

import Thiemo.ConsoleInput;

import java.io.*;
import java.util.Scanner;

public class WriteandReadFile2 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello");
        String customer = getNameforAccount();
        int account = readAccountState(customer);
        account = transaction(account);
        writeAccountState(customer, account);


    }

    public static String getNameforAccount() {
        System.out.println("Please enter your Name");
        String userinput = sc.nextLine();

        return userinput;
    }

    public static int readAccountState(String name) {
        File file = getFileforAccount(name);
        int result = 10000;

        if (file.exists() && file.isFile()) {
            try {
                FileInputStream fis = new FileInputStream(file);
                Scanner scanner = new Scanner(fis);

                while (scanner.hasNext()) {
                    String text = scanner.nextLine();
//                    System.out.println(text);
//                    result = Float.parseFloat(text);
                    result = Integer.parseInt(text);
                }
                scanner.close();
            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());

            }
        }
        return result;
    }


    public static int transaction(int oldAccountState) {
        System.out.printf("Dein aktueller Kontostand %.2f€\n", oldAccountState / 100f);
        float floatValue = ConsoleInput.readNumberfloat("Was für eine Transaktion möchtest du ausführen? >>> ", -10000, 10000);
        int value = Math.round(100 * floatValue);
        int newAccountState = oldAccountState + value;
        System.out.printf("Dein neuer Kontostand ist %.2f€\n", newAccountState / 100f);

        Logging2.log(Logging2.INFO, "Transaction " + String.format("%.2f€", floatValue) + " " + ((floatValue < 0)?"AUSGABE":"EINNAHME"));
        return newAccountState;
    }

    public static void writeAccountState(String name, int newAccountState) {
        File fileToWrite = getFileforAccount(name);

        try {
            FileOutputStream fos = new FileOutputStream(fileToWrite, true);
            PrintStream ps = new PrintStream(fos);
            ps.println(newAccountState);
            Logging2.log(3,"Kontobenutzer "+name+" hat Transaktion durchgeführt");
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Cannot save account");
        }


    }

    public static File getFileforAccount(String name) {
        String fileName = "assets/Bank/" + name.toLowerCase() + ".txt";
        File file = new File(fileName);
        file.getParentFile().mkdirs();

        return file;
    }
}
