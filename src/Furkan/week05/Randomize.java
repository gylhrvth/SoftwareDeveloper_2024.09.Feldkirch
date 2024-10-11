package Furkan.week05;

import java.util.Random;

public class Randomize {
    public static void main(String[] args) {
        String inputText = "Fenerbahce";
        String randomizeText = randomText(inputText);
        System.out.println(randomizeText);
    }

    public static String randomText(String text) {
        char[] charArray = text.toCharArray();
        char[] randomArray = new char[charArray.length];
        Random random = new Random();
        boolean[] used = new boolean[charArray.length];


        for (int i = 0; i < charArray.length; i++) {
            int index = random.nextInt(charArray.length);

            while (used[index]) {
                index = random.nextInt(charArray.length);
            }
            randomArray[i] = charArray[index];
            used[index] = true;

        }
        return new String(randomArray);
    }

}
