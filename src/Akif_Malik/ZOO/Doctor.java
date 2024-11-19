package Akif_Malik.ZOO;

/*
    -Jeder Tierarzt wird an jedem Tag - genau 1 Tier behandeln
    -Der Tierarzt wählt das Tier mit der geringsten relativen Gesundheit
        Zum Beispiel: 10 Gesundheit mit 100 Maximum ist 10% und so dringender als 1 Gesundheit aus 2 ergo 50%.
    -Der Tierarzt wird zufällig zwischen 30 und 100% der Gesundheit wiederherstellen
    -Kein Tier kann über die maximale Gesundheit geboostet werden.

 */

public class Doctor {

    private String name;

    public Doctor(String name) {
        this.name = name;
    }
}
