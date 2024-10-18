package Sandro.Week6.FileStream;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;

public class FileCheatSheet {
    public static void main(String[] args) {

        File start = new File("C:\\Users\\ossdr\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Sandro");
        File testFile = new File("C:\\Users\\ossdr\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Sandro\\Week1\\FormatString.java");

        System.out.println("Name: "+start.getName());
        System.out.println("Größe: "+start.length());
        System.out.println("ist Ordner: "+ start.isDirectory());
        System.out.println("ist Datei: "+ start.isFile());
        System.out.println("exisitert:" +start.exists());
        System.out.println("absolute Pfad: "+start.getAbsolutePath());

        File[] content = start.listFiles();
        int zahl = gibNummer();

        System.out.println(Arrays.toString(content));
        simplePrint(content);
        sortMyList(content);
        System.out.println("---------- Sort my List ----------");
        simplePrint(content);
        //printFolder(1,target);

        System.out.println("----------------------");
        Path root = Path.of(start.getAbsolutePath());
        System.out.println("Absolute Path von dem Start File ist = "+root);
        Path current = Path.of(testFile.getAbsolutePath());
        System.out.println("Absolute Path von dem aktuellen File ist = "+current);
        Path relative = root.relativize(current);
        System.out.println("Der Relative Path von dem aktuellen File, bezogen auf das Start File ist = "+ relative);




    }
    public static int gibNummer(){
        int numb = 10;


        return numb;
    }

    public static void sortMyList (File [] content){
        //loop-loop the array
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length -i -1; j++) {
                //if  pos1 is Dir && pos0 is File... swap
                //if  pos1 && pos0 is Dir, compare 0 with 1   (> 0 oder <0)
                //if  pos0 is File, pos1 </> pos0
                if(content[j].isFile() && content[j+1].isDirectory()  ||
                   content[j].isDirectory() && content[j+1].isDirectory() && content[j].compareTo(content[j+1]) < 0 ||
                        content[j].isFile() && content[j].length() > content[j+1].length()
                ){
                    //swap File Temp with pos0
                    //swap pos0 with pos1
                    //swap pos1 with temp
                    File temp = content[j];
                    content[j] = content[j+1];
                    content[j+1]= temp;
                }
            }
        }
    }
    public static void createDeleteDirectory(){
        File root = new File("");                       //Root
        File test = new File(root,"TestFolder");            //Child element to root

        if (test.exists()){                                     // check if exist
            System.out.println("Ordner existiert!");
        }else{
            System.out.println("Kein Ordner mit dem Namen gefunden.");
        }
        System.out.println(".... Ordner TestFolder wird erstellt!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //noop
        }
        new File(root, "TestFolder").mkdir();               // create
        if (test.exists()){
            System.out.println("Ordner existiert!");
        }else{
            System.out.println("Kein Ordner mit dem Namen gefunden.");
        }
        System.out.println(".. TestOrdner wird gelöscht!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //noop
        }
        System.out.println(test.getName());
        test.delete();
        if (test.exists()){
            System.out.println("Ordner existiert!");
        }else{
            System.out.println("Kein Ordner mit dem Namen gefunden.");
        }




    }
    public static void simplePrint(File[] content){
        if(content != null){
            for (File f:content
            ) {
                if(f.isFile()){
                    System.out.printf("%-5s :","File");
                }else {
                    System.out.printf("%-5s :","Dir");
                }
                System.out.printf("%-20s Size: [%-5s]\n",f.getName(),f.length());
            }

        }
    }
    public static void printFolder(int indention, File file) {
        printIndention(indention);
        System.out.println(file.getName() + " " + file.length());
        File[] children = file.listFiles();
        if (children != null) {
            for (File child : children) {
                if (child.isDirectory()) {
                    printFolder(indention + 1, child);
                } else {
                    printIndention(indention + 1);
                    System.out.println(child.getName() + " " + child.length());
                }
            }
        }
    }
    public static void printIndention(int indention) {
        for (int i = 0; i < indention; i++) {
            System.out.print("---");
        }
        System.out.print(">");

    }
}
