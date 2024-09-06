package ru.ponomarevss.lection2;

public class Car {
    public String name;
    private String price;
    private String engType;
    private String engPower;
    private int maxSpeed;

    public Car(String name) {
        this.name = name;
        price = "1000000";
        engType = "V8";
        engPower = "123";
        maxSpeed = 100;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
