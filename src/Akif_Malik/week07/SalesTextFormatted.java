package Akif_Malik.week07;

import Gyula.week07.ReadFileFromRessources1;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class SalesTextFormatted {
    public static void main(String[] args) {

    }

    public static int countLineOfFile(String fileName) {
        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputStream);

        int count = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ++count;
        }
        scanner.close();
        return count;
    }

    public static String[][] readCSVintoTable(String fileName){
        int countlines = countLineOfFile(fileName);
        String[][] table = new String[countlines][];

        InputStream inputsteam = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream(fileName));
        Scanner scanner = new Scanner(inputsteam);

        int row = 0;
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            ++row;
        }
        scanner.close();
        return table;
    }

    public static void printFormatted (){
        
    }


}
