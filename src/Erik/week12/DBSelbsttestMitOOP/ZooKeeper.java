package Erik.week12.DBSelbsttestMitOOP;

import Sandro.Colors;

import java.util.Vector;

public class ZooKeeper {

    // Attribute
    private String name;
    private Vector<Enclosure> taskList;
    private String lieblingsGattung;


    // Constructor
    public ZooKeeper(String name, String lieblingsGattung) {
        this.name = name;
        this.taskList = new Vector<>();
        this.lieblingsGattung = lieblingsGattung;
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public String getLieblingsGattung() {
        return lieblingsGattung;
    }


    // Methoden
    public void addTask(Enclosure task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    public void printStructure() {
        System.out.printf("├─── %s ist zuständig für: >> ", name);     // "this", ruft die Klasse selbst auf somit die toString Methode
        for (int i = 0; i < taskList.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(taskList.get(i));
        }
        System.out.println();
    }

    public void startTagesSimulation() {
        for (Enclosure gh : taskList) {
            gh.startDaySimulationForPfleger(this); // this (Pfleger Object mit geben; NICHT die Klasse "Pfleger")
        }
    }

    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }
}