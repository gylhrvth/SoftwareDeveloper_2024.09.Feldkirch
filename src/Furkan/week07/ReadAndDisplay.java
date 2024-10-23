package Furkan.week07;

import Gyula.week07.ReadFileFromRessources1;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ReadAndDisplay {
    public static void main(String[] args) {
        String[][] tabelle = readCSVintgTable();

        for (String[] row: tabelle){
            for (String value : row){
                System.out.printf("%25s", value);
            }
            System.out.println();
        }


    }

    public static String[][] readCSVintgTable(){
        int countlines = countLineOffFile();
        String[][] table = new String[countlines][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream("csv/sales_100.csv"));
        Scanner scanner = new Scanner(inputStream);

        int row = 0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            table[row] = line.split(",");
            ++row;
        }
        scanner.close();
        return table;
    }


    public static int countLineOffFile(){
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream("csv/sales_100.csv"));
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
