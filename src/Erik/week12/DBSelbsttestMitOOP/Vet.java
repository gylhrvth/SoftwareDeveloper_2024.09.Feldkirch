package Erik.week12.DBSelbsttestMitOOP;

import Sandro.Colors;

import java.util.Vector;

public class Vet {

    // Attribute
    private String name;
    private Vector<Enclosure> taskList;


    // Konstruktor
    public Vet(String name) {
        this.name = name;
        this.taskList = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return Colors.COLORS[6] + "Dr." + name + Colors.RESET;
    }


    // Methoden
    public void addTask(Enclosure task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    public void startDaySim(Zoo zoo) {
        Animal animal = zoo.findOverallLowestAnimal();
        if (animal != null) {
            animal.heal(this);
        } else {
            System.out.println("Dr." + name + ".. nobody needs a heal ..");
        }
    }


    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }
}

