package Akif_Malik.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class TestingWithChatgpt {
    private static Scanner sc = new Scanner(System.in);
    private static HashMap<String, Integer> userBalances = new HashMap<>();

    public static void main(String[] args) {
        try {
            File f = new File("assets/bank/name.txt");
            f.getParentFile().mkdirs();

            // Load existing balances
            loadBalances(f);

            // Get user name
            System.out.println("Please enter your name:");
            String userName = sc.nextLine().trim();

            // Get the current balance for the user or start with 100
            int currentBalance = userBalances.getOrDefault(userName, 100);

            FileOutputStream fos = new FileOutputStream(f, true);  // Append mode
            PrintStream ps = new PrintStream(fos);

            printBankName(ps, userName);
            printBalance(ps, currentBalance);
            currentBalance = printTransaction(ps, userName, currentBalance);

            // Save the updated balance
            saveBalance(f, userName, currentBalance);

            ps.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    private static void loadBalances(File file) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                String userName = parts[0].trim();
                try {
                    int balance = Integer.parseInt(parts[1].trim()); // Ensure no $ sign is present
                    userBalances.put(userName, balance);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid balance format for user: " + userName);
                }
            }
        }
        fileScanner.close();
    }

    private static void saveBalance(File file, String userName, int balance) throws FileNotFoundException {
        PrintStream ps = new PrintStream(new FileOutputStream(file, true));  // Append mode
        ps.println(userName + ": " + balance); // Save without the $ sign
        ps.close();
    }

    public static int printTransaction(PrintStream ps, String userName, int currentBalance) {
        String userInput = "";
        int userInput2 = 0;

        System.out.println("Make a Transaction Y/N");
        userInput = sc.nextLine().trim();

        if (userInput.equalsIgnoreCase("Y")) {
            System.out.println("Enter the amount to deposit (positive) or withdraw (negative):");

            while (true) {
                String input = sc.nextLine().trim();  // Read input and trim
                System.out.println("User input: " + input);  // Debugging line

                try {
                    userInput2 = Integer.parseInt(input);  // Try to parse the input
                    break;  // Exit the loop if parsing is successful
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

            System.out.println("New Balance = " + currentBalance);
            ps.println("Transaction on " + java.time.LocalDateTime.now() + ": " + userInput2);
            ps.println("New Balance for " + userName + ": " + currentBalance);
        }
        return currentBalance;  // Return the updated balance
    }

    public static void printBankName(PrintStream ps, String userName) {
        System.out.println("Welcome, " + userName + "!");
        ps.println("Bank Name: " + userName);  // Use the user's name
    }

    public static void printBalance(PrintStream ps, int balance) {
        System.out.println("Current Account Balance = " + balance + "$"); // Display with $ for user
        ps.println("Current Account Balance: " + balance); // Save without the $ sign
    }
}

