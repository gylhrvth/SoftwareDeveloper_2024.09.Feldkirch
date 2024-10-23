package Aylin.week07;

import Gyula.WildColors;
import Gyula.week07.ReadFileFromRessources1;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class ReadAndPrintFile {
    public static void main(String[] args) {
        String fileName = "csv/sales_100.csv";
        String[][] table = readCSVintoTable(fileName);
        printTable(table);
    }

    public static int countLineOfFile(String fileName) {
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        scanner.close();
        return count;
    }

    public static String[][] readCSVintoTable(String fileName) {
        int countLines = countLineOfFile(fileName);
        String[][] table = new String[countLines][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int row = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            table[row] = line.split(",");
            row++;
        }
        scanner.close();
        return table;
    }


    public static void printTable(String[][] table) {
        if (table.length == 0) return;

        int columnCount = table[0].length;
        int[] maxLengths = getMaxTotalLength(table);

        for (int i = 0; i < columnCount; i++) {
            System.out.printf("| %-"+maxLengths[i]+"s ", table[0][i]);
        }
        System.out.println("|");
        printSeparator(maxLengths);

        for (int i = 1; i < table.length; i++) {
            String[] row = table[i];
            for (int j = 0; j < columnCount; j++) {
                System.out.printf("| %-"+maxLengths[j]+"s ", row[j]);
            }
            System.out.println("|");
        }
        printSeparator(maxLengths);
    }

    public static int[] getMaxTotalLength(String[][] table) {
        int columnCount = table[0].length;
        int[] maxLengths = new int[columnCount];

        for (int i = 0; i < columnCount; i++) {
            maxLengths[i] = table[0][i].length();
            for (int j = 1; j < table.length; j++) {
                maxLengths[i] = Math.max(maxLengths[i], table[j][i].length());
            }
            maxLengths[i] += 2;
        }
        return maxLengths;
    }

    public static void printSeparator(int[] maxLengths) {
        for (int length : maxLengths) {
            System.out.print("---");
            System.out.print("-".repeat(length));
        }
        System.out.println("-");
    }
}
