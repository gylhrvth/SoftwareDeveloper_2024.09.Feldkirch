package Akif_Malik.week05;

import java.util.*;

public class StringRandomizer2 {
    public static Random rand = new Random();
    public static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Gebe mir eine Wort: ");
        String userinput = sc1.nextLine();
        String randomized = randomize(userinput);
        System.out.println(randomized);
    }

    public static String randomize(String str) {
        List<Character> characters = Arrays.asList(str.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new));
        Collections.shuffle(characters);
        StringBuilder result = new StringBuilder();
        characters.forEach(result::append);
        return result.toString();
    }
}
