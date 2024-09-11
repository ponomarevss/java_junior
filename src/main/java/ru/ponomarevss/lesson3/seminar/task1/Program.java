package ru.ponomarevss.lesson3.seminar.task1;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        UserData userData = new UserData("Alpha", 37, "secret");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("userdata.bin"))) {
            objectOutputStream.writeObject(userData);
            System.out.printf("Объект %s сериализован%n", userData);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("userdata.bin"))) {
            UserData user = (UserData) objectInputStream.readObject();
            System.out.printf("Объект %s десериализован%n", user);
        }
    }

}
