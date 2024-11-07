package Sandro.Week8.Person2;

import java.util.ArrayList;
import java.util.List;

public class UseListPerson {

    enum SortBy {
        NAME, AGE, WEIGHT, HEIGHT;
        private Person comp;
        SortBy() {
            this.comp = comp;
        }
    }

    public static void main(String[] args) {

        Person person1 = new Person("Mike", 180, 80, 28);
        Person person2 = new Person("Nike", 170, 70, 27);
        Person person3 = new Person("Bike", 160, 60, 16);
        Person person4 = new Person("Like", 150, 50, 35);
        Person person5 = new Person("Dike", 190, 85, 58);
        List<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        printList(list);
        PersonStatistics getMinMaxAvg = PersonStatistics.calculate(list);

        System.out.println(getMinMaxAvg);
        System.out.println();
        System.out.println("Default\n");
        printList(list);
        System.out.println();
        System.out.println("Sort by Name\n");
        chooseSortList(list, SortBy.NAME);
        printList(list);
        System.out.println();
        System.out.println("Sort by Age\n");
        chooseSortList(list, SortBy.AGE);
        printList(list);
        System.out.println();
        System.out.println("Sort by Height\n");
        chooseSortList(list, SortBy.HEIGHT);
        printList(list);
        System.out.println();
        System.out.println("Sort by Weight\n");
        chooseSortList(list, SortBy.WEIGHT);
        printList(list);


    }

    public static void chooseSortList(List<Person> list, SortBy sortlist) {

        if (sortlist == SortBy.NAME) {
            sortListName(list);
        } else if (sortlist == SortBy.AGE) {
            sortListAge(list);
        } else if (sortlist == SortBy.HEIGHT) {
            sortListHeight(list);
        } else if (sortlist == SortBy.WEIGHT) {
            sortListWeight(list);
        } else {

        }

//        list.sort(sortlist.comp);

    }

    public static void sortListAge(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Person p = list.get(j);
                Person p2 = list.get(j + 1);
                if (p.getAge() < p2.getAge()) {
                    list.set(j, p2);
                    list.set(j + 1, p);
                }
            }
        }
    }

    public static void sortListHeight(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Person p = list.get(j);
                Person p2 = list.get(j + 1);
                if (p.getHeight() < p2.getHeight()) {
                    list.set(j, p2);
                    list.set(j + 1, p);
                }
            }

        }
    }

    public static void sortListWeight(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Person p = list.get(j);
                Person p2 = list.get(j + 1);
                if (p.getWeight() < p2.getWeight()) {
                    list.set(j, p2);
                    list.set(j + 1, p);
                }
            }

        }
    }

    public static void sortListName(List<Person> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                Person p = list.get(j);
                Person p2 = list.get(j + 1);
                if (p.getName().compareTo(p2.getName()) > 0) {
                    list.set(j, p2);
                    list.set(j + 1, p);

                    // Person temp = list.get(j);
                    // list.set(j, list.get(j + 1));
                    // list.set(j + 1, temp);

                }
            }

        }
    }

    public static void printList(List<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


}
