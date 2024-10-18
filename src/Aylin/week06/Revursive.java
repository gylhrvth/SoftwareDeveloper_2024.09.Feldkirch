package Aylin.week06;

import Sandro.Colors;

import java.io.File;

public class Revursive {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aslan Topcu\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Aylin");
        printRecursive(1, file);
    }

    public static void printRecursive(int tabs, File f) {
        String stroke = "---".repeat(tabs);
        System.out.printf("Bytes: [%-5s]" + Colors.COLORS[tabs + 2] + "%10s Ebene: %s" + Colors.RESET + " %-20s\n", f.length(), stroke, tabs, f.getName());
//        System.out.printf(Colors.COLORS[tabs + 3] + "Ebene: "+ Colors.RESET + "%s %-10s %-40s Bytes : {%-5s}\n", tabs, stroke, f.getName(), f.length());

        if (f.isDirectory()) {
            System.out.println();
        }
        if (f.isFile()) {
            return;
        }
        File[] list = f.listFiles();
        if (list != null) {
            Aylin.week06.ListDirectory.sortList(list);
            for (File fl : list) {
                printRecursive(tabs + 1, fl);
            }
            System.out.println( Colors.COLORS[2] + "Total files: " + countFiles(f) + Colors.RESET);
            System.out.println( Colors.COLORS[3] + "Total files: " + sumFiles(f) + Colors.RESET);
            System.out.println();
        }
    }

    public static int countFiles(File f) {
        File[] files = f.listFiles();
        int count = 0;
        if (files != null) {
            for (File fl : files) {
                if (fl.isFile()) {
                    count++;
                } else{
                    count += countFiles(fl);
                }
            }
        }
        return count;
    }

    public static long sumFiles(File f) {
        File[] files = f.listFiles();
        long sum = 0;
        if (files != null) {
            for (File fl : files) {
                if (fl.isFile()) {
                    sum+= fl.length();
                } else{
                    sum += sumFiles(fl);
                }
            }
        }
        return sum;
    }
}
