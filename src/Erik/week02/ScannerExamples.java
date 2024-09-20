package Erik.week02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerExamples {
    public static void main(String[] args) {

        String text = " ";          //  String "text" leer definiert.
        int number = 0;             //  Variable "number" definiert mit "0".
       // number = giveNumb("Please, give me a Number between 1 to 100", 1, 100);        //  Variable "number" => Den Wert der bei der Methode Zurück gegeben wird.
       // System.out.println(number); //  Print vom aktuell eingespeisten.
      //  number = giveNumb2("Give me a Number between 200-400", 200, 400);
      //  System.out.println(number);
    }

    public static int giveNumb(String msg, int minValue, int maxValue) {      // Int Methode wird erstellt, (mit Werten außerhalb der Methode "int number, String msg").
        //     System.out.println(msg);                            // Printet die oben genannte Message, dass der User weiß, was er machen muss.
        int number = 0;
        Scanner sc = new Scanner(System.in);                // Neuer Scanner mit dem Namen "sc" angelegt.
        boolean validNumber = false;

        while (validNumber == false) {                      // while Schleife läuft unendlich durch wen der "validNumber" falsch ist

            try {                                           // Wen die validNumber falsch ausgibt
                System.out.println(msg);
                number = sc.nextInt();

                if (number >= minValue && number <= maxValue) {
                    System.out.println("Your Number is in the Range");
                } else {
                    System.out.println("Your Number is out of range. It needs to be between 1-100.");
                }

                // validNumber = true;                         //Ist "validNumber" true dann führt er die while Schleife nicht aus

            } catch (
                    InputMismatchException ime) {          //"InputMismatchExpection" ist der Fehlercode wo ausgegeben wird, wen das Programm crasht // Catch wird nur dann ausgeführt, wen alles außer eine zahl eingegeben wird
                System.out.println("The Error was " + ime);
                System.out.println("Please, activate your Brain and start to think!");
                //     System.out.println(msg);
            }
            //  System.out.println(msg);
            sc.nextLine();                                  //Scanner wird erneut aufgerufen und somit stoppt es die unendlich laufende while Schleife
        }
        return number;                                          // Der Rückgabewert "number" wird zurückgegeben.
    }


    public static int giveNumb2(String msg, int min, int max) {      // Int Methode wird erstellt, (mit Werten außerhalb der Methode "int number, String msg").
        //     System.out.println(msg);                            // Printet die oben genannte Message, dass der User weiß, was er machen muss.
        int number = 0;
        Scanner sc = new Scanner(System.in);                // Neuer Scanner mit dem Namen "sc" angelegt.
        boolean validNumber = false;

        while (validNumber == false) {                      // while Schleife läuft unendlich durch wen der "validNumber" falsch ist

            try {                                           // Wen die validNumber falsch ausgibt
                System.out.println(msg);
                String tempText = sc.nextLine();
                number = Integer.parseInt(tempText);

                if (number >= min && number <= max) {
                    System.out.println("Your Number is in the Range");
                    validNumber = true;
                } else {
                    System.out.println("Your Number is out of range. It needs to be between 200-400.");
                }

                // validNumber = true;                         //Ist "validNumber" true dann führt er die while Schleife nicht aus

            } catch (Exception exp) {          //"Exception exp" ist der Fehlercode wo ausgegeben wird, wen das Programm crasht // Catch wird nur dann ausgeführt, wen alles außer eine zahl eingegeben wird
            //    System.out.println("The Error was " + ime);
                System.out.println("Please, activate your Brain and start to think!");
                     System.out.println(msg);
            }
            //  System.out.println(msg);
            sc.nextLine();                                  //Scanner wird erneut aufgerufen und somit stoppt es die unendlich laufende while Schleife
        }
        return number;                                          // Der Rückgabewert "number" wird zurückgegeben.


    }
}
















