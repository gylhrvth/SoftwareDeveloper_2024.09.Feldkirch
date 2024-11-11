package Thiemo.week09.Person2;

public class Actor {

    private String firstName;
    private String surName;
    private int age;
    private int gage;
    private String fullName;
    private int count;

    public Actor(String firstName, String surName, int age ,int gage ) {
        this.firstName = firstName;
        this.gage = gage;
        this.age = age;
        this.surName = surName;
        this.fullName = firstName + surName;
        this.count = 0;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGage() {
        return gage;
    }

    public void setGage(int gage) {
        this.gage = gage;
    }

    public int getAge() {
        return age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return fullName + " "+ gage +"€"+ " " + count;
    }
}
