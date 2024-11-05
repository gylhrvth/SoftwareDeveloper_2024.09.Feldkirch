package Aylin.Herbstferien.OOP.Car;

import Aylin.Herbstferien.OOP.Human.Human;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mercedes", "A-Klasse", "Dunkelgrau", "116", "2021");
        Car car1 = new Car("Audi", "A5", "Schwarz", "116", "2022");

        Human fahrer1 = new Human("Emir", "Kozucuoğlu", 30, 83, 181, "Male");

        car.printCars(car);
        car1.printCars(car1);
    }
}
