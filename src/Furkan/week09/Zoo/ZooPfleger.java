package Furkan.week09.Zoo;

import java.util.Random;
import java.util.Vector;

public class ZooPfleger {
    private String name;
    private Vector<Gehege> gehegeListe;
    private Vector<String> bearbeiteteGehege;
    private String favTier;


    public ZooPfleger(String name) {
        this.name = name;
        this.gehegeListe = new Vector<>();
        this.bearbeiteteGehege = new Vector<>();
        this.favTier = favTier;
    }


    public void addTask(Gehege task) {
        if (!gehegeListe.contains(task)) {
            gehegeListe.add(task);
        }
    }

    public void workOnGehege() {
        Random random = new Random();

        for (Gehege gehege : gehegeListe) {
            if (bearbeiteteGehege.contains(gehege.getName())) {
                System.out.println(name + " kontrolliert das Gehege: " + gehege.getName());
            } else {
                System.out.println(name + " füttert die Tiere im Gehege: " + gehege.getName());
                for (Tier tier : gehege.getTierList()) {
                    if (tier.getHungerStatus() >= tier.getHungerCycle()) {
                        System.out.println(name + " hat das Tier " + tier.getName() + " gefüttert.");
                        tier.simu();


                    }

                }

            }


            if (!gehege.getTierList().isEmpty()) {
                Tier tierToObserve = gehege.getTierList().get(random.nextInt(gehege.getTierList().size()));
                System.out.println(name + " beobachtet das Tier " + tierToObserve.getName() + " (" + tierToObserve.getGattung() + ") länger.");


                if (tierToObserve.getGattung().equals(favTier)) {
                    System.out.println(name + " bewundert das " + favTier + " im Gehege " + gehege.getName() + ".");


                }
            }

            bearbeiteteGehege.add(gehege.getName());
            System.out.println();

//
        }


    }


    public String getFavTier() {
        return favTier;
    }

    public String getName() {
        return name;
    }

}
