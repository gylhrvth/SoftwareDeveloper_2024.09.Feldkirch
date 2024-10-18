package Sandro.Week6.FileStream;

import java.io.File;

public class FileList {
    public static void main(String[] args) {

        File search = new File("C:\\Users\\ossdr\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Sandro");
        File[] filelist = search.listFiles();
        printList(filelist);
        sortMyList(filelist);
        System.out.println("-----------");
        printList(filelist);

    }

    public static void printList(File[] content){
        for (File f : content) {
            if (f.isFile()) {
                System.out.println("FileName : " + f.getName() + " Size: "+f.length());
            } else {
                System.out.println("Dir.Name : " + f.getName());
            }
        }
    }
    public static void sortMyList(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length -i -1; j++) {
                if (
                    content[j+1].isDirectory() && content[j].isFile() ||
                    content[j+1].isDirectory() && content[j].isDirectory() && content[j].compareTo(content[j+1]) > 0 ||
                    content[j].isFile() && content[j+1].length() > content[j].length()
                ){
                    File temp = content[j];
                    content[j] = content[j+1];
                    content[j+1]= temp;
                }
            }
        }



    }


}
