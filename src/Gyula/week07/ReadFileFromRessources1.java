package Gyula.week07;

import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class ReadFileFromRessources1 {
    public static void main(String[] args) {

        InputStream inputStream = Objects.requireNonNull(ReadFileFromRessources1.class.getClassLoader().getResourceAsStream("txt/simpleText.txt"));
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()){
            String line = scanner.nextLine();
            System.out.println(line);
        }
        scanner.close();
    }
}
