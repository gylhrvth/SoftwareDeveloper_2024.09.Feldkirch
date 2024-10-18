package Akif_Malik.week06;

import Sandro.Colors;

import java.io.File;

public class RecursiveCounting {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Akif_Malik");
        File[] files = file.listFiles();
        //First Way
        printRekursiv(file);
        //Second Way (made by chatgpt)
        printFilesRecursively(file, 0);

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
}
