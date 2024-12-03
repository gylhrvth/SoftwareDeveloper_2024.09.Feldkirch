package Erik.week12;

import java.util.Vector;

public class Actor {

    // Attribute
    private int id;
    private String name;
    private int age;
    private int height;
    private int weight;

    private Vector<Film> regieOf;
    private Vector<Film> actorOf;


    // Konstruktor
    public Actor(int id, String name, int age, int height, int weight) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;

        regieOf = new Vector<>();
        actorOf = new Vector<>();
    }


    // Getter - Setter
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }


    // Methoden
    public void addFilmAsRegie(Film f) {
        if (!regieOf.contains(f)){
            regieOf.add(f);
        }
    }

    public void addFilmAsActor(Film f) {
        if (!actorOf.contains(f)){
            actorOf.add(f);
        }
    }

    public void printStructure(){
        System.out.println("│   │   ├── Actor: " + name + "; " + age + " Jahre;");
    }

    public void setWeight(int newWeight){
        this.weight = newWeight;
        DBManager.getInstance().updateActor(this);
    }
}