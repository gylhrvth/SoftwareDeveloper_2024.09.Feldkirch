package Aylin.week08.SeriesActors;

public class SeriesActors {
    private String name;
    private String surname;
    private int age;
    private int fee;

    public SeriesActors(String name, String surname, int age, int fee){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.fee = fee;
    }

    public String getFullname(){
        return name + " " + surname;
    }

    public int getAge(){
        return age;
    }

    public int getFee(){
        return fee;
    }

    @Override
    public String
    toString() {
        return "Name: " + getFullname() + ", age: " + age + ", fee: " + fee + " mio. $";
    }
}
