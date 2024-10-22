package Akif_Malik.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


public class Loggings {

    private static final String FILE_PATH = "assets/tmp/logs.txt";
    private static final long MAX_SIZE = 1024 * 1024;

    public static void log(int severity, String message) {
        renameOversizedLog();
        try {
            File file = new File(FILE_PATH);
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream ps = new PrintStream(fos);

            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat formatter2 = new SimpleDateFormat("EEEE, dd. MMMM yyyy, HH:mm ");

            if (severity == 1) {
                ps.println(formatter2.format(gc.getTime()) + " ERROR: " + message);
            } else if (severity == 2) {
                ps.println(formatter2.format(gc.getTime()) + " WARNING: " + message);
            } else if (severity == 3) {
                ps.println(formatter2.format(gc.getTime()) + "INFO: " + message);
            }
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());

        }
    }

    private static void renameOversizedLog(){
        File file = new File(FILE_PATH);
        if (file.exists() && file.length() > MAX_SIZE){
            File oldFile = new File(file.getAbsolutePath() + ".old");
            oldFile.delete();
            file.renameTo(oldFile);
        }
    }
}

