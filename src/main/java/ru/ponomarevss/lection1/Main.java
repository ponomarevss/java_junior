package ru.ponomarevss.lection1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        PlainInterface plainInterface = new PlainInterface() {
//            @Override
//            public String action(int x, int y) {
//                return String.valueOf(x + y);
//            }
//        };

//        PlainInterface plainInterface = Integer::sum;
//        PlainInterface plainInterface1 = Integer::compare;
//
//        System.out.println(plainInterface.action(2,3));
//        System.out.println(plainInterface1.action(1,5));

//        List<String> list = Arrays.asList("Привет", "мир", "!", "Я", "родился", "!");
//        list.stream().filter(str -> str.length() > 4).forEach(System.out::println);

//        Stream.of(1, 2, 3, 4, 5).map(integer -> integer * integer).forEach(System.out::println);

//        Stream.of(1, 10, 0, 7, 5).sorted().forEach(System.out::println);

        List<User> list = Arrays.asList(
                new User("Alpha", 25),
                new User("Bravo", 40),
                new User("Charlie", 30)
        );

        list.stream().map(user -> new User(user.name, user.age - 5)).forEach(System.out::println);
    }
}