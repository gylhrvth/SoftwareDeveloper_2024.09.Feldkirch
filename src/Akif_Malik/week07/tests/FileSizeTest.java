package Akif_Malik.week07.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileSizeTest {


    private static final String FILE_PATH = "example.txt";
    private static final long MAX_SIZE = 1024 * 1024; // 1 MB

    public static void main(String[] args) {
        try {
            File file = new File(FILE_PATH);
            FileOutputStream fos = new FileOutputStream(file, true); // Append mode

            // Simulate writing data to the file
            for (int i = 0; i < 100; i++) {
                String data = "This is line " + (i + 1) + "\n";
                fos.write(data.getBytes());

                // Check file size and reset if it exceeds 1 MB
                if (file.length() >= MAX_SIZE) {
                    System.out.println("File size exceeded 1 MB. Resetting file...");
                    fos.close();
                    resetFile(file);
                    fos = new FileOutputStream(file, true); // Reopen for appending
                }

                // Sleep for demonstration purposes
                Thread.sleep(100);
            }

            fos.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void resetFile(File file) {
        // Delete the file or create a new empty file
        file.delete(); // Deletes the file
        // Alternatively, you could create a new empty file:
        // try {
        //     file.createNewFile();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}
