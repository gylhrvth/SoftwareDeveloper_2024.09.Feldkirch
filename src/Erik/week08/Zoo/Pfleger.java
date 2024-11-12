package Erik.week08.Zoo;

import Sandro.Colors;

import java.util.Vector;

public class Pfleger {

    // Attribute
    private String name;
    private Vector<Gehege> taskList;


    // Constructor
    public Pfleger(String name) {
        this.name = name;
        this.taskList = new Vector<>();

    }


    // Getter - Setter
    public String getName() {
        return name;
    }


    // Methoden
    public void printPflegerInfos() {
        System.out.println("Pfleger Name: >> " + getName());
    }

    // Liste von Gehegen für den Pfleger
    public void addTask(Gehege task) {
        if (!taskList.contains(task)){
            taskList.add(task);
        }
    }

    public void printStructure(){
        System.out.printf("╠════ %s zuständig für: >> ", name);     // "this", ruft die Klasse selbst auf somit die toString Methode
        for (int i = 0; i < taskList.size(); i++) {
            if (i > 0){
                System.out.print(", ");
            }
            System.out.print(taskList.get(i));
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return Colors.COLORS[5] + getName() + Colors.RESET;
    }
}