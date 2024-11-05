package Aylin.week08;

import java.util.Iterator;
import java.util.Vector;

public class VectorExamples {
    public static void main(String[] args) {
        Vector<String> names = new Vector<>();
        names.add("Kadıoğlu");
        names.add("Amrabat");
        names.add("Osayi-Samuel");
        names.add("Dzeko");
        names.add("Tadic");
        names.add("Szymanski");
        names.add("Oosterwolde");
        names.add("Saint-Maximin");
        names.add("Livakovic");
        names.add("Fred");
        names.add("Kahveci");
        names.add("Tosun");
        names.add("Djiku");

        System.out.println(names);
        names.remove(11);
        System.out.println(names);
        names.add(8, "Mor");
        System.out.println(names);
        names.remove("Mor");
        System.out.println(names);
        System.out.println("Length: " + names.size());  //Anzahl der Wörter
        System.out.println("================================");
        System.out.println("For-I Schleife");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Name: " + names.get(i));
        }
        System.out.println("================================");
        System.out.println("For-each Schleife");
        for (String name : names){
            System.out.println("Name: " + name);
        }
        System.out.println("================================");
        System.out.println("Durchlaufen mit Iterator");
        Iterator<String> it = names.iterator();
        while (it.hasNext()){
            String name = it.next();
            System.out.println("Name: " + name);
        }
        System.out.println("================================");
        System.out.println("Contains Oosterwolde? : " + names.contains("Oosterwolde"));
        System.out.println("Contains Osayi? : " + names.contains("Osayi"));     //Weil nur Osayi nicht vorhanden ist true würde sein: Osayi-Samuel

        System.out.println("indexOf(Kadıoğlu) " + names.indexOf("Kadıoğlu"));
        System.out.println("indexOf(Szymanski) " + names.indexOf("Szymanski"));
        names.set(3, "Güler");
        System.out.println(names);

        System.out.println(names.get(2));
    }
}
