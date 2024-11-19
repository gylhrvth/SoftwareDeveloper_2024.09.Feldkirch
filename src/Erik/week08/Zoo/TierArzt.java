package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.Vector;

public class TierArzt {

    // Attribute
    private String name;
    private Vector<Gehege> taskList;


    // Konstruktor
    public TierArzt(String name) {
        this.name = name;
        this.taskList = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return Colors.COLORS[6] + "Dr." + name + Colors.RESET;
    }


    // Methoden
    public void addTask(Gehege task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    public void startDaySim(Zoo zoo) {
        Tier animal = zoo.findOverallLowestAnimal();
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

