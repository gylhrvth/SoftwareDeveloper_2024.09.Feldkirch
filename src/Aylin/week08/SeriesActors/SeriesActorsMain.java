package Aylin.week08.SeriesActors;

import java.util.Vector;

public class SeriesActorsMain {
    public static void main(String[] args) {
        Vector<SeriesActors> scoutList = actors();

        for (SeriesActors actor : scoutList){
            System.out.println(actor);
        }

        Vector<SeriesActors> scoutListActresses = actresses(5);
        for (SeriesActors actresses : scoutListActresses){
            System.out.println(actresses);
        }
    }

    public static Vector<SeriesActors> actors() {
        Vector<SeriesActors> actorList = new Vector<>();
        String[] name = new String[]{"Dwayne", "Tom", "Leonardo", "Brad", "Robert", "Elyas", "Matthias", "Idris", "Henry", "Kıvanç", "Burak", "Çağatay"};
        String[] surname = new String[]{"Johnson", "Cruise", "DiCaprio", "Pitt", "Downey Jr.", "M'Barek", "Schweighöfer", "Elba", "Cavill", "Tatlıtuğ", "Özçivit", "Ulusoy"};
        int[] age = new int[]{52, 62, 49, 60, 59, 42, 42, 52, 41, 41, 39, 34};
        int[] fee = new int[]{22, 15, 20, 22, 20, 2, 3, 13, 15, 2, 2, 2};

        for (int i = 0; i < name.length; i++) {
            String actorName = name[i];
            String actorSurname = surname[i];
            int actorAge = age[i];
            int actorFee = fee[i];
            actorList.add(new SeriesActors(actorName, actorSurname, actorAge, actorFee));
        }
        return actorList;
    }

    public static Vector<SeriesActors> actresses(int count) {
        Vector<SeriesActors> actorList = new Vector<>();
        String[] name = new String[]{"Scarlett", "Julia", "Angelina", "Jennifer", "Heike", "Emma", "Kate", "Rebel", "Tuba", "Pınar", "Fahriye", "Emilia"};
        String[] surname = new String[]{"Johansson", "Roberts", "Jolie", "Aniston", "Makatsch", "Watson", "Winslet", "Wilson", "Büyüküstün", "Deniz", "Evcen", "Clarke"};
        int[] age = new int[]{39, 56, 49, 55, 52, 34, 48, 44, 42, 29, 38, 37};
        int[] fee = new int[]{18, 20, 15, 17, 1, 10, 8, 10, 1, 2, 1, 4};

        for (int i = 0; i < count; i++) {
            String actorName = name[i];
            String actorSurname = surname[i];
            int actorAge = age[i];
            int actorFee = fee[i];
            actorList.add(new SeriesActors(actorName, actorSurname, actorAge, actorFee));
        }
        return actorList;
    }
}
