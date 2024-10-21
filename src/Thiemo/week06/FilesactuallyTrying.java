package Thiemo.week06;

import Sandro.Colors;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class FilesactuallyTrying {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        File target = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Thiemo");
        System.out.println(target);

        File[] idk = target.listFiles();
//        assert idk != null;
//        sort(idk);
//        printFile(idk);
//        System.out.println();
//        countAndsum(idk);
//        System.out.println();
        iStillDontKnow(target, 1);
        countFiles(target);



    }

    public static void sort(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - 1 - i; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) > 0 ||
                        content[j].isFile() && content[j + 1].isFile() && content[j].length() < content[j + 1].length()) {
                    swap(content, j, j + 1);
                }
            }
        }
    }

    public static void swap(File[] content, int i, int j) {
        if (i >= 0 && j >= 0 && i < content.length && j < content.length) {
            File temp = content[i];
            content[i] = content[j];
            content[j] = temp;
        }
    }

    public static void printFile(File[] target) {
        for (int i = 0; i < target.length; i++) {
            if (target[i].isFile()) {
                System.out.printf("File  %-40s  Size { %-5d} ", target[i].getName(), target[i].length());
                System.out.println();
            }
            if (target[i].isDirectory()) {
                System.out.printf("Dir   %-40s  Size { %-5d} ", target[i].getName(), target[i].length());
                System.out.println();
            }
        }
    }

    public static void countAndsum(File[] target) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            if (target[i].isFile() || target[i].isDirectory()) {
                System.out.printf("Nr:%2s %-40s  Size { %-5d} ", count, target[i].getName(), target[i].length());
                System.out.println();
                count++;
                sum += target[i].length();
            }
        }
        System.out.println("Count :" + (count - 1));
        System.out.println("Sum :" + sum);
    }

    public static void iStillDontKnow(File file, int spaces) {
        String space = ">>>".repeat(spaces);
        System.out.printf(Colors.COLORS[1 + spaces] + "Ebene " + spaces + Colors.RESET + " %-25s %15s  %-50sBytes : {%-5s}\n", Colors.COLORS[1] + space + Colors.RESET, Colors.COLORS[spaces] + spaces + Colors.RESET, file.getName(), file.length());

        if (file.isDirectory()) {
            System.out.println();
        }
//        System.out.println("Bytes: {"+file.length()+"}" +" "+ ">".repeat(spaces)+" " + file.getName());
        if (file.isFile()) {

            return;
        }
        File[] whatever = file.listFiles();
        if (whatever != null) {
            sort(whatever);
            for (File f : whatever) {
                iStillDontKnow(f, spaces + 1);
            }
            int count =  countFiles(file);
            long sum = sumFiles(file);
            System.out.println("Found "+count+" Files in the folder: "+ file.getName());
            System.out.println("Sum of Bytes in this folder: "+ sum);
        }

        System.out.println();
    }

    public static int countFiles(File file) {
        File[] whatever = file.listFiles();
        int count = 0;
        if (file != null) {
            for (File fi : whatever) {
                if (fi.isFile()) {
                    count++;
                } else {
                    count += countFiles(fi);
                }
            }
        }
        return count;
    }


    public static long sumFiles(File file) {
        File[] whatever = file.listFiles();
        long sum = 0;
        if (file != null) {
            for (File fi : whatever) {
                if (fi.isFile()) {
                    sum += fi.length();
                } else {
                    sum += sumFiles(fi);
                }
            }
        }
        return sum;
    }
}




