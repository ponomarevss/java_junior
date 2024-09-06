package ru.ponomarevss.lesson2.homework;

import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> stringClass = Class.forName("java.lang.String");
        Arrays.stream(stringClass.getDeclaredMethods()).forEach(System.out::println);
    }
}
