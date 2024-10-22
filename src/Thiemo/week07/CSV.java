package Thiemo.week07;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class CSV {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String file = "csv/sales_100.csv";
        String[][] data = readCSV(file);
        printFormattedData(data, data.length);
    }

    public static int countwhatever(String file) {
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

        int countLines = countwhatever(file);
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

    public static void printFormattedData(String[][] data, int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%-"+data+"s",data[i][j]);
            }
            System.out.println();
        }
    }
}