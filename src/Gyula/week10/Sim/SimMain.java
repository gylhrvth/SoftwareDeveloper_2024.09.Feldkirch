package Gyula.week10.Sim;

import java.util.Random;
import java.util.Vector;

public class SimMain {
    private static Random random = new Random();

    public static void main(String[] args) {
        Vector<Human> beatleas = createBeatleas();

        for (int day = 1; day <= 3; day++) {
            System.out.println("Day " + day + ":");
            SimMain.reorderPeople(beatleas);
            for (Human human : beatleas) {
                human.startDay();
            }
            boolean hasTask = true;
            while (hasTask){
                hasTask = false;

                for (Human human : beatleas) {
                    String task = human.doTask();
                    if(task != null){
                        hasTask = true;
                    }
                }
            }
            System.out.println("\n");
        }
    }

    public static void reorderPeople(Vector<Human> humans){
        for (int rep = 0; rep < 3+ 2* humans.size(); rep++) {
            int index1 = random.nextInt(humans.size());
            int index2 = random.nextInt(humans.size());

            Human temp = humans.get(index1);
            humans.set(index1, humans.get(index2));
            humans.set(index2, temp);
        }
    }

    public static Vector<Human> createBeatleas() {
        Vector<Human> beatleas = new Vector<>();

        Human john = new Human("John");
        Human paul = new Human("Paul");
        Human george = new Human("George");
        Human ringo = new Human("Ringo");

        john.addTask("Play guitar");
        john.addTask("Do homework");
        john.addTask("Eat breakfast");
        john.addTask("Go to school");

        paul.addTask("Play bass");
        paul.addTask("Eat dinner");

        george.addTask("Play guitar");
        george.addTask("Eat lunch");
        george.addTask("Do laundry");
        george.addTask("Make breakfast");
        george.addTask("Write letter");
        george.addTask("Call Paul");
        george.addTask("Make a break");

        ringo.addTask("Play drums");

        beatleas.add(john);
        beatleas.add(paul);
        beatleas.add(george);
        beatleas.add(ringo);

        return beatleas;
    }
}
