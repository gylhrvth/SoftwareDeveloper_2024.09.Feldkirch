package Erik.week08.Person2;

import java.util.Random;
import java.util.Vector;

public class Person {
    public static Random rand = new Random();

    // Eigenschaften
    private String name;
    private int age;
    private int height;
    private int weight;

    // Konstruktor
    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // Getter/Setter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    // Override toString
    @Override
    public String toString() {
        return String.format("Name: %-20s | Alter: %d Jahre | Größe: %d cm | Gewicht: %3d kg", name, age, height, weight);
    }

    // Methoden
    public static Vector<Person> generateRandPeople(int count) {
        Vector<Person> result = new Vector<>();
        String[] firstName = new String[]{"Erik", "Markus", "Christine", "Fabienne", "Selina", "Lucy", "Manfred", "Olaf", "Günther"};
        String[] lastName = new String[]{"Zimmermann", "Mustermann", "Müller", "Lang", "Kessler", "Horvath", "Raskin", "Konzett"};

        for (int i = 0; i < count; i++) {
            int age = rand.nextInt(15, 90);
            int height = rand.nextInt(160, 210);
            int weight = rand.nextInt(55, 105);
            String fullName = firstName[rand.nextInt(firstName.length)] + " " + lastName[rand.nextInt(lastName.length)];

            result.add(new Person(fullName, age, height, weight));
        }
        return result;
    }

    public static void printAllPeople(Vector<Person> people) {
        for (Person onePerson : people) {
            System.out.println(onePerson);
        }
    }

    public static Person getMinAge(Vector<Person> list) {
        Person result = null;
        for (Person person : list) {
            if ((result == null) || (person.getAge() < result.getAge())) {
                result = person;
            }
        }
        return result;
    }

    public static Person getMaxAge(Vector<Person> list) {
        Person result = null;
        for (Person person : list) {
            if ((result == null) || (person.getAge() > result.getAge())) {
                result = person;
            }
        }
        return result;
    }

    public static int getAvgAge(Vector<Person> list) {
        int sum = 0;
        for (Person p : list) {                 // Liste durchgehen alle alter zusammenrechnen
            sum = sum + p.getAge();
        }
        sum = sum / list.size();                // Summe von Alter dividiert durch die länge der liste
        return sum;
    }

    public static Person getMinHeight(Vector<Person> list) {
        Person result = null;
        for (Person person : list) {
            if ((result == null) || (person.getHeight() < result.getHeight())) {
                result = person;
            }
        }
        return result;
    }

    public static Person getMaxHeight(Vector<Person> list) {
        Person result = null;
        for (Person person : list) {
            if ((result == null) || (person.getHeight() > result.getHeight())) {
                result = person;
            }
        }
        return result;
    }

    public static int getAvgHeight(Vector<Person> list) {
        int sum = 0;
        for (Person p : list){          // Liste durchgehen pHeight wird in p gespeichert
            sum = sum + p.getHeight();  // pHeight wird in sum gespeichert und mit der näschten Summe addiert
        }
        sum = sum / list.size();        // Summe von der Größe dividiert durch die länge der liste
        return sum;
    }

    public static Person getMinWeight(Vector<Person> list) {
        Person result = null;
        for (Person person : list) {
            if ((result == null) || (person.getWeight() < result.getWeight())) {
                result = person;
            }
        }
        return result;
    }

    public static Person getMaxWeight(Vector<Person> list) {
        Person result = null;
        for (Person person : list) {
            if ((result == null) || (person.getWeight() > result.getWeight())) {
                result = person;
            }
        }
        return result;
    }

    public static int getAvgWeight(Vector<Person> list) {
        int sum = 0;
        for (Person p : list){          // Liste durchgehen pHeight wird in p gespeichert
            sum = sum + p.getWeight();  // pWeight wird in sum gespeichert und mit der näschten Summe addiert
        }
        sum = sum / list.size();        // Summe von dem Gewicht dividiert durch die länge der liste
        return sum;
    }
}