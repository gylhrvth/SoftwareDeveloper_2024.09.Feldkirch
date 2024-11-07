package Sandro.Week8;

import Sandro.Week7.Human.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRehearsal {
    static Random rand = new Random();

    public static void main(String[] args) {

        List<Sandro.Week7.Human.Person> personList = new ArrayList<>();
        Person sandro = new Person("Sandro", "Boso", rand.nextInt(100),"Male", rand.nextInt(90,200),rand.nextInt(90));
        Person sandro2 = new Person("Sandro", "Boso", rand.nextInt(100),"Male",rand.nextInt(90,200) ,rand.nextInt(90));
        Person guyla = new Person("Gyula", "Horvath", rand.nextInt(100),"Male", rand.nextInt(90,200),rand.nextInt(90));
        Person max = new Person("Max", "Musterman", 99, "Female",180,99);
        personList.add(sandro);
        personList.add(sandro2);
        personList.add(guyla);
        personList.add(max);
        printList(personList);
        System.out.println("Ist die Person in der Liste enthalten? " + personList.contains(max));
        System.out.println("Wir löschen Max aus der Liste");
        personList.remove(max);
        printList(personList);
        System.out.print("Wer ist die letzte Person in der Liste? ---> ");
        System.out.println(personList.get(personList.size() - 1));
        printObject(sandro);
    }

    public static void printList (List<Person> personList){
        for (Person p: personList) {
            System.out.println("Person: " +p);
        }

    }
    private static void printObject(Object obj) {
        System.out.println("My object: " + obj.toString());
    }

}
