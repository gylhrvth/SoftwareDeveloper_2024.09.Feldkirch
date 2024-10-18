package Aylin.week06;

import java.io.File;

public class CountAndSumFiles {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Aslan Topcu\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Aylin\\week05");
        File[] files = file.listFiles();

        System.out.println("--------------Sorted List--------------");
        sortList(files);
        printList(files);

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
}
