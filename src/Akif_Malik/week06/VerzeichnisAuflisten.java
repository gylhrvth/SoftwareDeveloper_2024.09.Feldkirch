package Akif_Malik.week06;

import java.io.File;
import java.util.Arrays;

public class VerzeichnisAuflisten {
    public static void main(String[] args) {
        File daten2 = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Akif_Malik\\week02\\UserInput_StringEinlesen.java");
        System.out.println("Name : " +  daten2.getName());
        System.out.println("Länge der datei : " + daten2.length());
        System.out.println("Ist es ein file : " + daten2.isFile());
        System.out.println("Ist es ein Directory : " + daten2.isDirectory());
        System.out.println("existiert : " + daten2.exists());

        System.out.println();
        System.out.println(Arrays.toString(daten2.listFiles()));
        System.out.println();



    }
}
