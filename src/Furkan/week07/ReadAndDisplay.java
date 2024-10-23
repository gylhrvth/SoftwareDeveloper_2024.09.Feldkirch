package Furkan.week07;

import Gyula.week07.ReadFileFromRessources1;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ReadAndDisplay {
    public static void main(String[] args) {
        String[][] table = readCSVintgTable();
        printTable(table);
    }

    public static String[][] readCSVintgTable() {
        int countlines = countLineOffFile();
        String[][] table = new String[countlines][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream("csv/sales_100.csv"));
        Scanner scanner = new Scanner(inputStream);

        int row = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            table[row] = line.split(",");
            ++row;
        }
        scanner.close();
        return table;
    }


    public static int countLineOffFile() {
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream("csv/sales_100.csv"));
        Scanner scanner = new Scanner(inputStream);

        int count = 0;
        while (scanner.hasNext()) {
            scanner.nextLine();
            ++count;
        }
        scanner.close();
        return count;
    }

    public static void printTable(String[][] tabelle) {
        int[] maxWidth = getMaxColumnWith(tabelle);

        for (int row = 0; row < tabelle.length; row++) {
            for (int col = 0; col < tabelle[row].length; col++) {
                String formatString = String.format("| %%-%ds ", maxWidth[col]); // "| %-" + maxWidth[col] + "s ";
                System.out.printf(formatString, tabelle[row][col]);
            }
            System.out.println("|");
        }
    }

    public static int[] getMaxColumnWith(String[][] table) {
        int[] result = new int[table[0].length];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (result[col] < table[row][col].length()) {
                    result[col] = table[row][col].length();
                }
            }
        }
        return result;


    }


}
