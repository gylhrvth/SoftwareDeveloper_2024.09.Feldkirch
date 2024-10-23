package Erik.week07;

import Erik.week06.DatenTabbellarischTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class DatenTabellarischDartellen {
    public static void main(String[] args) {
        try {
            File path = new File("assets/tmp/output.txt");
            path.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(path, false); //Datei wird erstellt
            PrintStream ps = new PrintStream(fos);

            ps.println(">>Daten Tabellarisch abgespeichert<<\n");
            printFormat(ps);

            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void printFormat(PrintStream ps) {

        String[] firstName = {"Alfonso", "Beatrix-Eleonor", "Cecil", "Daniel", "Elmar"};
        String[] lastName = {"Klein", "Kinderdorfer", "Al Elmenar", "Schmidt", "Simma"};
        int[] age = {40, 78, 5, 18, 81};
        String[] place = {"Wien", "Schwarzach", "Wiener Neudorf", "Sankt Pölten", "Sankt Pölten"};
        float[] distanceFromCapital = {0f, 654.4f, 12.457634366f, 120.0f, 119.9999f};

        String[] headLine = new String[]{"First Name", "Last Name", "Age", "Place", "Distance from Capital"};
        int ageSize = DatenTabbellarischTest.formatIntSize(headLine[2], age);
        int firstNameSize = DatenTabbellarischTest.formatStringSize(headLine[0], firstName);
        int lastNameSize = DatenTabbellarischTest.formatStringSize(headLine[1], lastName);
        int placeSize = DatenTabbellarischTest.formatStringSize(headLine[3], place);
        int distanceSize = DatenTabbellarischTest.formatFloatSize(headLine[4], distanceFromCapital);

        // Kopfzeile
        ps.println("╔═" + "═".repeat(firstNameSize) + "═╦═" + "═".repeat(lastNameSize) + "═╦═" + "═".repeat(ageSize) + "═╦═" + "═".repeat(placeSize) + "═╦═" + "═".repeat(distanceSize) + "═╗");
        ps.printf("║ %-" + firstNameSize + "s ║ %-" + lastNameSize + "s ║ %" + ageSize + "s ║ %-" + placeSize + "s ║ %" + distanceSize + "s ║" + "\n", headLine[0], headLine[1], headLine[2], headLine[3], headLine[4]);
        ps.println("╚═" + "═".repeat(firstNameSize) + "═╩═" + "═".repeat(lastNameSize) + "═╩═" + "═".repeat(ageSize) + "═╩═" + "═".repeat(placeSize) + "═╩═" + "═".repeat(distanceSize) + "═╝");

        // Tabelle
        ps.println("╔═" + "═".repeat(firstNameSize) + "═╦═" + "═".repeat(lastNameSize) + "═╦═" + "═".repeat(ageSize) + "═╦═" + "═".repeat(placeSize) + "═╦═" + "═".repeat(distanceSize) + "═╗");
        for (int i = 0; i < firstName.length; i++) {
            ps.printf("║ %-" + firstNameSize + "s ║ %-" + lastNameSize + "s ║ %" + ageSize + "d ║ %-" + placeSize + "s ║ %" + distanceSize + ".4f ║", firstName[i], lastName[i], age[i], place[i], distanceFromCapital[i]);
            ps.println();
            if (i < firstName.length - 1) {
                ps.println("╠═" + "═".repeat(firstNameSize) + "═╬═" + "═".repeat(lastNameSize) + "═╬═" + "═".repeat(ageSize) + "═╬═" + "═".repeat(placeSize) + "═╬═" + "═".repeat(distanceSize) + "═╣");
            }
            if (i == firstName.length - 1) {
                ps.println("╚═" + "═".repeat(firstNameSize) + "═╩═" + "═".repeat(lastNameSize) + "═╩═" + "═".repeat(ageSize) + "═╩═" + "═".repeat(placeSize) + "═╩═" + "═".repeat(distanceSize) + "═╝");
            }
        }
    }
}
