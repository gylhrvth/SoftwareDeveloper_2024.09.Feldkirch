package Aylin.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DisplayFileTabular {
    public static void main(String[] args) {

        try {
            File file = new File("assets/tmp/output.txt");
            file.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(file, false);
            PrintStream ps = new PrintStream(fos);
            layout(ps, table());
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static String[][] table(){
        String[][] table = new String[5][];
        table[0] = new String[] {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        table[1] = new String[] {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        table[2] = new String[] {"40", "78", "5", "18", "81"};
        table[3] = new String[] {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        table[4] = new String[] {"0f", "654.4f", "12.457634366f", "120.0f", "119.9999f"};

        return table;
    }

    public static void layout(PrintStream ps, String[][] arr) {
        ps.println("_______________________________________________________________________________________________");
        ps.println("| Name                | Surname              | Age   | Place                | Distance        |");
        ps.println("_______________________________________________________________________________________________");
        for (int i = 0; i <arr.length; i++) {
            ps.printf("|%-20s | %-20s | %-5s | %-20s | %-15s |\n", arr[0][i], arr[1][i], arr[2][i], arr[3][i], arr[4][i]);
        }
        ps.println("_______________________________________________________________________________________________");
    }
}