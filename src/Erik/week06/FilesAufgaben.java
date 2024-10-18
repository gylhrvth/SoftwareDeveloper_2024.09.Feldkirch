package Erik.week06;

import Sandro.Colors;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FilesAufgaben {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        File target = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Erik");
        File[] content = target.listFiles();
        System.out.print("Verzeichnis Auflisten:\n-----");
        giveListOfAllFiles(content);
        System.out.println(">>Nicht Geordnet<<\n");
        printList(content);
        orderFilesDescending(content);
        System.out.println("Geordnet: >>Größe Absteigend<<\n");
        printList(content);
        goThroughListAndPrintNumbersOfFilesAndSum(content);
        goThroughListAndPrintRekursiv(0, target);


    }

    // 1. Aufgabe
    public static void giveListOfAllFiles(File content[]) {
        System.out.println("\nAusgabe vom Inhalt des Pfades");
        System.out.println(Arrays.toString(content));
        System.out.println("----");
    }

    // 2. Aufgabe nach Größe sortieren absteigend
    public static void orderFilesDescending(File content[]) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) > 0 ||
                        content[j].isFile() && content[j + 1].isFile() && content[j].length() < content[j + 1].length()) {
                    File temp = content[j + 1];
                    content[j + 1] = content[j];
                    content[j] = temp;
                }
            }
        }
    }

    // 2. Aufgabe Print Version
    public static void printList(File content[]) {
        for (File file : content) {
            System.out.printf("Name: >> %-18s | Size: >> (%4s)\n", file.getName(), file.length());
        }
        System.out.println("-----------------------------------------------------------");
    }

    // 3. Aufgabe Dateien Zählen und Größe Summieren
    public static void goThroughListAndPrintNumbersOfFilesAndSum(File content[]) {
        int numberOfData = 0;
        long wholeDataSize = 0;

        if (content != null) {
            for (File datei : content) {
                if (datei.isFile()) {
                    numberOfData++;
                    wholeDataSize += datei.length();
                }
            }
        }
        System.out.println(numberOfData + " Dateien sind vorhanden.");
        System.out.println("Die Dateien sind " + wholeDataSize + " groß.");
        System.out.println("-----------------------------------------------------------");
    }

    // 3. Aufgabe Dateien Zählen und Größe Summieren mit Bonus (Rekursiv)
    public static void goThroughListAndPrintRekursiv(int zahl, File f) {

        System.out.println(" ".repeat(zahl * 3) + f.getName());

        if (f.isFile()) { // Solange es eine Datei ist printet er
            return;
        }

        File[] content = f.listFiles();
        if (content != null) {
            for (File file : content) {
                goThroughListAndPrintRekursiv(zahl + 1, file);
            }

        }
        int count = countAllFilesFromRekursiv(f);
        long sum = sumFilesFromRekursiv(f);

        System.out.println(Colors.COLORS[1] + "Anzahl der Dateien: >> " + count + Colors.RESET);
        System.out.println(Colors.COLORS[2] + "Summe der Dateien: >> " + sum + Colors.RESET);
        System.out.println("-----------------------------------------------------------");
    }

    // 3. Aufgabe Bonus Unterprogramm alle Datei größen zusammen rechnen (Rekursiv)
    public static long sumFilesFromRekursiv(File f) {
        long wholeDataSize = 0;
        File[] content = f.listFiles();
        if (content != null) {              // Wenn content nicht leer ist, soll was passieren
            for (File datei : content) {
                if (datei.isFile()) {
                    wholeDataSize += datei.length();
                } else {
                    wholeDataSize += sumFilesFromRekursiv(datei);
                }
            }
        }
        return wholeDataSize;
    }

    // 3. Aufgabe Bonus Unterprogramm alle Dateien zählen (Rekursiv)
    public static int countAllFilesFromRekursiv(File f) {
        int numberOfData = 0;
        File[] content = f.listFiles();
        if (content != null) {              // Wenn content nicht leer ist, soll was passieren
            for (File datei : content) {
                if (datei.isFile()) {
                    numberOfData++;
                } else {
                    numberOfData += countAllFilesFromRekursiv(datei);
                }
            }
        }
        return numberOfData;
    }

}
