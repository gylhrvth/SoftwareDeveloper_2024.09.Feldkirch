package Furkan.week06;

import Sandro.Colors;
import data.Texts;

import java.util.Scanner;

public class Hesse {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String text = Texts.HESSE;
        System.out.println(text);
        countHesse(text);
        String highlightedWord= highlightedWord(text, "Hesse");
        System.out.println(highlightedWord);

       replaceWord();
    }

    public static void countHesse(String text) {
        String word = "Hesse";
        int indexOf = text.indexOf(word, 4);

        int counter = 0;
        while (indexOf != -1) {

            System.out.println(Colors.COLORS[4]+ "Hesse found on Index --->" + indexOf + Colors.RESET);
            indexOf = text.indexOf(word, indexOf + 1);
            counter++;
        }
        System.out.println(Colors.COLORS[2]+"Hesse kommt " + (counter + 1) + " mal vor." + Colors.RESET);
    }


    public static String highlightedWord(String text, String word){
        return text.replace(word,word.toUpperCase());


    }


    public static void replaceWord(){

        System.out.println(Colors.COLORS[6]+ "Choose a Word to replace: " + Colors.RESET);
        String userInputTarget=scanner.nextLine();
        System.out.println(Colors.COLORS[6]+"Choose a Word that replace the Target: " + Colors.RESET);
        String userInputReplace=scanner.nextLine();
        String text = Texts.HESSE;
        String target = userInputTarget;
        String replace = Colors.COLORS[5]+ userInputReplace + Colors.RESET;
        String newText = text.replace(target,replace);
        System.out.println(newText);

    }







}
