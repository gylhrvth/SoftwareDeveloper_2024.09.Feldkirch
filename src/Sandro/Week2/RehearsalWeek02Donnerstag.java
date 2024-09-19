package Sandro.Week2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RehearsalWeek02Donnerstag {
    public static void main(String[] args) {
        /*
        String name = "";
        String ort = "";
        // text, und aufruf der methode
        name = readString("Welcome, please enter your Name.");
        System.out.println("Good morning " + name + "!");
        ort = readString("Where do you live?");
        System.out.println("You are from ... " + ort);
         */
        int age = 0;
        age = readNumberVersion4("How old are You?",1,100);
        System.out.println("ahh, you are " + age + " years old!");
    }

    //String reader
    public static String readString(String userInfo) {                           //Funktion mit rückgabewert (String), gibt String...
        System.out.println(userInfo);
        String scannerInput = "";                                                //Variable erstellt, bennant, erstmal leer.
        Scanner scannerName = new Scanner(System.in);                            //Scanner
        scannerInput = scannerName.nextLine();                                   //?
        return scannerInput;                                                     //retrun
    }

    //Int reader
    public static int readNumberVersion1(String msg) {
        System.out.println(msg);
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean validNumber = false;

        while (validNumber == false){
            try{
                number = sc.nextInt();          //do war des problem!!!
                validNumber =true;
            }catch(InputMismatchException ime){
                System.out.println("Der fehler war = "+ime);
                System.out.println("HEy, da ist was schief gelaufen!!!");
            }
        }

        return number;
    }

    public static int readNumberVersion2(String msg, int minValue, int maxValue) {

        System.out.println(msg);                        //gibt es nun einen besseren platz für die Print msg line? Was ist das Problem was hier entsteht?
        int number = 0;                                 //variable Integer erstellen
        boolean validNumber = false;                    //boolean true false für die while schleife
        Scanner sc = new Scanner(System.in);            //scanner erstellen
        while (!validNumber) {                           //while schleife läuft solange, (validnumber nicht true) = !validnumber ist

            try {
                number = sc.nextInt();
                //sc.nextLine();                           //read next line, für Repeat, teste was passiert wenn die zeile nicht aktiv ist!
                validNumber = true;

            } catch (Exception exp) {                   //Eine Exception ist "geworfen" worden, wir "fangen" sie hier ab.
                //System.out.println("was ist passiert = " + exp);
                System.out.println("Du bist Dumm!!!");
                sc.nextLine();
            }
        }

        return number;
    }


    //Min Max value check
    public static int readNumberVersion3(String msg, int min, int max) {             //Exception Try Catch block
        int number = 0;                                                              //Input Mismatch Exception
        Scanner sc = new Scanner(System.in);                                         //Repeat process with While
        boolean NumberIsValid = false;

        while (!NumberIsValid) {
            try {
                System.out.println(msg);
                number = sc.nextInt();
                sc.nextLine();                                                      //Read the next input with sc.nextLine to repeat
                if (number >= min && number <= max) {                                 //Check if the number is in Range from min max
                    NumberIsValid = true;
                } else {
                    System.out.println("Input Number must be between " + min + " and " + max);
                }
            } catch (InputMismatchException ime) {
                System.out.println("Sorry,that was not a Valid number");
                sc.nextLine();
            }


        }
        return number;
    }




    //do it with a string convert into an int
    public static int readNumberVersion4(String msg, int min, int max) {             //Exception Try Catch block
        int number = 0;                                                              //Input MismatchException wird zu NumberFormatException ACHTUNG code im CatchBlock ändern!!!
        Scanner sc = new Scanner(System.in);                                         //Repeat process with While
        boolean NumberIsValid = false;
        while (!NumberIsValid) {
            try {
                System.out.println(msg);
                String tempText = sc.nextLine();                                      //Read the input as a String!
                number = Integer.parseInt(tempText);                                  //Parse the String into an Integer!
                if (number >= min && number <= max) {                                 //Check if the number is in Range from min max
                    NumberIsValid = true;
                } else {
                    System.out.println("Input Number must be between " + min + " and " + max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Sorry,that was not a Valid number");
                //sc.nextLine();                                                       //dont need next.line, to read the input Try what is the difference
            }
        }
        return number;
    }


}
