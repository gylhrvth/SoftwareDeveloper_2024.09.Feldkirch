package Erik.week06;

import java.io.File;
import java.util.Arrays;

public class FilesExample {
    public static void main(String[] args) {

        File target = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Erik\\week01");

        System.out.println("Name des Ziels:   >> " + target.getName());
        System.out.println("Größe des Ziels:  >> " + target.length());
        System.out.println("ist Ordner?       >> " + target.isDirectory());
        System.out.println("ist Datei?        >> " + target.isFile());
        System.out.println("Existiert?        >> " + target.exists());


        File[] content = target.listFiles();
        System.out.println("\nAusgabe vom Inhalt des Pfades");
        System.out.println(Arrays.toString(content));
    }
}
