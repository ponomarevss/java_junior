package ru.ponomarevss.lesson2.seminar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> personalClass = Class.forName("ru.ponomarevss.lesson2.seminar.Person");
        Field[] fields = personalClass.getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);
        Method[] methods = personalClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
        Constructor<?>[] constructors = personalClass.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        Object personInstance = constructors[0].newInstance();
        Method getPersonalInfoMethod = personalClass.getDeclaredMethod("displayInfo");
        getPersonalInfoMethod.invoke(personInstance);

        Field nameField = personalClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(personInstance, "Alice");

        Field ageField = personalClass.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(personInstance, 16);
        getPersonalInfoMethod.invoke(personInstance);

    }
}
