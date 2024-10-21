package Aylin.week07;

import Gyula.ConsoleTools;
import Sandro.Colors;

import java.io.*;
import java.util.Scanner;

public class ReadAndWriteFile{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        String name = sc.nextLine();
        String path = "assets/bank/" + name + ".txt";
        File file = new File(path);
        int initialBalance = 100;

        if(!file.exists()){
            try{
                file.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(file);
                PrintStream ps = new PrintStream(fos);
                System.out.println("New account created for " + name + " with an initial balance of " + transaction(initialBalance) + " EUR.");
                ps.close();
            }catch(FileNotFoundException fnfe){
                System.out.println(fnfe.getMessage());
            }
        }else{
            try(Scanner fileScanner = new Scanner(file)){
                if(fileScanner.hasNextLine()){
                    transaction(initialBalance);
                }
            }catch(FileNotFoundException fnfe){
                System.out.println(fnfe.getMessage());
            }
        }
        sc.close();
    }

    public static int transaction(int oldAccountState){
        int value = ConsoleTools.readNumber("What kind of transaction would you like to perform? >>> ", -10000, 10000);
        int newAccountState = oldAccountState + value;
        System.out.printf("Your new balance is: %d EUR.\n", newAccountState);
        return newAccountState;
    }
}