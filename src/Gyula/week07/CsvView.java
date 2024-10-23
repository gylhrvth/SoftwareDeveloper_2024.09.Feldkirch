package Gyula.week07;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class CsvView {
    public static final int DATATYPE_DATE = 0;
    public static final int DATATYPE_INT = 1;
    public static final int DATATYPE_FLOAT = 2;
    public static final int DATATYPE_STRING = 3;

    public static SimpleDateFormat sdfOriginal = new SimpleDateFormat("M/d/yyyy");
    public static SimpleDateFormat sdfConverted = new SimpleDateFormat("yyyy.MM.dd");


    public static void main(String[] args) {
        String fileName = "csv/sales_100.csv";


        String[][] table = readCSVintoTable(fileName, ",");
        int[] dataTypes = getDataType(table);
        System.out.println(Arrays.toString(dataTypes));

        String[][] convertedTable = convertDate(table, dataTypes);
        printTable(convertedTable, dataTypes);
    }


    public static String[][] convertDate(String [][] original, int[] dataTypes){
        String[][] result = new String[original.length][];
        for (int row = 0; row < original.length; row++) {
            result[row] = new String[original[row].length];
            for (int col = 0; col < original[row].length; col++) {
                if (row > 0 && dataTypes[col] == DATATYPE_DATE){
                    try {
                        Date date = sdfOriginal.parse(original[row][col]);
                        result[row][col] = sdfConverted.format(date);
                    } catch (ParseException pe){
                        // Nothing to do
                        result[row][col] = "";
                    }
                } else {
                    result[row][col] = original[row][col];
                }
            }
        }
        return result;
    }

    public static boolean isThisTextAFloat(String text){
        boolean isFloat = false;
        try{
            float f = Float.parseFloat(text);
            isFloat = true;
        } catch (NumberFormatException nfe){
            // es ist keine Float
        }
        return isFloat;
    }

    public static boolean isThisTextAnInt(String text){
        boolean isInt = false;
        try{
            int x = Integer.parseInt(text);
            isInt = true;
        } catch (NumberFormatException nfe){
            // es ist keine Int
        }
        return isInt;
    }

    public static boolean isThisTextADate(String text){
        boolean isDate = false;
        try{
            Date x = sdfOriginal.parse(text);
            isDate = true;
        } catch (ParseException pe){
            // es ist keine Int
        }
        return isDate;
    }

    public static int[] getDataType(String[][] table){
        int[] dataType = new int[table[0].length];

        for (int row = 1; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (dataType[col] == DATATYPE_DATE && !isThisTextADate(table[row][col])){
                    dataType[col] = DATATYPE_INT;
                }
                if (dataType[col] == DATATYPE_INT && !isThisTextAnInt(table[row][col])){
                    dataType[col] = DATATYPE_FLOAT;
                }
                if (dataType[col] == DATATYPE_FLOAT && !isThisTextAFloat(table[row][col])){
                    dataType[col] = DATATYPE_STRING;
                }
            }
        }

        return dataType;
    }

    public static int[] getMaxColumnWith(String[][] table){
        int[] result = new int[table[0].length];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if (result[col] < table[row][col].length()){
                    result[col] = table[row][col].length();
                }
            }
        }
        return result;
    }


    public static void printTable(String[][] table, int[] dataTypes){
        if (table.length == 0) {
            System.out.println("The table is empty. :-)");
            return;
        }

        String[] alignedRight = new String[]{"", "", "", "-"};


        int[] optimalColumnWidth = getMaxColumnWith(table);
        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                String formatString = String.format("| %%%s%ds ", alignedRight[dataTypes[col]], optimalColumnWidth[col]);
                System.out.printf(formatString, table[row][col]);
            }
            System.out.println("|");
            if (row == 0){
                for (int col = 0; col < table[row].length; col++) {
                    String formatString = String.format("|-%%-%ds-", optimalColumnWidth[col]);
                    System.out.printf(formatString, "-".repeat(optimalColumnWidth[col]));
                }
                System.out.println("|");
            }
        }
    }

    public static String[][] readCSVintoTable(String fileName, String separator){
        int countLines = countLineOfFile(fileName);
        String[][] table = new String[countLines][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int row = 0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            table[row] = line.split(separator);
            ++row;
        }
        scanner.close();

        return table;
    }

    public static int countLineOfFile(String fileName){
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int count = 0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            ++count;
        }
        scanner.close();
        return count;
    }
}
