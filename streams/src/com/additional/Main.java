package com.additional;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // task1();
        // task2();
        task3();
    }

    private static void task3() {
        Collection ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection nonOrdered = new HashSet<>(ordered);

        nonOrdered.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static void task2() {
        System.out.println("Task 2");
        List<People> peoples = List.of(new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN));

        // Выбрать мужчин-военнообязанных (от 18 до 27 лет)
        List<People> army = peoples.stream()
                .filter(p -> p.getSex().equals(Sex.MAN) && p.getAge() >= 18 && p.getAge() < 27)
                // .toArray(People[]::new);
                .collect(Collectors.toList());
        for (People p : army) {
            System.out.println(p);
        }
        // Найти средний возраст среди мужчин
        double avg = peoples.stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble();
        System.out.println(String.format("Срединй возраст мужчин %.2f", avg));
        // Найти кол-во потенциально работоспособных людей в выборке (т.е. от 18 лет и
        // учитывая что женщины выходят в 55 лет, а мужчина в 60)
        long countWorkers = peoples.stream()
                .filter(p -> p.getAge() >= 18
                        && ((p.getSex() == Sex.MAN && p.getAge() < 60) || (p.getSex() == Sex.WOMAN && p.getAge() < 55)))
                .count();
        System.out.println(String.format("Количество потенциально работоспособных людей %d", countWorkers));
    }

    private static void task1() {
        System.out.println("Task 1");
        List<String> list = List.of("a1", "a2", "a3", "a1");

        // Вернуть количество вхождений объекта "a1"
        long count = list.stream()
                .filter("a1"::equals)
                .count();
        System.out.println(count);

        // Вернуть первый элемент коллекции или 0, если коллекция пуста
        String firstElement = list.stream()
                .findFirst()
                .orElse("0");
        System.out.println(firstElement);

        // Вернуть последний элемент коллекции или "empty", если коллекция пуста
        String lastElement = list.stream()
                .skip(list.size() - 1)
                .findAny()
                .orElse("empty");
        System.out.println(lastElement);

        // Найти элемент в коллекции равный "a3" или кинуть ошибку
        String elementA3 = list.stream()
                .filter("a3"::equals)
                .findFirst()
                .get();
        System.out.println(elementA3);

        // Вернуть третий элемент коллекции по порядку
        String element3 = list.stream()
                .skip(2)
                .findFirst()
                .get();
        System.out.println(element3);

        // Вернуть два элемента начиная со второго
        String[] take2first2 = list.stream()
                .skip(1)
                .limit(2)
                .toArray(String[]::new);
        System.out.println(String.join(", ", take2first2));

        // Выбрать все элементы по шаблону
        String[] strByTemp = list.stream()
                .filter(n -> n.contains("1"))
                .toArray(String[]::new);
        System.out.println(String.join(", ", strByTemp));
    }
}