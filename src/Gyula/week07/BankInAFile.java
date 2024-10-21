package Gyula.week07;

import Gyula.ConsoleTools;

import java.io.File;

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
        return 100;
    }

    public static int transaction(int oldAccountState){
        System.out.printf("Dein aktueller Kontostand %d.\n", oldAccountState);
        int value = ConsoleTools.readNumber("Was für eine Transaktion möchtest du ausführen? >>> ", -10000, 10000);
        int newAccountState = oldAccountState + value;
        System.out.printf("Dein neuer Kontostand ist %d.\n", newAccountState);
        return newAccountState;
    }

    public static void writeAccountState(String name, int newAccountState){
        System.out.println("Account has saved...");
    }

    public static File getFileForAccountName(String name){
        return null;
    }
}
