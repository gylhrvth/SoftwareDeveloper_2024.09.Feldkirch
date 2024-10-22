package Thiemo.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Logging2 {
    public static final int ERROR = 1;
    public static final int WARNING= 2;
    public static final int INFO = 3;

    public static void main(String[] args) {

        log(1, "");
//        log(2, "");
//        log(3, "");
    }

    public static void log(int severity, String msg) {

        File file = new File("assets/log/output.txt");
        file.getParentFile().mkdirs();

        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd. HH:mm:ss");
        String timestamp = sdf.format(gc.getTime());


        String severityLabel = "UNKNOWN";
        if (severity == 1) {
            severityLabel = "ERROR";
        } else if (severity == 2) {
            severityLabel = "WARNING";
        } else if (severity == 3) {
            severityLabel = "INFO";
        }

        String logMessage = timestamp + " " + severityLabel + ": " + msg;

        try {

            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream ps = new PrintStream(fos);
            ps.println(logMessage);
            ps.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: Unable to save log to file. Please check the file path.");
        }
    }
}



