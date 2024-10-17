package Akif_Malik.week06;

import Sandro.Colors;

import java.io.File;

public class DateienRekursiv {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src");
        File[] files = file.listFiles();

        /*System.out.println("--------------Sorted List--------------");
        sortList(files);
        printList(files);
        System.out.println("---------List Sorted by length--------");
        sortListLength(files);
        printListLength(files);
         */

        printRekursiv(file);

        //printFilesRecursively(file, 0);
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
            System.out.println(Colors.COLORS[4] +"-----|" + file.getName() + "|" + Colors.RESET);
        } else if (file.isDirectory()) {
            System.out.println(Colors.COLORS[2] + "---------|" + file.getName() + "|" + Colors.RESET);
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
}
