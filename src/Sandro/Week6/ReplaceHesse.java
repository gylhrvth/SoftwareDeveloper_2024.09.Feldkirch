package Sandro.Week6;

import Sandro.Colors;
import data.Texts;

import java.util.Scanner;

public class ReplaceHesse {
    public static void main(String[] args) {

        //replaceWordHesseUserInput();

        replaceHermannsIdentity();


    }
    public static void replaceWordHesseUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a Word to repalce...");
        String userInputTarget = sc.nextLine();
        System.out.println("Choose a Word that replace the Target...");
        String userInputReplace = sc.nextLine();
        String text = Texts.HESSE;
        String target = userInputTarget;
        String replace = Colors.COLORS[2] + userInputReplace + Colors.RESET;
        String newText = text.replace(target, replace);
        System.out.println(newText);
    }

    public static void replaceHermannsIdentity() {
        String text = Texts.HESSE;

        String target = "Hermann";
        String target2 = "Hesse";

        String replace = Colors.COLORS[2] + "Sandro" + Colors.RESET;
        String replace2 = Colors.COLORS[1] + "Boso" + Colors.RESET;

        String newText = text.replace(target, replace);
        String newText2 = newText.replace(target2, replace2);

        System.out.println(newText2);
    }
}
