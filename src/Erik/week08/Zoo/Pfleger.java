package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.Vector;

public class Pfleger {

    // Attribute
    private String name;
    private Vector<Gehege> taskList;
    private String lieblingsGattung;


    // Constructor
    public Pfleger(String name, String lieblingsGattung) {
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
    public void addTask(Gehege task) {
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
        for (Gehege gh : taskList) {
            gh.startTagesSimulation(this); // this (Pfleger Object mit geben; NICHT die Klasse "Pfleger")
        }
    }

    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }
}