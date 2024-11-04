package Sandro.Week7.Human;

import java.io.PrintStream;

public class PersonMain {
    public static void main(String[] args) {

        //Person erstellen

        Person person1 = new Person("Hans", "Zimmerman", 67, "Male", 179, 99);

        String info = person1.toString();
        System.out.println(info);

        System.out.println(person1);
        System.out.println(person1.getFullName());
        System.out.println("----");
        person1.setSurName("Zimmerfrau");
        System.out.println(person1.getFullName());
        System.out.println("----");
        System.out.println("Hans hat geheiratet....");
        System.out.println(person1.getSurName());
        System.out.println(person1);
        System.out.println(person1.getFullName());
        System.out.println("----");
        System.out.println("es vergehen 3jahre...");
        person1.setAge(70);
        System.out.println("scheidung.....");
        System.out.println("Hans nimmt seinen alten Namen an und verliert bei dem Stress einiges an Gewicht");
        person1.setSurName("Zimmerman");
        person1.setWeight(83);
        System.out.println(person1);


    }


}
