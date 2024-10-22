package Aylin.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;

public class Logger {
    public static final int ERROR = 1;
    public static final int WARNING = 2;
    public static final int INFO = 3;

    public static void main(String[] args) {
        log(ERROR, "Alles ist schief");
        log(INFO, "Hallo World!");
        log(WARNING, "Kein passende Aufgabe gefunden!");
    }

    public static void log(int severity, String message) {
        String path = "assets/tmp/log.txt";
        File file = new File(path);

        file.getParentFile().mkdirs();

        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream ps = new PrintStream(fos);
            if (severity == 1) {
                ps.printf("%1$tY.%1$tm.%1$te. %1$tH:%1$tM:%1$tS ERROR: ", new GregorianCalendar().getTime());
                ps.println(message);
            } else if (severity == 2) {
                ps.printf("%1$tY.%1$tm.%1$te. %1$tH:%1$tM:%1$tS WARNING: ", new GregorianCalendar().getTime());
                ps.println(message);

            } else if (severity == 3) {
                ps.printf("%1$tY.%1$tm.%1$te. %1$tH:%1$tM:%1$tS INFO: ", new GregorianCalendar().getTime());
                ps.println(message);
            }
            ps.close();
        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
    }
}
