package Furkan.week06;

import java.io.File;
import java.util.Arrays;

public class Files {
    public static void main(String[] args) {

        File target = new File("C:/Users/dcv/IdeaProjects/SoftwareDeveloper_2024.09.Feldkirch/src/Furkan/week06");

//        System.out.println("Name " + target.getName());
//        System.out.println("Größe " + target.length());
//        System.out.println("Existiert " + target.exists());
//        System.out.println(target.getParent());
//        System.out.println(target.getPath());
//        System.out.println(target.getAbsolutePath());
//        System.out.println(target.isDirectory());
//        System.out.println(target.isFile());
//        System.out.println(target.isHidden());
//        System.out.println(target.lastModified());

        File[] content = target.listFiles();
        System.out.println(Arrays.toString(content));

        printList(content);
        sortMyList(content);

        printState(content);



    }

    public static void sortMyList(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length -i -1 ; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                    content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) < 0 ||
                    content[j].compareTo(content[j + 1]) > 0) {
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }

        }
    }
    public static void printList (File[] content){
        for (int i = 0; i < content.length ; i++) {
            System.out.println(content[i].getName() + (content[i].isDirectory() ? "[Verzeichnis]" : ""));
        }


    }

    public static void printState(File[] content){
        int nr = 1;


        for (int i = 0; i < content.length; i++) {
            if (content[i].isFile()){
                System.out.printf("Nr.%d) %-25s --[%5s]\n", nr,content[i].getName(),content[i].length() );
            }else {
                System.out.println("Das Verzeichniss ist leer" );
            }nr++;

        }
    }


}