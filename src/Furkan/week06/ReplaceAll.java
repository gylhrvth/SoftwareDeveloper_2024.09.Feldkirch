package Furkan.week06;

import Sandro.Colors;

public class ReplaceAll {
    public static void main(String[] args) {
        replaceWord();
        replaceRegex();


    }


    public static void replaceWord(){
        String text ="Heute wird ein guter Tag! Heute wird ein noch guterer Tag! Heute wird ein spitzen guter Tag!";
        System.out.println(text);

        String target = "wird";
        String target2 = "war";

        String replace = Colors.COLORS[6] + "war"+Colors.RESET;
        String replace2= Colors.COLORS[5] + "ist" + Colors.RESET;

        String newText = text.replace(target,replace);
        String newText2 = newText.replace(target2, replace2);

        System.out.println(newText);
        System.out.println(newText2);
    }

    public static void replaceRegex(){
        String text = "Heute wird ein guter Tag! Heute wird ein noch guterer Tag! Heute wird ein spitzen guter Tag!";
        String regex = "[a-z]";
        System.out.println(text.replaceAll(regex," "));

        String regex2 = "[A-Z]";
        System.out.println();

    }



}
