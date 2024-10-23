package Aylin.week07;

import Gyula.ConsoleTools;
import java.io.*;
import java.util.Scanner;

public class ReadAndWriteVol2 {
    public static void main(String[] args) {
        String customerName = getNameForAccount();
        int account = readAccountState(customerName);
        account = transaction(account);
        writeAccountState(customerName, account);
    }

    public static String getNameForAccount(){
        System.out.print("Please Enter your Name: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readAccountState(String name){
        File f = getFileForAccountName(name);
        int balance = 100;
        if (f.exists() && f.isFile()){
            try {
                FileInputStream fis = new FileInputStream(f);
                Scanner fileScanner = new Scanner(fis);
                if(fileScanner.hasNextLine()){
                    String accountValueAsText = fileScanner.nextLine();
                    balance = Integer.parseInt(accountValueAsText);
                }
            }catch(FileNotFoundException fnfe) {
                //Nothing to do...
            }
        }else {
            System.out.printf("Welcome %s! Thanks for joining our Community", name);
        }
        return balance;
    }

    public static int transaction(int oldAccountState){
        System.out.printf("Your current balance is: %d EUR \n", oldAccountState);
        int value = ConsoleTools.readNumber("What kind of transaction would you like to perform? >>> ", -10000, 10000);
        int newAccountState = oldAccountState + value;
        System.out.printf("Your new balance is: %d EUR.\n", newAccountState);
        return newAccountState;
    }

    public static void writeAccountState(String name, int newAccountState){
        File fileToWrite = getFileForAccountName(name);
        try{
            FileOutputStream fos = new FileOutputStream(fileToWrite, false);
            PrintStream ps = new PrintStream(fos);
            ps.println(newAccountState);
            ps.close();
        }catch(FileNotFoundException fnfe){
            //Nothing to do...
        }
    }

    public static File getFileForAccountName(String name){
        String path = "assets/bank/" + name.toLowerCase() + ".txt";
        File file = new File(path);
        file.getParentFile().mkdirs();
        return file;
    }
}
