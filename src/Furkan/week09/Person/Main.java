package Furkan.week09.Person;


import java.util.Random;
import java.util.Vector;

public class Main {
    private static Random random = new Random();

    public static void main(String[] args) {
        Vector<Human1> freunde = generateRandomPeople(20);

        for (Human1 human1 : freunde) {
            System.out.println(human1);
        }

        System.out.println();

        Human1 youngestPerson = getMinAge(freunde);
        System.out.println("Der jüngste ist " + youngestPerson.getName());

        Vector<Human1> youngest = getmMinAgeAll(freunde);
        System.out.println("Die Jüngsten sind: ");
        for (Human1 human1 : youngest){
            System.out.println(human1);
        }

    }


    public static Human1 getMinAge(Vector<Human1> vector) {
        Human1 result = null;
        for (Human1 human1 : vector) {
            if ((result == null) || (human1.getAge() < result.getAge())) {
                result = human1;
            }
        }
        return result;
    }

    public static Vector<Human1> getmMinAgeAll(Vector<Human1> vector){
        Vector<Human1> result = new Vector<>();
        for (Human1 human1 : vector){
            if (result.isEmpty()){
                result.add(human1);
            }else {
                if (human1.getAge() < result.firstElement().getAge()){
                    result.clear();
                    result.add(human1);
                } else if (human1.getAge() == result.firstElement().getAge()) {
                    result.add(human1);

                }
            }
        }
        return result;
    }


    public static Vector<Human1> generateRandomPeople(int count) {
        Vector<Human1> result = new Vector<>();
        String[] firstName = new String[]{"Furkan", "Fatih", "Emre", "Irfan", "Mert Hakan", "Ferdi", "Ümit", "Metehan", "Hülagü", "Mustafa"};
        String[] lastname = new String[]{"Kahveci", "Bagriacik", "Türk", "Kurt", "Ince", "Can", "Tadic", "Han", "Ataberk", "Yildiran"};

        for (int i = 0; i < count; i++) {
            int age = random.nextInt(16, 38);
            int height = random.nextInt(150, 202);
            int weight = random.nextInt(50, 110);
            String name = firstName[random.nextInt(firstName.length)] + " " + lastname[random.nextInt(lastname.length)];

            result.add(new Human1(name, age, height, weight));
        }
        return result;
    }


}
