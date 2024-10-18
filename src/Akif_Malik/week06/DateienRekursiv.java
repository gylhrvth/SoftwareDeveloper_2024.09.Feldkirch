package Akif_Malik.week06;

import Sandro.Colors;

import java.io.File;

public class DateienRekursiv {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Akif_Malik");
        File[] files = file.listFiles();

        /*System.out.println("--------------Sorted List--------------");
        sortList(files);
        printList(files);
        System.out.println("---------List Sorted by length--------");
        sortListLength(files);
        printListLength(files);
        printRekursiv(file);
        SumOfFiles(file);
        printFilesRecursively(file, 0);
         */

        printRecrusive(" ", file);
    }

    public static void sortList(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) < 0 ||
                        content[j].isFile() && content[j + 1].isFile() && content[j].compareTo(content[j + 1]) < 0) {
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }
        }
    }

    public static void printList(File[] content) {
        for (File file : content) {
            if (file.isDirectory()) {
                System.out.printf("%-6s %-35s Size: [%4d]\n", "Dir:", file.getName(), file.length());
            } else {
                System.out.printf("%-6s %-35s Size: [%4d]\n", "File:", file.getName(), file.length());
            }
        }
    }

    public static void sortListLength(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].length() < content[j + 1].length() ||
                        content[j].isFile() && content[j + 1].isFile() && content[j].length() < content[j + 1].length()) {
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }
        }
    }

    public static void printListLength(File[] content) {
        for (File file : content) {
            if (file.isDirectory()) {
                System.out.printf("%-6s %-35s Size: [%4d]\n", "Dir:", file.getName(), file.length());
            } else {
                System.out.printf("%-6s %-35s Size: [%4d]\n", "File:", file.getName(), file.length());
            }
        }
    }

    public static void printRekursiv(File file) {
        if (file.isFile()) {
            System.out.println(Colors.COLORS[4] + "-----|" + file.getName() + "    -" + "[" + file.length() + "]" + Colors.RESET);
        } else if (file.isDirectory()) {
            System.out.println(Colors.COLORS[2] + "---------|" + file.getName() + "-" + Colors.RESET);
            File[] contentOfDirectory = file.listFiles();
            for (int i = 0; i < contentOfDirectory.length; i++) {
                printRekursiv(contentOfDirectory[i]);
            }
        }
    }

    public static void printFilesRecursively(File file, int indent) {
        if (file.isDirectory()) {
            System.out.println(getIndentString(indent) + "[" + file.getName() + "]");
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    printFilesRecursively(subFile, indent + 1);
                }
            }
        } else {
            System.out.println(getIndentString(indent) + file.getName());
        }
    }

    private static String getIndentString(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("  "); // Two spaces for each indent level
        }
        return sb.toString();
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
