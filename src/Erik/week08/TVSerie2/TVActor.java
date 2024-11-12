package Erik.week08.TVSerie2;

public class TVActor {

    // Attribute
    private String firstName;
    private String lastName;
    private String fullName;
    private int age;
    private int gage;

    // Konstruktor
    public TVActor(String firstName, String lastName, int age, int gage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.age = age;
        this.gage = gage;
    }

    // Getter - Setter

    public String getFullName(){
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGage() {
        return gage;
    }

    public void setGage(int gage) {
        this.gage = gage;
    }
}