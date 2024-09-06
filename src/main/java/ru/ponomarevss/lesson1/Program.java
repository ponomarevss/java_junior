package ru.ponomarevss.lesson1;

import java.util.Arrays;
import java.util.List;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 * */
public class Program {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-24, 13, 0, 19, -33, 5, 44, -12, 31, -50, 27, -3, 48, -18, 10);
        System.out.println(numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum()
        );
    }
}
