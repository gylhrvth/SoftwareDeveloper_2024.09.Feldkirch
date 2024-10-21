package Thiemo.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class WriteFile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        InputStream inputStream = Objects.requireNonNull(PrintCharacters.class.getClassLoader().getResourceAsStream("txt/simpleText.txt"));
//        Reader reader = new InputStreamReader(Objects.requireNonNull(PrintCharacters.class.getClassLoader().getResourceAsStream("txt/simpleText.txt")));
//        Scanner scanner = new Scanner(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(reader);



        try {
            File file = new File("assets/tmp/output.txt.");
            file.getParentFile().mkdirs();
//            System.out.println(file.getAbsolutePath());
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream ps = new PrintStream(fos);

            String userinput = "X";
            System.out.println("Write something:(to get out write a emptyLine)");
            while (!userinput.isEmpty()) {
                userinput = sc.nextLine();
                printSomething(ps, userinput);

            }
            ps.println("System closed at:");
            ps.printf("%1$tY.%1$tm.%1$te. %1$tH:%1$tM:%1$tS \n", new GregorianCalendar().getTime());
            ps.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void printSomething(PrintStream ps, String userinput) {

        ps.printf("%1$tY.%1$tm.%1$te. %1$tH:%1$tM:%1$tS \n", new GregorianCalendar().getTime());
        ps.println(userinput);


    }
}
