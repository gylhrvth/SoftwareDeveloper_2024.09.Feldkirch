package Gyula.week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

public class ReadFileFromRessources2 {
    public static void main(String[] args) {
        Reader reader = new InputStreamReader(Objects.requireNonNull(ReadFileFromRessources2.class.getClassLoader().getResourceAsStream("txt/simpleText.txt")));
        BufferedReader bufferedReader = new BufferedReader(reader);

        try {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
