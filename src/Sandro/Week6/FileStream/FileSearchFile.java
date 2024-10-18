package Sandro.Week6.FileStream;

import java.io.File;
import java.util.Scanner;

public class FileSearchFile {
    public static void main(String[] args) {

        String path = inputPath();
        File start = new File(path);
        String search = inputSearch();

        //Teste deine Funktion
        // String search = "thiemo";
        // File start = new File("C:\\Users\\ossdr\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src");

        printFile(start, search);

    }

    public static void printFile(File f, String search) {                                                   //Funktion print alle Files die Zielwort beinhalten
        if (f.isFile() && f.getAbsolutePath().toLowerCase().contains(search.toLowerCase())) {               //start pfad to lowercase vergleich mit zielwort to lowercase (schreibfehler)
            System.out.println("FileName: " + f.getName() + " Path to File: " + f.getAbsolutePath());       //bei einem Treffer printen
        }
        if (f.isDirectory()) {                                                                              //ist es ein Ordner, rekursive durchlauf von allen files im ordner
            File[] files = f.listFiles();
            if (files != null) {
                for (File fi : files) {
                    printFile(fi, search);
                }
            }
        }
    }

    public static String inputPath() {                                      //Scanner für Path
        Scanner sc = new Scanner(System.in);                                //Scanner
        while (true) {                                                      //While logic
            System.out.print("Enter a Path: ");                             //user info
            String path = sc.nextLine();                                    //lies einen String aus, speicher in Var path
            File directory = new File(path);                                //erstelle ein File aus dem String path
            if (directory.isDirectory()) {                                  //check ob das File ein Ordner ist
                return path;                                                //wenn True, return
            } else {
                System.out.println(path + " not found");                    //wenn False, info an user
            }
        }
    }

    public static String inputSearch() {                                    //Scanner für Search Term, noch was gesucht wird
        Scanner sc = new Scanner(System.in);                                //Scanner
        System.out.print("Enter a Word to search: ");                       //User info
        return sc.nextLine();                                               //return string von input
    }
}
