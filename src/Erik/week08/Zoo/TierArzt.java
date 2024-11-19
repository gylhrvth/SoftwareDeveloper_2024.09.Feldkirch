package Erik.week08.Zoo;

import Sandro.Colors;
import java.util.Vector;

public class TierArzt {

    // Attribute
    private String name;
    private Vector<Gehege> taskList;


    // Konstruktor
    public TierArzt(String name){
        this.name = name;
        this.taskList = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return name;
    }


    // Methoden
    public void addTask(Gehege task) {
        if (!taskList.contains(task)) {
            taskList.add(task);
        }
    }

    public void startDaySim(Zoo zoo){
        Tier animal = zoo.findLowestHPAnimal();
        if (animal != null){
            animal.heal(this);
        } else {
            System.out.println("Dr." + name + ".. nobody needs a heal ..");
        }





//        for (Gehege gh : taskList) {
//            gh.startDaySimVet();
//        }
    }


    @Override
    public String toString() {
        return Colors.COLORS[5] + name + Colors.RESET;
    }

    public void startDaySimulation(Tier tier, Gehege gh){
//        Tier needToHeal = gh.searchForLowestHealth();
//        System.out.println(needToHeal); // welches tier?
//        tier.heal(needToHeal);


        // lowestHP Animal speichern
        // Heal funktion aufrufen


//        for (Gehege gh : taskList) {
//            gh.vetGoesThroughEveryAnimal();
//        }
    }
}
