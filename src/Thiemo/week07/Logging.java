package Thiemo.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Logging {
    public static void main(String[] args) {

        log(1,"Fatal error");
        log(2,"No suitable task available");
        log(3,"Hi");
    }
    public static void log(int severity, String msg){


        File file = new File("assets/log/output.txt");
        file.getParentFile().mkdirs();

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
        String timestamp = sdf.format(gc.getTime());

        String severityLabel = "unknown";
        if (severity == 1) {
            severityLabel = "ERROR";
        } else if (severity == 2) {
            severityLabel = "WARNING";
        } else if (severity == 3) {
            severityLabel = "INFO";
        }

        String logMsg = timestamp +" "+ severityLabel +": " + msg;

        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream ps = new PrintStream(fos);
            ps.println(logMsg);
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: Unable to save log to file. Please check the file path.");
        }


    }
}
