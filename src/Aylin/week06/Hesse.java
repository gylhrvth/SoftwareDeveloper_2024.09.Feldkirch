package Aylin.week06;

import Sandro.Colors;

import java.util.Scanner;

public class Hesse {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String text = data.Texts.HESSE;
        System.out.println(text);
//        hesse(text);
//        hesse2(text);
        hesseReplaceName(text);
    }

//    public static int countWord(String text){
//        int count = 0;
//        String specWord = "Hesse";
//        String[] wprd
//        for (String word : words){
//            if(word.equalsIgnoreCase(specWord)){
//                count++;
//            }
//        }
//        return count;
//    }

    public static void hesse(String text){
        String search = "Hesse";
        int indexOf = text.indexOf(search);
        int counter = 0;

        while(indexOf != -1){
            counter++;
            int newIndex = indexOf+1;
            indexOf = text.indexOf(search, newIndex);
        }
        System.out.println(counter);
    }

    public static void hesse2(String text){
        String searchFor = "Hesse";
        String upperWord = text.replace(searchFor, Colors.COLORS[1]+ searchFor.toUpperCase()+Colors.RESET);
        System.out.println(upperWord);
    }

    public static void hesseReplaceName(String text){
        System.out.print("Which word do you want to replace? ");
        String searchFor = sc.nextLine();
        System.out.print("Which word do you want to have? ");
        String replaceName = text.replace(searchFor, Colors.COLORS[6]+ sc.nextLine() +Colors.RESET);
        System.out.print("Which word do you want to replace? ");
        String searchForAnotherWord = sc.nextLine();
        System.out.print("Which word do you want to have? ");
        String replaceSurname = replaceName.replace(searchForAnotherWord, Colors.COLORS[4]+ sc.nextLine() +Colors.RESET);
        System.out.print(replaceSurname);
    }
}

