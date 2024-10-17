package Furkan.week06;

import Sandro.Colors;

import java.io.File;

public class FilesRekursiv {
    public static void main(String[] args) {

        File search = new File("C:/Users/dcv/IdeaProjects/SoftwareDeveloper_2024.09.Feldkirch/src/Furkan");

        prinSimple(1, search);

    }


    public static void prinSimple(int tabs, File f) {

        System.out.println("-".repeat(tabs * 3) + Colors.COLORS[tabs] + "Ebene(" + tabs + ")" + Colors.RESET + "  |" + f.getName());

        if (f.isFile()) {                //wenn file kein ordner ist...
            return;
        }
        //wenn file ein Ordner ist, dann....
        File[] list = f.listFiles();                     //machen ein liste aus dem file
        if (list != null) {                             //prüfen, ob der ordner leer ist?
            myMagicSort(list);
            for (File file : list) {                      //jedes element von der liste....
                prinSimple(tabs + 1, file);
            }

        }

        //ordner geöffnet, durchgearbeitet...
    }


    public static int summeDatei(){


        return summeDatei();
    }



    public static void myMagicSort(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - i - 1; j++) {
                if (content[j].isFile() && content[j + 1].isDirectory() ||
                    content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j + 1]) > 0 ||
                    content[j].isFile() && content[j+1].isFile() && content[j].compareTo(content[j + 1]) > 0) {
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }

        }
    }
}
