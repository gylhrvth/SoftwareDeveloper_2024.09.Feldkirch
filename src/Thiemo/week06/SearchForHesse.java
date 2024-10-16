package Thiemo.week06;

import Sandro.Colors;
import data.Texts;


public class SearchForHesse {
    public static void main(String[] args) {

        String text = Texts.HESSE;
        System.out.println(text);
        System.out.println();

        String targetWord = "Hesse";
        System.out.println("Count occurences from word " + targetWord + " = " + countoccurences(text, targetWord));
        System.out.println();

        printIndexPositions(text, targetWord);
        System.out.println();

        String upperWord = text.replace(targetWord, Colors.COLORS[1]+ targetWord.toUpperCase()+Colors.RESET);
        System.out.println(upperWord);
    }

    public static int countoccurences(String text, String targetWord) {
        int count = 0;

        for (int i = 0; i <= text.length() - targetWord.length(); i++) {
            String currentsubString = text.substring(i, i + targetWord.length());
            if (currentsubString.equals(targetWord)) {
                count++;
            }
        }
        return count;
    }

    public static void printIndexPositions(String text, String targetWord) {
        for (int index = text.indexOf(targetWord);
             index >= 0;
             index = text.indexOf(targetWord, index + 1)) {
            System.out.printf("The Index Positions are : %5d\n",index);

        }
    }
}







