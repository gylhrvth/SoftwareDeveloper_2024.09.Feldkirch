package Akif_Malik.week08.Thursday;

import Sandro.Colors;

import java.util.Random;
import java.util.Vector;

public class Person2 {
    public static Random rand = new Random();

    //Atribute

    private String firstName;

    private String fullName;

    private int age;

    private int weight;

    private int height;

    //-----------Konstruktor-----------\\

    public Person2(String firstName, int age, int height, int weight) {
        this.firstName = firstName;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    //-----------Funktionen------------\\

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    //-Setters-\\

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //-----------------------------------------------------------------------------------------\\

    @Override
    public String toString() {
        return Colors.COLORS[4] + fullName + Colors.RESET +
                "\nAge: " + Colors.COLORS[6] + age + Colors.RESET +
                "\nHeight: " + Colors.COLORS[3] + height + Colors.RESET +
                "\nWeight: " + Colors.COLORS[2] + weight + Colors.RESET +"\n ";
    }

    //------Methods------\\

    public static Vector<Person2> generatePeople(int count) {
        Vector<Person2> result = new Vector<>();
        String[] firstName = new String[]{"Akif", "Max", "Bastian", "Fabian", "Selina", "Lucy", "Manfred", "Olaf", "Günther"};
        String[] lastName = new String[]{"Zimmermann", "Mustermann", "Müller", "Lang", "Kessler", "Horvath", "Raskin", "Konzett"};

        for (int i = 0; i < count; i++) {
            int age = rand.nextInt(15, 90);
            int height = rand.nextInt(160, 210);
            int weight = rand.nextInt(55, 105);
            String fullName = Colors.COLORS[4] + firstName[rand.nextInt(firstName.length)] + Colors.RESET +
                        " " + Colors.COLORS[6] + lastName[rand.nextInt(lastName.length)] + Colors.RESET;

            result.add(new Person2(fullName, age, height, weight));
        }
        return result;
    }

    public static void printPeople(Vector<Person2> people) {
        for (Person2 onePerson : people) {
            System.out.println(onePerson);
        }
    }

    public static Person2 getMinAges(Vector<Person2> list) {
        Person2 result = null;
        for (Person2 person : list) {
            if ((result == null) || (person.getAge() < result.getAge())) {
                result = person;
            }
        }
        return result;
    }

    public static Person2 getMaxAges(Vector<Person2> list) {
        Person2 result = null;
        for (Person2 person : list) {
            if ((result == null) || (person.getAge() > result.getAge())) {
                result = person;
            }
        }
        return result;
    }

    public static int getAvgAges(Vector<Person2> list) {
        int sum = 0;
        for (Person2 p : list) {                 // Liste durchgehen alle alter zusammenrechnen
            sum = sum + p.getAge();
        }
        sum = sum / list.size();                // Summe von Alter dividiert durch die länge der liste
        return sum;
    }

    public static Person2 getMinHeights(Vector<Person2> list) {
        Person2 result = null;
        for (Person2 person : list) {
            if ((result == null) || (person.getHeight() < result.getHeight())) {
                result = person;
            }
        }
        return result;
    }

    public static Person2 getMaxHeights(Vector<Person2> list) {
        Person2 result = null;
        for (Person2 person : list) {
            if ((result == null) || (person.getHeight() > result.getHeight())) {
                result = person;
            }
        }
        return result;
    }

    public static int getAvgHeights(Vector<Person2> list) {
        int sum = 0;
        for (Person2 p : list){          // Liste durchgehen pHeight wird in p gespeichert
            sum = sum + p.getHeight();  // pHeight wird in sum gespeichert und mit der näschten Summe addiert
        }
        sum = sum / list.size();        // Summe von der Größe dividiert durch die länge der liste
        return sum;
    }

    public static Person2 getMinWeights(Vector<Person2> list) {
        Person2 result = null;
        for (Person2 person : list) {
            if ((result == null) || (person.getWeight() < result.getWeight())) {
                result = person;
            }
        }
        return result;
    }

    public static Person2 getMaxWeights(Vector<Person2> list) {
        Person2 result = null;
        for (Person2 person : list) {
            if ((result == null) || (person.getWeight() > result.getWeight())) {
                result = person;
            }
        }
        return result;
    }

    public static int getAvgWeights(Vector<Person2> list) {
        int sum = 0;
        for (Person2 p : list){          // Liste durchgehen pHeight wird in p gespeichert
            sum = sum + p.getWeight();  // pWeight wird in sum gespeichert und mit der näschten Summe addiert
        }
        sum = sum / list.size();        // Summe von dem Gewicht dividiert durch die länge der liste
        return sum;
    }
}
