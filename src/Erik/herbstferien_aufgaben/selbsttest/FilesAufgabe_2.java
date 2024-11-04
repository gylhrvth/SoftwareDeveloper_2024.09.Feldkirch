package Erik.herbstferien_aufgaben.selbsttest;

import java.io.File;

/*
Liste die Dateien in folgender Rheinfolge auf.
1. Unterverzeichnisse
2. Dateien nach Größe absteigend
 */

public class FilesAufgabe_2 {
    public static void main(String[] args) {

        File path = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Erik\\herbstferien_aufgaben");
        File[] content = path.listFiles();
        System.out.println("Unsortiert:\n---");
        printList(content);
        System.out.println("---");
        System.out.println("Sortiert:\n---");
        orderFiles(content);
        printList(content);

    }

    public static void printList(File[] content) {
        for (File f : content) {
                //System.out.printf("Name: >> %-35s / Size: >> %-4d\n", f.getName(), f.length());
                if (f.isDirectory()){
                    System.out.printf("Name:Ordner >> %-35s / Size: >> %-4d\n", f.getName(), f.length());
                } else {
                    System.out.printf("Name:Datei  >> %-35s / Size: >> %-4d\n", f.getName(), f.length());
                }
        }
    }

    // 1.Teil Datei  | 2.Teil Datei; length nach größe sortieren
    // 1.Teil Datei  | 2.Teil Ordner
    // 1.Teil Ordner | 2.Teil Ordner
    // 1.Teil Ordner | 2.Teil Datei
    // 1.Teil Ordner | 2.Teil Ordner; compareTo lexio sortieren
    // Files sortieren hab ich nachgeschaut
    public static void orderFiles(File[] content) {
        for (int i = 0; i < content.length; i++) {
            for (int j = 0; j < content.length - 1 - i; j++) {
                if (content[j].isFile() && content[j + 1].isFile() && content[j].length() < content[j+1].length() ||
                        content[j].isFile() && content[j + 1].isDirectory() ||
                        content[j].isDirectory() && content[j + 1].isDirectory() && content[j].compareTo(content[j+1]) > 0 ||
                        content[j].isDirectory() && content[j + 1].isFile()) {
                    File temp = content[j];
                    content[j] = content[j + 1];
                    content[j + 1] = temp;
                }
            }
        }
    }
}
/*
        Pfad erstellen
         erstellten pfad in File[] Array speichern
         Pfad durchgehen
         wenn pfad existiert und ein ordner ist den namen ausgeben vom ordner mit getName
         wenn der pfad exisitert und eine datei ist den namen der datei ausgeben mit getName
         Wenn mehr als eine Datei da ist wird überprüft wie groß die dateien sind und wird geordnet

        System.out.println("Ausgabe des Inhalts des Dateipfades");
        System.out.println(Arrays.toString(content));
 */