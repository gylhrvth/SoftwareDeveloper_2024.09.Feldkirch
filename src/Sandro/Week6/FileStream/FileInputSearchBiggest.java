package Sandro.Week6.FileStream;



import Sandro.Colors;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class FileInputSearchBiggest {
    public static void main(String[] args) {
        String path = inputPath("Please enter a Path...");
        File start = new File(path);

        long bigFile = biggestFileSize(start);
        printFilesAndData("", start);
        printRelativ(start,start,bigFile);
        printAbsolute(start,bigFile);
        printFileName(start,bigFile);

    }
    public static void printAbsolute(File current, long fileSizeToPrint) {              //Funktion bekommt, File start(ermittelt druch Path) und biggest size ermittelt durch andere Funktion
        if (current.isFile() && current.length() == fileSizeToPrint) {                  //Check ob es ein File ist und kein Ordner und ob es die Richtige größe hat (biggestSize)

            System.out.println(Colors.COLORS[2] + "The absolute Path for the biggest Size File is: " + Colors.COLORS[1] + current.getAbsolutePath() + Colors.RESET);
            return;
        }
        File[] files = current.listFiles();                                             //Typischer Rekursiver Loop durch alle Ordner vom Start-Path aus
        if (files != null) {                                                            //Check ob Ordner Leer ist
            myMagicSort(files);                                                         //Sortiere den Inhalt
            for (File a : files) {                                                      //For Each, jedes Element auslesen
                printAbsolute(a, fileSizeToPrint);                                      //und rekursiv mit der Funktion durcharbeiten
            }
        }
    }
    public static void printRelativ(File start, File current, long fileSizeToPrint) {               //Funktion, die den Relativen Pfad ermittelt und in der Konsole wiedergibt
        if (current.isFile() && current.length() == fileSizeToPrint) {                              //Check ob File kein Ordner ist und die größe dem biggestFile entspricht
            Path startPath = Path.of(start.getAbsolutePath());                                      //Path Datentyp verwenden und aus dem StartFile den AbsolutenPath generieren
            Path currentPath = Path.of(current.getAbsolutePath());                                  //Relativen Path erarbeiten.
            System.out.println(Colors.COLORS[2] + "The relative Path for the biggest Size File is: " + Colors.COLORS[1] + startPath.relativize(currentPath) + Colors.RESET);
            return;
        }
        File[] files = current.listFiles();                                                         //Typische Ordner öffnen und rekursiv durcharbeiten von allen files
        if (files != null) {
            myMagicSort(files);
            for (File a : files) {
                printRelativ(start, a, fileSizeToPrint);
            }
        }
    }
    public static void printFileName(File current, long fileSizeToPrint) {                          //Funktion die den FileName printet wenn das File übereinstimmt mit der größe
        if (current.isFile() && current.length() == fileSizeToPrint) {                              //Check ob kein Ordner, und vergleiche die größe
            System.out.println(Colors.COLORS[2] + "The FileName for the biggest Size File is: " + Colors.COLORS[1] + current.getName() + Colors.RESET);
            return;
        }
        File[] files = current.listFiles();                                                         //Ordner durchsuchen, für jeden Ordner, recursive Funktion verwenden
        if (files != null) {
            myMagicSort(files);
            for (File a : files) {
                printFileName(a, fileSizeToPrint);
            }
        }
    }
    public static long biggestFileSize(File f) {                                    //Funktion die ein Start File bekommt und dann die größte Datei sucht
        File[] files = f.listFiles();                                               //Aus StartFile ein Array machen (aka. Ordner öffnen)
        long biggestSize = 0;                                                       //init Long Var für biggestSize
        if (files != null) {                                                        //Check ob Ordner leer ist
            for (File a : files) {                                                  //ForEach all files
                long tempSize = 0;                                                  //init temporäre Var für FileSize
                if (a.isFile() && a.length() > biggestSize) {                       //Vergleich! ist aktuelle File eine Datei, wie groß ist sie und ist sie größer als biggestSize
                    tempSize = a.length();                                          //wenn ja, temporär speichern in der tempSize Var
                } else if (a.isDirectory()) {                                       //ist es keine Datei, also ein Ordner
                    tempSize = biggestFileSize(a);                                  //Var tempSize wird recursive weitergegeben
                }
                if (tempSize > biggestSize) {                                       //Am schluss, wird die Temporäre Size noch mit der biggestSize verglichen.
                    biggestSize = tempSize;                                         //Var wird überschrieben wenn true
                }
            }
        }
        return biggestSize;                                                         //Return
    }
    private static String inputPath(String text) {                                  //Scanner Funktion, bekommt einen String und testet ob zulässiger Pfad
        Scanner sc = new Scanner(System.in);                                        //Scanner
        while (true) {                                                              //while logic
            System.out.print("Enter a Path: ");                                     //Info an user
            String path = sc.nextLine();                                            //String path
            File directory = new File(path);                                        //File erstellen mit path
            if (directory.isDirectory()) {                                          //Check ob es ein Ordner ist
                return path;                                                        //bei true return
            } else {
                System.out.println(path + " not found");                            //bei false, nachricht
            }
        }
    }




    //Funktionen von vorherigen Beispiel
    public static void printFilesAndData(String space, File f) {
        String fileSizeAsText = String.format("%7d", f.length());
        if (!f.isFile()) {
            fileSizeAsText = " ".repeat(fileSizeAsText.length());
        }
        System.out.printf("%s %s%s%s%s\n",
                fileSizeAsText,
                space,
                (f.isFile() ? Colors.COLORS[1] : Colors.COLORS[4]),
                f.getName(),
                Colors.RESET);
        if (f.isFile()) {
            return;
        }
        File[] files = f.listFiles();
        if (files != null) {
            myMagicSort(files);
            for (File a : files) {
                printFilesAndData("   ", a);
            }
        }

        long biggestFileFound = biggestFileSize(f);

        System.out.println(Colors.COLORS[2]);
        System.out.println("-D-A-T-A- - -A-N-A-L-Y-S-");
        System.out.println(Colors.COLORS[2] + "Size of the biggest File is : " + Colors.COLORS[3] + biggestFileFound + Colors.COLORS[2] + " bytes.");
        System.out.print(Colors.RESET);


    }

    public static void myMagicSort(File[] f) {
        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length - i - 1; j++) {
                if (
                        (f[j].isFile() && !f[j + 1].isFile())
                                || ((f[j].isFile() == f[j + 1].isFile()) && f[j].compareTo(f[j + 1]) > 0)
                ) {
                    File temp = f[j];
                    f[j] = f[j + 1];
                    f[j + 1] = temp;
                }

            }
        }
    }






}
