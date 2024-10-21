package Erik.week07;

import java.io.*;
import java.util.Scanner;

/*
            Todo:   1. Scanner erstellen ♥
                    2. User nach dem namen fragen und ergebnis speichern ♥
                    3. eingegebenen namen in dateipfad initialisieren. ♥
                    4. Abfragen ob es dieses verzeichnis existent ist.
                    5. mit dem Scanner txt Datei auslesen. (sc.hasNext() in while schleife)
                    6.
 */

public class BonusFileLesenUndSchreiben_Old {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String name = askForName("Please Enter your Name");
        File filePath = new File("assets/bank/" + name);

        checkForExistence(filePath);

        try {
            filePath.getParentFile().mkdirs();
            FileOutputStream fos = new FileOutputStream(filePath, false); //Datei wird erstellt
            PrintStream ps = new PrintStream(fos);

            kontoAuslesen(name);

            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static String askForName(String userInfo) {
        System.out.println(userInfo);
        return sc.nextLine();
    }

    public static void checkForExistence(File path) {

        if (path.exists()) {
            System.out.println("Konto existiert bereits");
        } else {
            try {
                FileOutputStream fosT = new FileOutputStream(path,false);
                PrintStream psT = new PrintStream(fosT);
                psT.println("Als neuer Kunde erhalten sie:\n>> 100€ Guthaben");
            }catch (FileNotFoundException fnfe){
                System.out.println(fnfe.getMessage());
            }
        }
    }

    public static void kontoAuslesen(String name) {
        try {
            FileInputStream fis = new FileInputStream("assets/bank/" + name);
            Scanner scanner = new Scanner(fis);

            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                System.out.println(text);
            }
            scanner.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }



}


//            File filePathTest = new File("assets/bank" + name);
//            FileOutputStream fosTest = new FileOutputStream(filePathTest, false);
//            PrintStream psTest = new PrintStream(fosTest);

//            System.out.println("100€ Guthaben"); // test
//            System.out.println("Als neuer Kunde erhalten sie:\\n>> 100€ Guthaben"); // test