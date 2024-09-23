package Thiemo.week02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Benutzereingabe {
    public static void main(String[] args) {
//        String ok = "";
        String name = "";
        String ort = "";
        int alter = 0;


//        System.out.println("Hallo, wie lautet dein Name");
        name = einlesen("Hallo, wie lautet dein Name?");
        System.out.println();
//        ok = einlesen("Was geht " + name + "?");
//        System.out.println();
//        System.out.println("ok cool!");
//        System.out.println();
//        System.out.println("Wohnort");
        ort = einlesen("Wo bist du Zuhause?");
        System.out.println();
//        System.out.println("ok");
        System.out.println();
//        System.out.println("alter?");
        alter = einlesen2("Wie alt sind Sie?", 0, 100);
        if (alter < 2) {
            System.out.print("Congratulations " + name + " you survived for " + alter + " year!");
        } else {
            System.out.println("Congratulations " + name + " you survived for " + alter + " years!");
        }


    }


    public static String einlesen(String userinfo) {

        System.out.println(userinfo);

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        return sc.nextLine();

    }

    public static int einlesen2(String userinfo, int minValue, int maxValue) {

        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean richtigeEingabe = false;
        // while (richtinge eingabe == false),
        while (!richtigeEingabe) {
            try {
                System.out.println(userinfo);
                String hilfsText = sc.nextLine();
                number = Integer.parseInt(hilfsText);
//                number = sc.nextInt();
                if (number >= minValue && number <= maxValue) {
                    richtigeEingabe = true;
                } else {
                    System.out.println("Versuchs von " + minValue+ " bis " + maxValue + "\n"/*+userinfo*/);
                }

            }catch (NumberFormatException nfe)
//            catch (InputMismatchException ime)
            {
                System.out.println("Fail! Maybe try a Number/Something else? " + " \n " +/*ime*/ "\n"/*+userinfo*/);
//                sc.nextLine();
            }
        }
        return number;
    }

}


