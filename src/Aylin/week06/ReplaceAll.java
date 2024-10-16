package Aylin.week06;

import org.w3c.dom.ls.LSOutput;

public class ReplaceAll {
    public static void main(String[] args) {
        String text = "Heute wird ein guter Tag! Heute wird ein noch guterer Tag! Heute wird ein spitzen guter Tag!";
        System.out.println("Replace All");
        replaceWord(text);
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Replace All 2");
        deleteLowerChars(text);
        deleteUpperChars(text);
        deleteSpace(text);
        deleteChar(text);
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Replace All 3");
        String num = "749813247132984712039487123049871204398712039487";
        deleteNumbers(num);
    }

    public static void replaceWord(String text){
        String target = "wird";
        System.out.println(text.replace(target, "war"));
        System.out.println(text.replace(target, "ist"));
    }

    public static void deleteLowerChars(String text){
        String textNew = text.replaceAll("[a-z ]+", "");
        System.out.println(textNew);
    }

    public static void deleteUpperChars(String text){
        String textNew = text.replaceAll("[A-Z]", "");
        System.out.println(textNew);
    }

    public static void deleteSpace(String text){
        String textNew = text.replaceAll("[ ]+", "");
        System.out.println(textNew);
    }

    public static void deleteChar(String text){
        String textNew = text.replaceAll("[!]+", "");
        System.out.println(textNew);
    }

    public static void deleteNumbers(String text){
        String textNum = text.replaceAll("[1-3 6-9]", "");
        System.out.println(textNum);
    }
}
