package Erik.week07.person;

public class PersonMain {
    public static void main(String[] args) {

        // Objekt Person
        Person person1 = new Person("Erik", 23, 100, 200);
        Person person2 = new Person("Markus", 55, 102, 193);

        // Methoden Aufrufe
        person1.format();
        System.out.println();
        person2.format();
    }
}
