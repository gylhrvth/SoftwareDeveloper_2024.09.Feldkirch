package Aylin.week08.Human2;

import Sandro.Colors;
import java.util.Random;
import java.util.Vector;

public class Human2Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Vector<Human2> friends = generateRandomPeople(10);

        sortVector(friends);
        for (Human2 human : friends){
            System.out.println(human);
        }
        Human2 youngestAge = getYoungestAge(friends);
        System.out.println("-----------------------------------------------------");
        System.out.println(Colors.COLORS[3] + "Youngest person: " + youngestAge.getName() + Colors.RESET);
        Human2 oldestAge = getOldestAge(friends);
        System.out.println(Colors.COLORS[3] + "Oldest age: " + oldestAge.getName() + Colors.RESET);
        double avrgAge = getAverageAge(friends);
        System.out.println(Colors.COLORS[3] + "Average age: " + avrgAge + Colors.RESET);
    }

    public static Vector<Human2> generateRandomPeople(int count){
        Vector<Human2> result = new Vector<>();
        String[] firstName = new String[]{"Ferdi", "Mesut", "Gustavo", "Jayden", "Volkan", "Moussa", "Enner", "Caner", "Aygün", "Alex"};
        String[] surname = new String[]{"Kadıoğlu", "Özil", "Ferreira", "Oosterwolde", "Demiral", "Sow", "Valencia", "Erkin", "Topcu", "De Soza"};
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-25s: %5s -   %5s  /  %5s |\n", Colors.COLORS[5] + "Name", "Age", "Height", "Weight" + Colors.RESET);
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i <count ; i++) {
            int age = random.nextInt(90);
            int height = 51;
            int weight = 3;
            String name = firstName[random.nextInt(firstName.length)] + " " + surname[random.nextInt(surname.length)];
            if(age < 18){
                height = height + age * (170 - height) / 18 + random.nextInt(-5, 5);
                weight = weight + age * (80 - weight) / 18 + random.nextInt(-3, 3);
            }else{
                height = random.nextInt(160, 203);
                weight = random.nextInt(45, 130);
            }

            result.add(new Human2(name, age, height, weight));
        }
        return result;
    }

    public static Human2 getYoungestAge(Vector <Human2> vec){
        Human2 result = null;

        for (Human2 human : vec) {
            if(result == null){
                result = human;
            }
            if(human.getAge() < result.getAge()){
                result = human;
            }
        }
        return result;
    }

    public static Human2 getOldestAge(Vector <Human2> vec){
        Human2 result = null;

        for (Human2 human : vec) {
            if(result == null){
                result = human;
            }
            if(human.getAge() > result.getAge()){
                result = human;
            }
        }
        return result;
    }

    public static double getAverageAge(Vector<Human2> result){
        int sum = 0;
        for (Human2 human : result){
            sum += human.getAge();
        }
        return (double)sum / result.size();
    }

    public static Vector<Human2> sortVector (Vector<Human2> vector){
        for (int i = 0; i < vector.size() ; i++) {
            for (int j = 0; j < vector.size() - i - 1; j++) {
                if(vector.get(j).getAge() > vector.get(j + 1).getAge()) {
                    swap(vector, j, j + 1);
                }
            }
        }
        return vector;
    }

    public static void swap(Vector <Human2> vector, int i, int j) {
        if (i >= 0 && j >= 0 && i < vector.size() && j < vector.size()) {
            Human2 temp = vector.get(i);
            vector.set(i, vector.get(j));
            vector.set(j, temp);
        }
    }
}
