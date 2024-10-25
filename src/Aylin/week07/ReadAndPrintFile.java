package Aylin.week07;

import Gyula.week07.ReadFileFromRessources1;
import Sandro.Colors;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.SortedMap;

public class ReadAndPrintFile {
    public static final int DATATYPE_DATE = 0;
    public static final int DATATYPE_INT = 1;
    public static final int DATATYPE_FLOAT = 2;
    public static final int DATATYPE_STRING = 3;

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
        if (table.length == 0){
            System.out.println("The table is empty...");
            return;
        }

//        int[] dataType = getDataType(table);
        int[] maxLengths = getMaxTotalLength(table);
        for (int i = 0; i < table[0].length; i++) {
            System.out.printf("| %s%-"+maxLengths[i]+"s%s ",Colors.COLORS[4], table[0][i], Colors.RESET);
        }
        System.out.println("|");

        printSeparator(maxLengths);
        for (int i = 1; i < table.length; i++) {
            String[] row = table[i];
            for (int j = 0; j < table[0].length ; j++) {
                System.out.printf("| %-"+maxLengths[j]+"s ", row[j]);
            }
            System.out.println("|");
        }
        printSeparator(maxLengths);
    }

    public static int[] getMaxTotalLength(String[][] table) {
        int[] maxLengths = new int [table[0].length];

        for (int row = 0; row < table.length; row++) {
            for (int col = 0; col < table[row].length; col++) {
                if(maxLengths[col] < table[row][col].length()){
                    maxLengths[col] = table[row][col].length();
                }
            }
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

//    public static int[] getDataType(String[][] table){
//        int[] dataType = new int[table[0].length];
//
//        for (int row = 0; row <table.length; row++) {
//            for (int col = 0; col < table[row].length; col++) {
//                if(dataType[col] == DATATYPE_DATE && !isThisTextADate(table[row][col])){
//                    dataType[col] = DATATYPE_INT;
//                }
//                if(dataType[col] == DATATYPE_INT && !isThisTextAnInteger(table[row][col])){
//                    dataType[col] = DATATYPE_STRING;
//                }
//                if(dataType[col] == DATATYPE_STRING && !isThisTextAString(table[row][col])){
//                    dataType[col] = DATATYPE_DATE;
//                }
//                if(dataType[col] == DATATYPE_FLOAT && !isThisTextAFloat(table[row][col])){
//                dataType[col] = DATATYPE_STRING;
//
//                }
//            }
//        }
//        return dataType;
//    }
//
//    public static boolean isThisTextADate(String text){
//        boolean isDate = false;
//        SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
//        try{
//            Date date = sdf.parse(text);
//            isDate = true;
//        }catch(ParseException pe){
//            //nothing to do
//        }
//        return isDate;
//    }
//
//    public static boolean isThisTextAnInteger(String text){
//        boolean isInt = false;
//
//        try{
//            int x = Integer.parseInt(text);
//            isInt = true;
//        }catch(NumberFormatException nfe){
//            //nothing to do
//        }
//        return isInt;
//    }
//
//    public static boolean isThisTextAString(String text){
//        boolean isString = false;
//
//        try{
//            String String = ;
//            isString = true;
//        }catch(NumberFormatException nfe){
//            //nothing to do
//        }
//        return isString;
//    }
//
//    public static boolean isThisTextAFloat(String text){
//        boolean isFloat = false;
//
//        try{
//            float f = Float.parseFloat(text);
//            isFloat = true;
//        }catch(NumberFormatException nfe){
//            //nothing to do
//        }
//        return isFloat;
//    }
}
