package Erik.week07;

import Gyula.week07.ReadFileFromRessources1;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;


public class CSVTabellarischDarstellen {
    public static final int DATATYPE_STRING = 3;
    public static final int DATATYPE_DATE = 0;
    public static final int DATATYPE_INT = 1;
    public static final int DATATYPE_FLOAT = 2;

    public static void main(String[] args) {

        String fileName = "csv/sales_100.csv";
        int row = countRowFromCSV(fileName);

        String[][] csv = readCSVInToMyArray(fileName);
        printCSVTabellarisch(csv);
    }

    public static void printCSVTabellarisch(String[][] csv) {
        int[] formatFloat = getDataType(csv);
        int[] maxColWidth = getMaxColWidth(csv);

        for (int row = 0; row < csv.length; row++) {
            for (int col = 0; col < csv[row].length; col++) {
                String formatColumn = String.format("| %%%s%ds ", formatFloat, maxColWidth[col]);
                System.out.printf(formatColumn, csv[row][col]);
            }
            System.out.println("|");
            if (row == 0) {
                for (int col = 0; col < csv[row].length; col++) {
                    String formatColumn = String.format("|-%%-%ds-", maxColWidth[col]);
                    System.out.printf(formatColumn, "-".repeat(maxColWidth[col]));
                }
                System.out.println("|");
            }
        }
    }

    // Gibt mir die CSV Datei in mein Array
    public static String[][] readCSVInToMyArray(String fileName) {
        int row = countRowFromCSV(fileName);
        String[][] arr = new String[row][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int col = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            arr[col] = line.split(",");
            ++col;
        }
        scanner.close();
        return arr;
    }

    // Zählt die Rows und gibt sie zurück
    public static int countRowFromCSV(String fileName) {
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int row = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ++row;
        }
        scanner.close();
        return row;
    }

    public static int[] getMaxColWidth(String[][] csv) {
        int[] result = new int[csv[0].length];

        for (int row = 0; row < csv.length; row++) {
            for (int col = 0; col < csv[row].length; col++) {
                if (result[col] < csv[row][col].length()) {
                    result[col] = csv[row][col].length();
                }
            }
        }
        return result;
    }

    public static boolean isThisTextAFloat(String text) {
        boolean isFloat = false;
        try {
            Float f = Float.parseFloat(text);
            isFloat = true;
        } catch (NumberFormatException nfe) {

        }
        return isFloat;
    }

    public static int[] getDataType(String[][] csv) {
        int[] dataType = new int[csv[0].length];

        for (int row = 1; row < csv.length; row++) {
            for (int col = 0; col < csv[row].length; col++) {
                if (dataType[col] == DATATYPE_FLOAT && !isThisTextAFloat(csv[row][col])) {
                    dataType[col] = DATATYPE_STRING;
                }
            }

        }

        return dataType;
    }
}