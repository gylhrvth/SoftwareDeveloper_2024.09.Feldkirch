package Furkan.week06;

import Sandro.Colors;

import java.io.File;
import java.util.Scanner;

public class FilesRekursiv {
    public static void main(String[] args) {

        File search = new File("C:/Users/dcv/IdeaProjects/SoftwareDeveloper_2024.09.Feldkirch/src/Furkan");

        prinSimple(1, search);

        int count = countDatei(search);
        System.out.println("Summe von den Files ist : " + count);

        long sum = sumOffFilesRecursive(search);
        System.out.println("Gesamte Größe ist: " + sum + "Bytes");

    }


    public static void prinSimple(int tabs, File f) {

        System.out.println("-".repeat(tabs * 3) + Colors.COLORS[tabs] + "Ebene(" + tabs + ")" + Colors.RESET + "  |" + f.getName());

        if (f.isFile()) {                //wenn file kein ordner ist...
            return;
        }
        //wenn file ein Ordner ist, dann....
        File[] list = f.listFiles();                     //machen ein liste aus dem file
        if (list != null) {                             //prüfen, ob der ordner leer ist?
            myMagicSort(list);
            for (File file : list) {                      //jedes element von der liste....
                prinSimple(tabs + 1, file);
            }

        }

        //ordner geöffnet, durchgearbeitet...
    }


    public static int countDatei(File f) {

        File[] list = f.listFiles();
        int count = 0;
        if (list != null) {
            myMagicSort(list);
            for (File file : list) {
                if (file.isFile()) {
                    count++;
                } else {
                    count += countDatei(file);
                }
            }
        }
        return count;
    }

    public static long sumOffFilesRecursive(File f) {
        File[] files = f.listFiles();
        long sum = 0;
        if (files != null) {
            for (File fi : files) {
                if (fi.isFile()) {
                    sum += fi.length();
                } else {
                    sum += sumOffFilesRecursive(fi);
                }
            }
        }
        return sum;

    }

    public static void searchFile(File f) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben sie den Dateipfad ein: ");
        String userInput = scanner.nextLine();
        File largestFile = null;


        if (f.isFile()) {
            return;
        }
        File[] list = f.listFiles();
        if (list != null) {
            for (File file : list) {
                if (file.isFile()) {
                    if (largestFile == null || file.length() > largestFile.length()) {
                       // largestFile == file;
                    }
                } else if (file.isDirectory()) {

                }
            }
        }


    }


    public static void myMagicSort(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                    content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) > 0 ||
                    content[j].isFile() && content[j + 1].isFile() && content[j].compareTo(content[j + 1]) > 0) {
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }

        }
    }
}
