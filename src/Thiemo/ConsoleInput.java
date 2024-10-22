package Thiemo;

import java.util.Scanner;

public class ConsoleInput {

    public static int readNumber(String userinfo, int minValue, int maxValue) {

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




    public static float readNumberfloat(String userinfo, float minValue, float maxValue) {

        float number = 0;
        Scanner sc = new Scanner(System.in);
        boolean richtigeEingabe = false;
        // while (richtinge eingabe == false),
        while (!richtigeEingabe) {
            try {
                System.out.println(userinfo);
                String hilfsText = sc.nextLine();
                number = Float.parseFloat(hilfsText);
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


