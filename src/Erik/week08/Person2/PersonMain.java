package Erik.week08.Person2;

import java.util.Vector;

public class PersonMain {
    public static void main(String[] args) {

        // Objekt erstellen
        Vector<Person> people = Person.generateRandPeople(10);
        Person minAge = Person.getMinAge(people);
        Person maxAge = Person.getMaxAge(people);
        int avgAge = Person.getAvgAge(people);

        Person minHeight = Person.getMinHeight(people);
        Person maxHeight = Person.getMaxHeight(people);
        int avgHeight = Person.getAvgHeight(people);

        Person minWeight = Person.getMinWeight(people);
        Person maxWeight = Person.getMaxWeight(people);
        int avgWeight = Person.getAvgWeight(people);

        // Methoden Aufrufe
        Person.printAllPeople(people);
        System.out.println("-".repeat(120));
        System.out.println("Die Jüngste Person ist: >> " + minAge);
        System.out.println("-".repeat(120));
        System.out.println("Die Älteste Person ist: >> " + maxAge);
        System.out.println("-".repeat(120));
        System.out.println("Das durchschnittliche Alter der Personen beträgt: >> " + avgAge + " Jahre");
        System.out.println("-".repeat(120));
        System.out.println("Die kleinste Person ist: >> " + minHeight);
        System.out.println("-".repeat(120));
        System.out.println("Die größte Person ist: >> " + maxHeight);
        System.out.println("-".repeat(120));
        System.out.println("Die durchschnittliche Größe der Personen beträgt: >> " + avgHeight + " cm");
        System.out.println("-".repeat(120));
        System.out.println("Die schlankeste Person ist: >> " + minWeight);
        System.out.println("-".repeat(120));
        System.out.println("Die fetteste Person ist: >> " + maxWeight);
        System.out.println("-".repeat(120));
        System.out.println("Das durchschnittliche Gewicht der Personen beträgt: >> " + avgWeight + " kg");
        System.out.println("-".repeat(120));
    }
}