package Aylin.week07.home;

public class Main {
    public static void main(String[] args) {
        //Objekt
        Human human1 = new Human("Alex", 47, 175, 74);
        Human human2 = new Human("Ferdi", 25, 174, 69);

        //Methode aufrufen
        human1.satzFormat();
        System.out.println(human1);
        human2.satzFormat();
    }
}
