package Erik.week07;

import Gyula.week07.ReadFileFromRessources1;
import java.io.File;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class CSVTabellarischDarstellen {
    public static void main(String[] args) {

        String fileName = "csv/sales_100.csv";
        int row = countRowFromCSV(fileName);
//        int col = countColFromCSV(fileName);
        String[][] h = readCSVirgendwas(fileName);

        String[][] csv = new String[row][14];
        printCSVTabellarisch(csv);
    }

    public static void printCSVTabellarisch(String[][] csv){
        for (int i = 0; i <csv.length ; i++) {
            for (int j = 0; j <csv[i].length ; j++) {
                System.out.printf("| %s |\n", csv[i]);
            }
        }
    }

// Gibt mir die Columns zurück???
    public static String[][] readCSVirgendwas(String fileName){
       int row = countRowFromCSV(fileName);
        String[][] arr = new String[row][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int col = 0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            arr[col] = line.split(",");
            ++col;
        }
        scanner.close();
        return arr;
    }

// Zählt die Rows und gibt sie zurück
    public static int countRowFromCSV(String fileName){
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int row = 0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            ++row;
        }
        System.out.println(row);
        scanner.close();
        return row;
    }

//    public static int countColFromCSV(String fileName){
//        File path = new File("csv/sales_100.csv");
//        String text = //inhalt von pfad in String speichern
//        int col = 0;
//
//        for (int i = 0; i < text.length ; i++) {
//            ++col;
//        }
//
//        return col;
//    }

}
