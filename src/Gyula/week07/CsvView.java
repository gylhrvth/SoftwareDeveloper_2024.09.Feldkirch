package Gyula.week07;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class CsvView {
    public static void main(String[] args) {
        String fileName = "csv/sales_100.csv";


        String[][] table = readCSVintoTable(fileName);
    }

    public static String[][] readCSVintoTable(String fileName){
        int countLines = countLineOfFile(fileName);
        String[][] table = new String[countLines][];

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
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
