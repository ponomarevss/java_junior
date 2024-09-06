package ru.ponomarevss.lesson3.homework;

import java.io.*;

/**
 * Разработайте класс Student с полями String name, int age, transient double GPA.
 * Обеспечьте поддержку сериализации для этого класса.
 * Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл.
 * Десириализуйте объект обратно в программу из файла.
 * Выведите все поля объекта, включая GPA, и обсудите почему значение GPA не было сохранено/восстановлено.
 * */
public class Program {
    public static void main(String[] args) {

        Student student = new Student("Bravo", 22, 4.2);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.bin"))) {
            objectOutputStream.writeObject(student);
            System.out.printf("Объект %s сериализован%n", student);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.bin"))) {
            Student deserializedStudent = (Student) objectInputStream.readObject();
            System.out.printf("Объект %s десериализован%n", deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
