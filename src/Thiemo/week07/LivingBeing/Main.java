package Thiemo.week07.LivingBeing;

public class Main {
    public static void main(String[] args) {

        // Erstellen von zwei Person-Objekten
        Person person0 = new Person(175,55,"OG",60);
        Person person1 = new Person(150,66,"MC",45);

        // Ausgabe der Objekte
        System.out.println(person0);
        System.out.println("BMI von " + person0.getName() + ": " + person0.calculateBMI()+" Kg/m 2");
        System.out.println(person1);
        System.out.println("BMI von " + person1.getName() + ": " + person1.calculateBMI()+" Kg/m 2");
    }
}