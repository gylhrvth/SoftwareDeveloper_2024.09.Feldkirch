package Thiemo.week09.Person2;

import Gyula.week04.BubbleSortExample;

import java.util.Comparator;
import java.util.Random;
import java.util.Vector;

public class HumanMain {

    private static Random random = new Random();

    public static void main(String[] args) {
        Vector<Human> morePeople = generateRandomPeople(20);

        System.out.printf("%-20s %-4s %-13s %-10s%n", "Name", "Age", "Height", "Weight");
        System.out.println("-".repeat(50));
        for (Human h : morePeople) {
            System.out.printf("%-20s %-4d %-7.2fcm  %7.2fkg%n", h.getName(), h.getAge(), (float) h.getHeight(), (float) h.getWeight());
//            System.out.println(h);

        }
        Human youngestperson = getMinAge(morePeople);
        Human oldestPerson = getMaxAge(morePeople);
        double averageAge = getAverageAge(morePeople);
        System.out.println("\nThe youngest person is : " + youngestperson);
        System.out.println("The oldest Person is: " + oldestPerson);
        System.out.println("The average age from all Persons is: " + averageAge);

        Vector<Human> moreThanOneYoungestPerson = getMaxAgeAll(morePeople);
        System.out.println("\nDie Jüngsten sind:");
        for (Human h : moreThanOneYoungestPerson) {
            System.out.println(h);
        }

        Human big = getMaxHeight(morePeople);
        Human small = getMinHeight(morePeople);
        double averageHeight = getAverageHeight(morePeople);
        System.out.println();
        System.out.println("The smallest person is: " + small);
        System.out.println("The biggest Person is: " + big);
        System.out.println("The average height is: " + averageHeight + "cm");

        Human fat = getMaxWeight(morePeople);
        Human thin = getMinWeight(morePeople);
        double averageWeight = getAverageWeight(morePeople);
        System.out.println();
        System.out.println("The fattest Person is: " + fat);
        System.out.println("The thinnest Person is: " + thin);
        System.out.println("The average weight is: " + averageWeight + "Kg\n");

        cocktailShakerSort(morePeople, Comparator.comparingInt(Human::getAge));
        for (Human h : morePeople) {
            System.out.println(h);

        }
        System.out.println();
        cocktailShakerSort(morePeople, Comparator.comparingInt(Human::getWeight));
        for (Human h : morePeople) {
            System.out.println(h);
        }
        System.out.println();
        cocktailShakerSort(morePeople, Comparator.comparingInt(Human::getHeight));
        for (Human h : morePeople) {
            System.out.println(h);
        }
        System.out.println();
        cocktailShakerSort(morePeople, Comparator.comparing(Human::getName));
        for (Human h : morePeople) {
            System.out.println(h);
        }
        System.out.println();
        cocktailShakerSort(morePeople, Comparator.comparing(Human::getName).reversed());
        for (Human h : morePeople) {
            System.out.println(h);
        }
    }

    public static Vector<Human> generateRandomPeople(int count) {
        Vector<Human> result = new Vector<>();
        String[] firstName = new String[]{"Max", "Jesus", "Akif", "Aylin", "Thiemo", "Furkan", "Erik", "Sandro", "Gyula", "Lukas", "Jessica", "Manfred"};
        String[] surName = new String[]{"Mustermann", "Gotham", "Müller", "Klein", "Gross", "Eichstetter", "Zimmerman", "Topcu", "Horvath", "Boso", "Brechtold", "Wohlgennant", "Tadic"};

        for (int i = 0; i < count; i++) {
            int age = random.nextInt(16, 42);
            int height = random.nextInt(150, 205);
            int weight = random.nextInt(50, 120);
            String name = firstName[random.nextInt(firstName.length)] + " " + surName[random.nextInt(surName.length)];

            result.add(new Human(name, age, height, weight));
        }
        return result;
    }

    public static Human getMinAge(Vector<Human> vec) {
        Human result = null;
        for (Human h : vec) {
            if (result == null) {
                result = h;
            }
            if (h.getAge() < result.getAge()) {
                result = h;
            }
        }
        return result;
    }

    public static Human getMaxAge(Vector<Human> vec) {
        Human result = null;
        for (Human h : vec) {
            if (result == null) {
                result = h;
            }
            if (h.getAge() > result.getAge()) {
                result = h;
            }
        }
        return result;
    }

    public static Vector<Human> getMaxAgeAll(Vector<Human> vec) {
        Vector<Human> result = new Vector<>();
        for (Human h : vec) {
            if (result.isEmpty()) {
                result.add(h);
            } else {
                if (h.getAge() < result.firstElement().getAge()) {
                    result.clear();
                    result.add(h);
                } else if (h.getAge() == result.firstElement().getAge()) {
                    result.add(h);
                }
            }
        }
        return result;
    }

    public static Human getMaxHeight(Vector<Human> vec) {
        Human result = null;
        for (Human h : vec) {
            if (result == null) {
                result = h;
            }
            if (h.getHeight() > result.getHeight()) {
                result = h;
            }
        }
        return result;
    }

    public static Human getMinHeight(Vector<Human> vec) {
        Human result = null;
        for (Human h : vec) {
            if (result == null) {
                result = h;
            }
            if (h.getHeight() < result.getHeight()) {
                result = h;
            }
        }
        return result;
    }

    public static Human getMaxWeight(Vector<Human> vec) {
        Human result = null;
        for (Human h : vec) {
            if (result == null) {
                result = h;
            }
            if (h.getWeight() > result.getWeight()) {
                result = h;
            }
        }
        return result;
    }

    public static Human getMinWeight(Vector<Human> vec) {
        Human result = null;
        for (Human h : vec) {
            if (result == null) {
                result = h;
            }
            if (h.getWeight() < result.getWeight()) {
                result = h;
            }
        }
        return result;
    }

    public static int getAverageAge(Vector<Human> vec) {

        int avg = 0;
        for (Human h : vec) {
            avg += h.getAge();

        }


        return avg / vec.size();
    }

    public static int getAverageHeight(Vector<Human> vec) {

        int avg = 0;
        for (Human h : vec) {
            avg += h.getHeight();

        }


        return avg / vec.size();
    }

    public static int getAverageWeight(Vector<Human> vec) {

        int avg = 0;
        for (Human h : vec) {
            avg += h.getWeight();

        }


        return avg / vec.size();
    }

    public static void cocktailShakerSort(Vector<Human> vec, Comparator<Human> comparator) {
        int low = 0, high = vec.size() - 1, move = low;

        while (low < high) {
            for (int i = high; i > low; i--) {
                if (comparator.compare(vec.get(i - 1),vec.get(i)) > 0) {
                    swap(vec, i - 1, i);
                    move = i;
                }
            }
            low = move;


            for (int i = low; i < high; i++) {
                if (comparator.compare(vec.get(i), vec.get(i + 1)) > 0)  {
                    swap(vec, i, i + 1);
                    move = i;
                }
            }
            high = move;
        }
    }
    public static void swap(Vector<Human> vec, int i, int j){
        if (i >= 0 && j >= 0 && i < vec.size() && j < vec.size()) {
            Human temp = vec.get(i);
            vec.set(i, vec.get(j));
            vec.set(j, temp);
        }
    }
}


