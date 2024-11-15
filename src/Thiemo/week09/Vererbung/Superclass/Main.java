package Thiemo.week09.Vererbung.Superclass;

public class Main {
    public static void main(String[] args) {


//        System.out.println("Create Champion");
//        Champions champion = new Champions("", "");
//        System.out.println();


        System.out.println("\nCreate Champion");
        Champions champion2 = new Mage("Midlane", "Lissandra", 150, 100, "Female", 200);
        System.out.println();


        System.out.println("\nCreate mage");
        Mage mage = new Mage("Midlane", "Orianna", 150, 100, "Female", 200);
        System.out.println();


        System.out.println("\nCreate ADC");
        ADC adc = new ADC("Botlane", "Jinx", 150, 100, "Female", 200);
        System.out.println();

        System.out.println("\nCreate lane");
        Lane bot = new Lane("Botlane");
        System.out.println(bot.getPosition());

        System.out.println("\nCreate Lane");
        Lane mid = new Lane("Midlane");
        System.out.println(mid.getPosition());


        System.out.println("\nCreate Mage");
        Lane top = new Mage("Toplane","Gragas",150,100,"Male",200);
        System.out.println(top.getPosition());

    }
}