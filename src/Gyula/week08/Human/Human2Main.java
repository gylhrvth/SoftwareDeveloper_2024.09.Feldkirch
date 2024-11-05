package Gyula.week08.Human;

import java.util.Random;
import java.util.Vector;

public class Human2Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Vector<Human2> freunde = generateRandomPeople(20);

        for (Human2 h : freunde){
            System.out.println(h);
        }

        Human2 juengstePerson = getMinAge(freunde);
        System.out.println("Der jüngste Person ist " + juengstePerson.getName());
    }

    public static Human2 getMinAge(Vector<Human2> vec){
        Human2 result = null;
        for (Human2 h : vec){
            if ((result == null) || (h.getAge() < result.getAge())){
                result = h;
            }
        }
        return result;
    }


    public static Vector<Human2> generateRandomPeople(int count){
        Vector<Human2> result = new Vector<>();
        String[] firstName = new String[]{"Akif", "Aylin", "Thiemo", "Furkan", "Erik", "Sandro", "Gyula", "Lukas", "Jessica", "Manfred"};
        String[] lastName = new String[]{"Müller", "Klein", "Gross", "Eichstetter", "Zimmerman", "Topcu", "Horvath", "Boso", "Brechtold", "Wohlgennant", "Tadic"};

        for (int i = 0; i < count; i++) {
            int age = random.nextInt(16, 42);
            int height = random.nextInt(150, 205);
            int weight = random.nextInt(50, 120);
            String name = firstName[random.nextInt(firstName.length)] + " " + lastName[random.nextInt(lastName.length)];

            result.add(new Human2(name, age, height, weight));
        }
        return result;
    }
}
