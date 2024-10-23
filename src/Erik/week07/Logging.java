package Erik.week07;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Logging {
    public static void main(String[] args) {
        log(1, "Booom");
    }

    public static void log(int severity, String message) {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {
            logRotation();
            File path = new File("assets/tmp/log.txt");
            path.getParentFile().mkdirs();                                  // Erstellt das Verzeichnis mit dem obigen Pathname
            FileOutputStream fos = new FileOutputStream(path, true); // Öffnet File und überschriebt sie nicht
            PrintStream ps = new PrintStream(fos);                          // ermöglicht zeug in die text dokument zu schreiben

            System.out.println(path.length() + " Bytes"); //test
            String severityInfo = severityLevel(severity);
            ps.print(sdf.format(gc.getTime()) + " ");                       // Datum und Uhrzeit Tag/Monat/Jahr Stunden/Minute/Sekunde
            ps.print(severityInfo + " ");                                         // severity (Status/was ist es?)
            ps.print(message + "\n");

//            System.out.println(path.length() + " Bytes"); //test

            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static String severityLevel(int severity) {
        String severityInfo = "";
        if (severity == 1) {
            severityInfo = "ERROR";
        } else if (severity == 2) {
            severityInfo = "WARNING";
        } else {
            severityInfo = "INFO";
        }
        return severityInfo;
    }

    public static void logRotation() {
        File pathOld = new File("assets/tmp/log.txt");
        File pathNew = new File("assets/tmp/log.txt.old");

        if (pathOld.exists() && pathOld.length() > 60) { // 1048576
            boolean success = pathOld.renameTo(pathNew);
            if (success) {
                System.out.println("umbenannt");
            } else {
                System.out.println("nicht umbenannt");
            }
        }
        if (pathNew.exists() && pathNew.length() > 120) {
            if (pathNew.delete()){
                System.out.println(".old gelöscht");
            }
            pathNew.delete();

            try{
                if (pathOld.createNewFile()){
                    System.out.println("neue datei erstellt");
                }
                pathOld.createNewFile();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }

}



/*

    >>switch ausprobiert mit case und brake<<

        public static void log(int severity, String message) {

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try {
            File path = new File("assets/tmp/log.txt");
            path.getParentFile().mkdirs();                                  // Erstellt das Verzeichnis mit dem obigen Pathname
            FileOutputStream fos = new FileOutputStream(path, true); // Öffnet File und überschriebt sie nicht
            PrintStream ps = new PrintStream(fos);                          // ermöglicht zeug in die text dokument zu schreiben

            switch (severity) {     // prüft den Wert in severity
                case 1:             // Wenn severity Wert "1" hat passiert das ... (wie if/else)
                  String infoFromSeverity = "ERROR";
                    break;          // verhindert die weitere ausführung der andren case blöcke
                case 2:
                    infoFromSeverity = "WARNING";
                    ps.print("WARNING");
                    break;
                case 3:
                    infoFromSeverity = "INFO";
                    ps.print("INFO");
                    break;

            ps.println(sdf.format(gc.getTime()));                       // Datum und Uhrzeit Tag/Monat/Jahr Stunden/Minute/Sekunde
            ps.println("severity = " + severity + " --> " + infoFromSeverity);             // severity (Status/was ist es?)
            ps.println(message + "\n");

            ps.close();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }
 */
