package Furkan.week09.Person;


import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
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
        System.out.println("================================================");
        Human1 youngestPerson = getMinAge(freunde);
        System.out.println("Die jüngste Person ist : " + youngestPerson.getName() + " " + youngestPerson.getAge() + " Jahre alt.");

//        Vector<Human1> youngest = getmMinAgeAll(freunde);
//        System.out.println("Die jüngsten sind: ");
//        for (Human1 human1 : youngest) {
//            System.out.println(human1);
//        }
//        System.out.println();

        Human1 oldestPerson = getMaxAge(freunde);
        System.out.println("Die älteste Person ist " + oldestPerson.getName() + " " + oldestPerson.getAge() + " Jahre alt.");

        System.out.println("Das Durchschnittsalter ist  : " + getAvrgAge(freunde));

//        Vector<Human1> oldest = getMaxAgeAll(freunde);
//        System.out.println("Die ältesten sind: ");
//        for (Human1 human1 : oldest){
//            System.out.println(human1);
//        }
        System.out.println("================================================");

        Human1 smallestPerson = getMinSize(freunde);
        System.out.println("Die kleinste Person ist : " + smallestPerson.getName() + " " + smallestPerson.getSize() + " cm ");
        Human1 tallestPerson = getMaxSize(freunde);
        System.out.println("Die Person mit der größten Größe ist : " + tallestPerson.getName() + " " + tallestPerson.getSize() + " cm");
        System.out.println("Die Durchschnittsgröße ist : " + getAvrgSize(freunde) + " cm");
        System.out.println("================================================");

        Human1 skinnyPerson = getMinWeight(freunde);
        System.out.println("Die dünnste Person ist : " + skinnyPerson.getName() + " " + skinnyPerson.getWeight() + " Kg");
        Human1 fatPerson = getMaxWeight(freunde);
        System.out.println("Die fetteste Person ist :" + fatPerson.getName() + " " + fatPerson.getWeight() + " Kg");
        System.out.println("Das Durchschnittsgewicht ist : " + getAvrgWeight(freunde) + " Kg");
        System.out.println("=================================================");


        bubblesortMitBoolean(freunde, true , Comparator.comparingInt(Human1::getAge));
        for (Human1 human1 : freunde){
            System.out.println(human1);
        }
        System.out.println("=================================");
        System.out.println();

        bubblesortMitBoolean(freunde,true,Comparator.comparingInt(Human1::getSize));
        for (Human1 human1 : freunde){
            System.out.println(human1);
        }
        System.out.println("================================");
        System.out.println();

        bubblesortMitBoolean(freunde,true,Comparator.comparingInt(Human1::getWeight));
        for (Human1 human1 : freunde){
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


    public static Human1 getMaxAge(Vector<Human1> vector) {
        Human1 result = null;
        for (Human1 human1 : vector) {
            if ((result == null) || (human1.getAge() > result.getAge())) {
                result = human1;
            }
        }
        return result;
    }


    public static int getAvrgAge(Vector<Human1> vector) {
        int avgAge = 0;

        for (Human1 human1 : vector) {
            avgAge += human1.getAge();
        }
        return avgAge / vector.size();
    }

    public static Human1 getMinSize(Vector<Human1> vector) {
        Human1 result = null;
        for (Human1 human1 : vector) {
            if ((result == null) || (human1.getSize() < result.getSize())) {
                result = human1;
            }
        }
        return result;
    }

    public static Human1 getMaxSize(Vector<Human1> vector) {
        Human1 result = null;
        for (Human1 human1 : vector) {
            if ((result == null) || (human1.getSize() > result.getSize())) {
                result = human1;
            }
        }
        return result;
    }


    public static int getAvrgSize(Vector<Human1> vector) {
        int avgSize = 0;

        for (Human1 human1 : vector) {
            avgSize += human1.getSize();
        }
        return avgSize / vector.size();
    }


    public static Human1 getMinWeight(Vector<Human1> vector) {
        Human1 result = null;
        for (Human1 human1 : vector) {
            if ((result == null) || (human1.getWeight() < result.getWeight())) {
                result = human1;
            }
        }
        return result;
    }

    public static Human1 getMaxWeight(Vector<Human1> vector) {
        Human1 result = null;
        for (Human1 human1 : vector) {
            if ((result == null) || (human1.getWeight() > result.getWeight())) {
                result = human1;
            }
        }
        return result;
    }


    public static int getAvrgWeight(Vector<Human1> vector) {
        int avgSize = 0;

        for (Human1 human1 : vector) {
            avgSize += human1.getWeight();
        }
        return avgSize / vector.size();

    }


    public static Vector<Human1> generateRandomPeople(int count) {
        Vector<Human1> result = new Vector<>();
        String[] firstName = new String[]{"Furkan", "Fatih", "Emre", "Irfan", "Mert Hakan", "Ferdi", "Ümit", "Metehan", "Hülagü", "Mustafa", "Gyula", "Sandro"};
        String[] lastname = new String[]{"Kahveci", "Bagriacik", "Türk", "Kurt", "Ince", "Can", "Tadic", "Han", "Ataberk", "Yildiran", "Müller", "Boso"};

        for (int i = 0; i < count; i++) {
            int age = random.nextInt(16, 38);
            int height = random.nextInt(150, 215);
            int weight = random.nextInt(50, 140);
            String name = firstName[random.nextInt(firstName.length)] + " " + lastname[random.nextInt(lastname.length)];

            result.add(new Human1(name, age, height, weight));
        }
        return result;
    }


    public static void bubblesortMitBoolean(Vector<Human1> vector, boolean sort, Comparator<Human1> comparator) {

        for (int i = 0; i < vector.size(); i++) {
            for (int j = 0; j < vector.size() - 1; j++) {
                int comparison = comparator.compare(vector.get(j),vector.get(j+1));

                if ((sort&& comparison >0) || (!sort &&comparison <0)) {
                swap(vector,j,j+1);
                }
            }
        }
    }


            public static void swap (Vector < Human1 > vector,int i, int j){
                if (i >= 0 && j >= 0 && i < vector.size() && j < vector.size()) {
                    Human1 temp = vector.get(i);
                    vector.set(i, vector.get(j));
                    vector.set(j, temp);
                }
            }


            //    public static Vector<Human1> getmMinAgeAll(Vector<Human1> vector) {
//        Vector<Human1> result = new Vector<>();
//        for (Human1 human1 : vector) {
//            if (result.isEmpty()) {
//                result.add(human1);
//            } else {
//                if (human1.getAge() < result.firstElement().getAge()) {
//                    result.clear();
//                    result.add(human1);
//                } else if (human1.getAge() == result.firstElement().getAge()) {
//                    result.add(human1);
//
//                }
//            }
//        }
//        return result;
//    }


            //    public static Vector<Human1> getMaxAgeAll(Vector<Human1> vector){
//        Vector<Human1> result = new Vector<>();
//        for (Human1 human1 : vector) {
//            if (result.isEmpty()) {
//                result.add(human1);
//            } else {
//                if (human1.getAge() > result.firstElement().getAge()) {
//                    result.clear();
//                    result.add(human1);
//                } else if (human1.getAge() == result.firstElement().getAge()) {
//                    result.add(human1);
//
//                }
//            }
//        }
//        return result;
//
//    }


        }
