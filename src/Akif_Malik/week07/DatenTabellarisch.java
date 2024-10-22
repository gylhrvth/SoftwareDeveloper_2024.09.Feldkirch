package Akif_Malik.week07;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DatenTabellarisch {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("assets/tmp/output.txt");
            PrintStream ps = new PrintStream(fos, false);

            String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
            String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
            int[] age = {40, 78, 5, 18, 81};
            String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
            float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

            ps.println("----------------------------------------------------------------------------------");
            ps.printf("| %-20s | %-20s | %-5s | %-14s |%-10s\n", "Name", "Surname", "Age", "Place", "Distance |");
            ps.println("----------------------------------------------------------------------------------");

            for (int i = 0; i < firstName.length; i++) {
                ps.printf("| %-20s | %-20s | %-5d | %-14s | %-6.2f  |\n",
                        firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
                ps.println("----------------------------------------------------------------------------------");
            }
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(" ");
        }
    }
}

