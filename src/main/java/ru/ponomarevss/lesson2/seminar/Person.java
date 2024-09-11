package ru.ponomarevss.lesson2.seminar;

public class Person {
    private String name;
    private int age;

    public Person() {
        name = "Name";
        age = 25;
    }

    public void displayInfo() {
        System.out.printf("Имя: %s; Возраст: %s%n", name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
