package Erik.week07;

import java.io.*;
import java.util.Scanner;

public class BonusFilesLesenUndSchreiben_New {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hallo!");
        String userName = getNameFromUser("Please enter your Name");
        int account = readAccountState(userName);
        account = transaction(account);
        writeAccountState(userName, account);
    }

    public static String getNameFromUser(String userInfo) {
        System.out.println(userInfo);
        return sc.nextLine();
    }

    public static int readAccountState(String name) {
        File path = givePath(name);
        int result = 100;
        if (path.exists() && path.isFile()) {                                       // wenn der Pfad exisitert UND eine Datei ist, soll ... passieren
            try {
                FileInputStream fis = new FileInputStream(path);                    // Liest mit Bytes aus.
                Scanner sc = new Scanner(fis);
                if (sc.hasNext()) {                                                 // läuft, solange bis er nichts mehr in der Datei lesen kann
                    String accountValueAsText = sc.nextLine();
                    result = Integer.parseInt(accountValueAsText);
                }
            } catch (FileNotFoundException fnfe) {
                System.out.println(fnfe.getMessage());
            }
        } else {                                                                    // Wenn kein Account mit dem Namen existiert dann kommt "else"
            System.out.printf("Welcome %s! Thanks for using our Bank ", name);
        }
        return result;
    }

    public static int transaction(int oldAccState) {
        System.out.printf("Your current Account Value is >> %d€ <<\n", oldAccState);
        int value = Gyula.ConsoleTools.readNumber("What kind of transaction do you want to execute?", -50000, 50000);
        int newAccState = oldAccState + value;
        System.out.printf("Your current Account Value is >> %d€ <<:\n", newAccState);
        return newAccState;
    }

    public static void writeAccountState(String name, int currentAccState) {
        File writePath = givePath(name);                                           // File namens "writePath" wird mit dem Ergebnis von der Methode givePath erstellt
        try {
            FileOutputStream fos = new FileOutputStream(writePath, false);  // Öffnet die File der wert "false" gibt an das die File nach jedem durchlauf erneut überschrieben wird.
            PrintStream ps = new PrintStream(fos);                                 // Ermöglicht das geschriebene in einer anderen Datei aus, zu geben und nicht wie im normalen "Sout" in die Console aus, zu geben
            ps.println(currentAccState);                                           // Fügt den "currentAccState" Wert in die Datei ein.
            ps.close();                                                            // Schließt die Eingabe in das Programm und das Programm selbst
            System.out.println("Account State refreshed");
        } catch (FileNotFoundException fnfe) {
            System.out.println("Can't save Account");
        }
    }

    public static File givePath(String name) {
        File filePath = new File("assets/bank/" + name.toLowerCase() + ".txt"); // Erstellt eine File mit dem Pfad Namen
        filePath.getParentFile().mkdirs();                                               // Erstellt das Verzeichnis, nachdem der Pfad benannt ist
        return filePath;
    }

}
