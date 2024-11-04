package Erik.herbstferien_aufgaben.selbsttest;

/*
Mit der Hilfe von java.io.File soll der Inhalt eines bestimmten Verzeichnisses ausgegeben werden.
Gib hierfür eine Liste aller Dateien aus.
 */

import java.io.File;
import java.util.Arrays;

public class FilesAufgabe_1 {
    public static void main(String[] args) {

        // tools: mkdirs? File[]? for i oder for each? getName?

        // File erstellen der den pfadnamen definiert
        // den pfad in ein array speichern das man ihn mit ner schleife auslesen kann
        // in ein File Array machen
        // for each oder for i schleife durch den pfad gehen und alle dateien in diesem pfad ausdrucken

        File path = new File("C:\\Users\\dcv\\IdeaProjects\\SoftwareDeveloper_2024.09.Feldkirch\\src\\Erik\\herbstferien_aufgaben\\selbsttest");
        // File Array größe ist die anzahl der dateien in dem angegeben pfad
        // Wie mittle ich die maximale anzahl aus einem Dateipfad heraus?
        // Files Example angeschaut hab File[] content = new File[] geschrieben undwusste nicht wie ich die größe ermittel
        // File[] test = new File[path.listFiles()]; kann nicht so geschrieben werden
        File[] content = path.listFiles();

        System.out.println("Inhalt des Pfades:");
        System.out.println(Arrays.toString(content));

    }
}
