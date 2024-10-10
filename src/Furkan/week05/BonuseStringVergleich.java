package Furkan.week05;

public class BonuseStringVergleich {
    public static void main(String[] args) {

        char[] data = new char[]{'a'};

        String string = new String(data);
        System.out.println(data);

        String text = "Hello Furki";
        char first = text.charAt(0);
        char second = text.charAt(10);

        System.out.println("First: " + first);
        System.out.println("Second: " + second);





        stringText(5);
    //    valueOf();
    }

    public static void stringText(int number) {

        for (int i = 0; i < number; i++) {
            System.out.println('a');
        }
    }

    public static String valueOf(int i) {
        int number = 7;
        number=i;

        String numberString = String.valueOf(number);

        System.out.print("Die Zahl als String: " + numberString);

        return numberString;
    }


    public static void sayHello(int number){
        for (int i = 0; i < number; i++) {


        }


    }


}

