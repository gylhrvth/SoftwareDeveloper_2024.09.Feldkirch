package Gyula.week08;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>();
        names.add("Aylin");
        names.add("Erik");
        names.add("Akif");
        names.add("Gyula");
        names.add("Eleonora");
        names.add("Georg");

        System.out.println(names);
        names.remove(4);
        System.out.println(names);
        names.remove("Georg");
        System.out.println(names);

        names.add(0, "Thiemo");
        System.out.println(names);

        System.out.println("Length: " + names.size());
        System.out.println("For-I Schleife");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Name: " + names.get(i));
        }
        System.out.println();
        System.out.println("For-each Schleife");
        for (String name : names){
            System.out.println("Name: " + name);
        }
        System.out.println();
        System.out.println("Durchlaufen mit Iterator");
        Iterator<String> it = names.iterator();
        while (it.hasNext()){
            String name = it.next();
            System.out.println("Name: " + name);
        }

        System.out.println("Contains Paul? : " + names.contains("Paul"));
        System.out.println("Contains Gyula? : " + names.contains("Gyula"));

        System.out.println("indexOf(Paul) " + names.indexOf("Paul"));
        System.out.println("indexOf(Gyula) " + names.indexOf("Gyula"));

        names.set(0, "Furkan");
        System.out.println(names);

        System.out.println(names.get(10000));
    }
}
