package Erik.week06;

import java.io.File;

public class FileDateienZaehlenUndSummieren {
    public static void main(String[] args) {

        File target = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Erik\\week06");
        File[] content = target.listFiles();
        printList(content);
        kp(content);


    }

    public static void printList(File content[]) {
        for (File file : content) {
            System.out.printf("Name: >> %-35s | Size: >> (%4s)\n", file.getName(), file.length());
        }
        System.out.println("-----------------------------------------------------------");
    }

    public static void kp(File content[]) {
        int numberOfData = 0;
        long wholeDataSize = 0;

        if (content != null) {
            for (File datei : content) {
                if (datei.isFile()) {
                    numberOfData++;
                    wholeDataSize += datei.length();
                }
            }
        }
        System.out.println(numberOfData + " Dateien sind vorhanden.");
        System.out.println("Die Dateien sind " + wholeDataSize + " groß.");
    }

}
