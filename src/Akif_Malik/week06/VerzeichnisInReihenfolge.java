package Akif_Malik.week06;

import java.io.File;
import java.util.Arrays;

public class VerzeichnisInReihenfolge {
    public static void main(String[] args) {
        File daten = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Akif_Malik\\week02");

        File[] content = daten.listFiles();
        System.out.println(Arrays.toString(content));
        swapper(content);
        printer(content);


    }

    public static void swapper(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length-1; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) < 0) {
                    File temp = content[i];
                    content[i] = content[i + 1];
                    content[i + 1] = temp;
                }
            }
        }
    }

    public static void printer(File[] content) {
        String[] text = new String[]{};
        for (int i = 0; i < content.length; i++) {
            System.out.println(content[i].getName());


        }

    }
}
