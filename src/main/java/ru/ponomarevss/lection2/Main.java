package ru.ponomarevss.lection2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Car car = new Car("BMW");
//        System.out.println(car.name);
        Class<?> car = Class.forName("ru.ponomarevss.lection2.Car");
        Constructor<?>[] constructors = car.getConstructors();

        Object gaz = constructors[0].newInstance("ГАЗ");
        System.out.println(gaz);

        Field[] fields = gaz.getClass().getFields();
        Arrays.stream(fields).forEach(System.out::println);
//        int tmp = fields[fields.length - 1].getInt(gaz);
//        fields[fields.length - 1].setInt(gaz, tmp * 2);

        Method[] methods = gaz.getClass().getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }
}
