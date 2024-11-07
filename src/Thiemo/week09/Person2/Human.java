package Thiemo.week09.Person2;

public class Human {

    private String name;
    private int age;
    private int height;
    private int weight;


    public Human(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
//        return String.format("%-20s (%-4d - %.2f cm / %.2f kg)", name, age, (float) height, (float) weight);
//        return String.format("%-20s (%-4d - %d cm / %d kg)", name, age, height, weight);
//        return name + "(" + age + " - " + height + " cm/" + weight + "kg)";
        return String.format("%s (%d - %.1f cm / %.1f kg)", name, age, (float) height, (float) weight);
    }

//    public int compareTo(Human human) {
//        return 0;
//    }
}

