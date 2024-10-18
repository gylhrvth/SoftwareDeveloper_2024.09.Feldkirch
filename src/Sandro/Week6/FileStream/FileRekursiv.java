package Sandro.Week6.FileStream;

import Sandro.Colors;

import java.io.File;

public class FileRekursiv {
    public static void main(String[] args) {
        File search = new File("C:\\Users\\ossdr\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Thiemo");
        printRecrusive(" ",search);
       // printSimple(1, search);
    }
    public static void printSimple(int tabs, File f) {
        int color = tabs;
        System.out.printf("%-35s  -- [%5s]\n",f.getName(),f.length());
        //System.out.println("-".repeat(tabs) + Colors.COLORS[color]+"Ebene(" + tabs + ")"+Colors.RESET+"  |" + f.getName());     //print space.repeat + file name

        if (f.isFile()) {                                                                                                        //file = datei, einfach return
            return;
        }

        File[] list = f.listFiles();                                                                                             //file = ordner, öffnen und durchsuchen (File[] mit listFiles)
        if (list != null) {                                                                                                      //check ob ordner leer ist
            myMagicSort(list);                                                                                                   //optional sortiere den Inhalt
            for (File fi : list                                                                                                  //loop durch den content
            ) {
                printSimple(tabs + 1, fi);                                                                                  //für jedes element in der liste, rufe die Methode neu auf
            }
        }
        int count = countFilesRecursive(f);                                         //hilfsfunktion für count
        long sum = sumOfFilesRecursive(f);                                          //hilfsfunktion für sum

        System.out.println("Summe ist = "+ sum);
        System.out.println("Counter ist = "+ count);
    }

    public static void printRecrusive(String space, File f) {
        String fileSizeAsText = String.format("%7d", f.length());                   //int zahl zu einem String mit Formatierung
        if (!f.isFile()) {                                                          //wenn file keine Datei ist
            fileSizeAsText = " ".repeat(fileSizeAsText.length());                   //print soviel abstand, wie das size format für die größe
        }

        System.out.printf("%s %s%s%s%s\n",                                          //print format
                fileSizeAsText,                                                     //size
                space,                                                              //abstand
                (f.isFile() ? Colors.COLORS[0] + Colors.BACKGROUND_COLORS[7]        //wenn es eine Datei ist rot, wenn es ein Ordner ist blau printen
                        : Colors.COLORS[0] + Colors.BACKGROUND_COLORS[3]),
                f.getName(),                                                        //namen printen
                Colors.RESET
        );

        if (f.isFile()) {                                                           //ist file ein Datei retrun
            return;
        }

        File[] files = f.listFiles();                                               //Ordner werden in eine liste gewandelt
        if (files != null) {                                                        //ist der Ordner leer?
            myMagicSort(files);                                                     //Sortier den Inhalt
            for (File fi : files) {                                                 //foreach files in list
                printRecrusive(space + "    ", fi);                           //für jeden treffer, verwenden wir auf neue unsere Funktion
            }
        }

        int count = countFilesRecursive(f);                                         //hilfsfunktion für count
        long sum = sumOfFilesRecursive(f);                                          //hilfsfunktion für sum


        System.out.println();
        System.out.println(Colors.COLORS[0] + Colors.BACKGROUND_COLORS[5] + "#".repeat(55));                                       //optionale Print infos
        System.out.println("-D-A-T-A- - -A-N-A-L-Y-S-");
        System.out.println("Found: " + Colors.BACKGROUND_COLORS[1] + count + Colors.BACKGROUND_COLORS[5] + " files in the path: " + Colors.BACKGROUND_COLORS[2] + f.getName() + Colors.BACKGROUND_COLORS[5]);
        System.out.println(Colors.BACKGROUND_COLORS[5] + "Size of all found files is: " + Colors.BACKGROUND_COLORS[4] + sum + Colors.BACKGROUND_COLORS[5] + " bytes.");
        System.out.println(Colors.COLORS[0] + Colors.BACKGROUND_COLORS[5] + "#".repeat(55));
        System.out.println(Colors.RESET);


    }

    public static void myMagicSort(File[] files) {
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < files.length - i - 1; j++) {
                if ((files[j].isFile() && !files[j + 1].isFile()) || ((files[j].isFile() == files[j + 1].isFile()) && files[j].compareTo(files[j + 1]) > 0)) {
                    File temp = files[j];
                    files[j] = files[j + 1];
                    files[j + 1] = temp;
                }
            }
        }
    }

    public static long sumOfFilesRecursive(File f) {
        File[] files = f.listFiles();                                   //File list erstellen
        long sum = 0;                                                   //init Var für Long
        if (files != null) {                                            //check ob nicht null, leer etc
            for (File fi : files) {                                     //foreach files in list
                if (fi.isFile()) {                                      //wenn file eine Datei ist
                    sum += fi.length();                                 //sum erweitern wie gewohnt
                } else {                                                //wenn nicht dann ist es ein Ordner
                    sum += sumOfFilesRecursive(fi);                     //wir schauen mit hilfe von der metheode und dem aktuellen file, in den ordner
                }
            }
        }
        return sum;
    }
    public static int countFilesRecursive(File f) {
        File[] files = f.listFiles();                           //erstelle eine liste von files
        int count = 0;                                          //init Var für count
        if (files != null) {                                    //check ob das gewählte file nicht leer bzw. nicht existent ist
            for (File fi : files) {                             //for each files in list
                if (fi.isFile()) {                              //wenn wir eine Datei finden, simple count
                    count++;
                } else {                                        //wenn nicht, ist es ein directory und wir wollen in das directory rein schauen
                    count += countFilesRecursive(fi);           //aufruf der methode, mit dem gerade aktuellen file
                }
            }
        }
        return count;
    }
}