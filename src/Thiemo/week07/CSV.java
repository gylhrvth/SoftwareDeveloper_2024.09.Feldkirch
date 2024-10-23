package Thiemo.week07;

import Sandro.Colors;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class CSV {
    public static final int DATATYPE_String = 3;
    public static final int DATATYPE_INT = 2;
    public static final int DATATYPE_Float = 1;
    public static final int DATATYPE_DATE = 0;

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String file = "csv/sales_100.csv";
        String[][] data = readCSV(file);

        int[] dataTypes = getDataType(data);
        System.out.println(Arrays.toString(dataTypes));

        printFormattedData(data);
    }

    public static int countrow(String file) {
        InputStream inputStream = Objects.requireNonNull(CSV.class.getClassLoader().getResourceAsStream(file));
        Scanner scanner = new Scanner(inputStream);
        int count = 0;

        while (scanner.hasNext()) {
            scanner.nextLine();
            count++;
        }
        return count;
    }

    public static String[][] readCSV(String file) {
        InputStream inputStream = Objects.requireNonNull(CSV.class.getClassLoader().getResourceAsStream(file));
        sc = new Scanner(inputStream);

        int countLines = countrow(file);
        String[][] data = new String[countLines][];

        int rowcount = 0;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            data[rowcount] = line.split(",");
            rowcount++;
        }
        sc.close();
        return data;
    }

    public static void printBorder(int[] maxLength, String start, String middle, String end) {
        for (int j = 0; j < maxLength.length; j++) {
            System.out.printf("%s─%-" + maxLength[j] + "s─", j == 0 ? start : middle, "─".repeat(maxLength[j]));
        }
        System.out.println(end);

    }

    public static void printFormattedData(String[][] data) {
        if (data.length == 0) {
            System.out.println("empty");
            return;
        }
        int[] maxLength = getMaxColumnWith(data);

        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                printBorder(maxLength, "┌", "┬", "┐");
                for (int j = 0; j < data[i].length; j++) { // Headline
                    System.out.printf("│ " + Colors.COLORS[5] + "%-" + maxLength[j] + "s " + Colors.RESET, data[i][j]);
                }
                System.out.println("│");
                for (int j = 0; j < data[i].length; j++) { // Leere Zeile
                    System.out.printf("│ %-" + maxLength[j] + "s ", "");
                }
                System.out.println("│");
                printBorder(maxLength, "├", "┼", "┤");
            } else {
                for (int j = 0; j < data[i].length; j++) {
                    System.out.printf("│ %-" + maxLength[j] + "s ", data[i][j]);
                }
                System.out.println("│");
                if (i < data.length - 1) {
                    printBorder(maxLength, "├", "┼", "┤");
                } else {
                    printBorder(maxLength, "└", "┴", "┘");
                }
            }
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

    public static boolean isThisTextaFloat(String text) {
        boolean isFloat = false;
        try {
            float f = Float.parseFloat(text);
            isFloat = true;
        } catch (NumberFormatException nfe) {
            isFloat = true;
        }


        return isFloat;
    }

    public static int[] getDataType(String[][] table) {
        int[] dataType = new int[table[0].length];
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (dataType[col] == DATATYPE_Float && !isThisTextaFloat(table[row][col])) {
                    dataType[col] = DATATYPE_String;
                }
            }
        }
        return dataType;
    }
}