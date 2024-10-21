package Akif_Malik.week07.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class FileReadingAndWriting {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            File f = new File("assets/bank/name.txt");
            f.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(f, true);
            PrintStream ps = new PrintStream(fos);

            printBankName(ps);

            printBalance(ps);

            printTransaction(ps);

            ps.println();
            ps.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void printTransaction(PrintStream ps) {
        String userInput = "";
        int userInput2 = 0;
        int currentBalance = 100;

        System.out.println("Make a Transaction Y/N");
        userInput = sc.nextLine();

        if (userInput.equalsIgnoreCase("Y")) {
            System.out.println("Enter the amount to deposit (positive) or withdraw (negative):");

            while (true) {
                try {
                    userInput2 = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer amount:");
                }
            }

            currentBalance += userInput2;

            if (userInput2 > 0) {
                System.out.println("Deposited: " + userInput2);
            } else {
                System.out.println("Withdrew: " + Math.abs(userInput2));
            }

            System.out.println("New Balance = " + currentBalance);  // Print the updated balance
            ps.println("Transaction Amount: " + userInput2);  // Log the transaction amount
            ps.println("New Balance: " + currentBalance);  // Log the new balance
        }
    }

    public static void printBankName(PrintStream ps) {
        String userInput = "x";

        System.out.println("Please enter a name");
        userInput = sc.nextLine();
        ps.println(userInput);
    }

    public static void printBalance(PrintStream ps) {
        int balance = 100;

        System.out.println("Current Account Balance = " + balance + "$");
        ps.println("Current Account Balance: " + balance + "$");
    }
}

