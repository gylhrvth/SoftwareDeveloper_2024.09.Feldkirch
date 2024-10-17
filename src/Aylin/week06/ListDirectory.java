package Aylin.week06;

import java.io.File;
import java.sql.SQLOutput;
import java.util.Arrays;

public class ListDirectory {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aslan Topcu\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Aylin\\week05");
        File[] files = file.listFiles();

        System.out.println("--------------Sorted List--------------");
        sortList(files);
        printList(files);
        System.out.println("---------List Sorted by length--------");
        sortListLength(files);
        printListLength(files);

//        System.out.println("Name: " + file.getName());
//        System.out.println("Größe: " + file.length());
//        System.out.println("ist Ordner: " + file.isDirectory());
//        System.out.println("is File: " + file.isFile());
//        System.out.println("list Files: " + Arrays.stream(files).toList());
//        System.out.println("get Parent: " + file.getParent());
//        System.out.println("is absolute: " + file.isAbsolute());
//        System.out.println("is hidden: " + file.isHidden());
//        System.out.println("get path: " + file.getPath());
//        System.out.println("get absolute path: " + file.getAbsolutePath());
//        System.out.println("get absolute file: " + file.getAbsoluteFile());

    }

    public static void sortList(File[] content){
        for (int i = 0; i < content.length ; i++) {
            for (int j = 0; j < content.length -i -1; j++) {
                if(content[j].isFile() && content[j + 1].isDirectory() ||
                content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) < 0 ||
                content[j].isFile() && content[j + 1].isFile() && content[j].compareTo(content[j + 1]) < 0){
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }
        }
    }

    public static void printList(File[] content){
        for (int i = 0; i < content.length; i++) {
            if(content[i].isDirectory()){
                System.out.printf("%-6s %-35s Size: [%4d]\n", "Dir:", content[i].getName(), content[i].length());
            }else{
                System.out.printf("%-6s %-35s Size: [%4d]\n", "File:", content[i].getName(), content[i].length());
            }
        }
    }

    public static void sortListLength(File[] content){
        for (int i = 0; i < content.length ; i++) {
            for (int j = 0; j < content.length -i -1; j++) {
                if(content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].length() < content[j + 1].length() ||
                        content[j].isFile() && content[j + 1].isFile() && content[j].length() < content[j + 1].length()){
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }
        }
    }

    public static void printListLength(File[] content){
        for (int i = 0; i < content.length ; i++) {
            if(content[i].isDirectory()){
                System.out.printf("%-6s %-35s Size: [%4d]\n", "Dir:", content[i].getName(), content[i].length());
            }else {
                System.out.printf("%-6s %-35s Size: [%4d]\n", "File:", content[i].getName(), content[i].length());
            }
        }
    }
}
