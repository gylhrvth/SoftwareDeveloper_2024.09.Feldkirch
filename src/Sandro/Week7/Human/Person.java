package Sandro.Week7.Human;

public class Person {
    //Attribute
    private String firstName;

    private String surName;
    private String fullName;

    private int age;

    private String gender;

    private int height;

    private int weight;


    //Konstruktor

    public Person(String firstName, String surName, int age, String gender, int height, int weight) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.fullName = firstName + " "+surName;
    }

    //Funktionen


    public void createFullName(){
        this.fullName = firstName + " "+ surName;
    }
    public String getFullName() {
        return fullName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
        //update my Fullname...
        createFullName();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return "FullName: "+firstName + " "+surName+"\nAge: "+age +" years |Gender: " +gender+  "\nHeight: "+ height + " cm |Weight: "+weight+ " Kg";

}


}
