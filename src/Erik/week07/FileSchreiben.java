package Erik.week07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class FileSchreiben {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            File filePath = new File("assets/tmp/output.txt");
            filePath.getParentFile().mkdirs();                                      // append false datei wird immer wieder überschrieben | bei true wird weiter geschrieben
            FileOutputStream fos = new FileOutputStream(filePath, false);   // Öffnet die File
            PrintStream ps = new PrintStream(fos);

            userInput(ps,"Gib was ein.\nWenn du nichts mehr eingeben willst drücke Enter");
            ps.close();                                                            // Schließt Programm
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }
    }

    public static void userInput(PrintStream ps, String userInfo) {
        boolean empty = false;
        System.out.println(userInfo);

        while(!empty){
            String userInput = sc.nextLine();
            ps.println(userInput);
            if (userInput.equals("")){
                empty = true;
            }
        }
    }
}
