package Erik.week07.person;

public class Person {

    // Eigenschaften|(Attribute)
    public String name;
    private int gewicht;
    private int groesse;
    private int alter;


    // Konstruktor erstellen
    public Person(String name, int alter, int gewicht, int groesse) {
        this.name = name;
        this.alter = alter;
        this.gewicht = gewicht;
        this.groesse = groesse;
    }

    public String getName() {
        return name;
    }

    public void format() {
        System.out.printf("Name: >>%-6s<< Alter: >>%d Jahre<< Gewicht: >>%d kg<< Größe: >>%d cm<<", name, alter, gewicht, groesse);
    }

    public String toString() {
        return name;
    }
}
