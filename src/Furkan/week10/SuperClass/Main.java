package Furkan.week10.SuperClass;

public class Main {
    public static void main(String[] args) {
        Lebewesen lebewesen = new Lebewesen("Lebewesen name" , 5);
        lebewesen.eat();
        lebewesen.sleep();


        Tier tier = new Tier("Tiername" , 5 , "Reptillie");
        tier.eat();
        tier.die();



        Mensch mensch = new Mensch("Male", "Herbert", 31);
        mensch.humanThings();



        Hund hund = new Hund("Oggy" , 6 , "Kangal");
        hund.spieltMitBall();





    }
}
