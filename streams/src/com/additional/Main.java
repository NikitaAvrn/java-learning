package com.additional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
    }

    private static void task10() {
        System.out.println("Task10");
        List<String> list = Arrays.asList("a1", "b2", "c3", "a1");

        // Получение списка без дубликатов
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.toList()));
        // Получить массив строк без дубликатов и в верхнем регистре
        System.out.println(list.stream()
                .distinct()
                // .map(s -> s.toUpperCase())
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
        // Объединить все элементы в одну строку через разделитель: и обернуть тегами
        // <b>… </b>
        System.out.println(list.stream()
                .collect(Collectors.joining(": ", "<b>", "</b>")));
        // Преобразовать в map, где первый символ ключ, второй символ значение
        System.out.println(list.stream()
                .distinct()
                .collect(Collectors.toMap(s -> s.substring(0, 1), s -> s.substring(1, 2))));
        // Преобразовать в map, сгруппировав по первому символу строки
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1))));
        // Преобразовать в map, сгруппировав по первому символу строки и объединим
        // вторые символы через :
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(s -> s.substring(0, 1),
                        Collectors.mapping(p -> p.substring(1, 2), Collectors.joining(":")))));

    }

    private static void task9() {
        System.out.println("Task9");
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        // Получить сумму нечетных чисел
        System.out.println(list.stream()
                .collect(Collectors.summarizingInt(p -> p % 2 == 1 ? p : 0)));
        // Вычесть от каждого элемента 1 и получить среднее
        System.out.println(list.stream()
                .collect(Collectors.averagingInt(p -> p - 1)));
        // Прибавить к числам 3 и получить статистику
        System.out.println(list.stream()
                .collect(Collectors.summarizingInt(p -> p + 3)));
        // Разделить числа на четные и нечетные
        System.out.println(list.stream()
                .collect(Collectors.partitioningBy(p -> p % 2 == 0)));
    }

    private static void task8() {
        System.out.println("Task8");
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2);
        // Получить сумму чисел или вернуть 0
        Integer sum = list.stream()
                .reduce((a, s) -> a + s)
                .orElse(0);
        System.out.println(sum);
        // Вернуть максимум или -1
        Integer max = list.stream()
                .reduce(Integer::max)
                .orElse(-1);
        System.out.println(max);
        // Вернуть сумму нечетных чисел или 0
        Integer sum1 = list.stream()
                .filter(d -> d % 2 != 0)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(sum1);
    }

    private static void task7() {
        System.out.println("Task7");
        List<String> list = Arrays.asList("a1", "a2", "a3", "a1");
        List<People> peoples = List.of(new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN));

        // Найти максимальное значение среди коллекции строк
        System.out.println(list.stream()
                .max(String::compareTo)
                .get());
        // Найти минимальное значение среди коллекции строк
        System.out.println(list.stream()
                .min(String::compareTo)
                .get());
        // Найдем человека с максимальным возрастом
        System.out.println(peoples.stream()
                .max(Comparator.comparing(People::getAge))
                .get());
        // Найдем человека с минимальным возрастом
        System.out.println(peoples.stream()
                .min(Comparator.comparing(People::getAge))
                .get());
    }

    private static void task6() {
        System.out.println("Task6");
        List<String> list = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
        List<People> peoples = List.of(new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMAN),
                new People("Иван Иванович", 69, Sex.MAN));

        // Отсортировать коллекцию строк по алфавиту
        list.stream()
                .sorted()
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        // Отсортировать коллекцию строк по алфавиту в обратном порядке
        list.stream()
                .sorted(Comparator.reverseOrder())
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        // Отсортировать коллекцию строк по алфавиту и убрать дубликаты
        list.stream()
                .distinct()
                .sorted()
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        // Отсортировать коллекцию строк по алфавиту в обратном порядке и убрать
        // дубликаты
        list.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());

        // Отсортировать коллекцию людей по имени в обратном алфавитном порядке
        peoples.stream()
                .sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());

        // Отсортировать коллекцию людей сначала по полу, а потом по возрасту
        peoples.stream()
                .sorted(Comparator.comparing(People::getSex)
                        .thenComparing(People::getAge))
                .peek(p -> System.out.println(p))
                .collect(Collectors.toList());
    }

    private static void task5() {
        System.out.println("Task5");
        List<String> collection1 = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> collection2 = Arrays.asList("1,2,0", "4,5");
        // Добавить "_1" к каждому элементу первой коллекции
        collection1.stream()
                .map(s -> s + "_1")
                .peek(s -> System.out.println(s))
                .collect(Collectors.toList());
        // В первой коллекции убрать первый символ и вернуть массив чисел (int[])
        collection1.stream()
                .mapToInt(s -> Integer.parseInt(s.substring(1)))
                .peek(s -> System.out.println(s))
                .toArray();
        // Из второй коллекции получить все числа, перечисленные через запятую из всех
        // элементов
        collection2.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .mapToInt(s -> Integer.parseInt(s))
                .peek(i -> System.out.println(i))
                .toArray();
        // Из второй коллекции получить сумму всех чисел, перечисленных через запятую
        System.out.println(collection2.stream()
                .flatMap(s -> Stream.of(s.split(",")))
                .mapToInt(s -> Integer.parseInt(s))
                .sum());
    }

    private static void task4() {
        System.out.println("Task4");
        List<String> list = Arrays.asList("a1", "a2", "a3", "a1");
        // Найти существуют ли хоть один "a1" элемент в коллекции
        System.out.println(
                list.stream()
                        // .anyMatch("a1"::equals));
                        .anyMatch(s -> s.equals("a1")));
        // Найти существуют ли хоть один "a8" элемент в коллекции
        System.out.println(
                list.stream()
                        .anyMatch("a8"::equals));
        // Найти есть ли символ "1" у всех элементов коллекции
        System.out.println(
                list.stream()
                        .allMatch(s -> s.contains("1")));
        // Проверить что не существуют ни одного "a7" элемента в коллекции
        System.out.println(
                list.stream()
                        .noneMatch(s -> s.equals("a7")));
    }

    private static void task3() {
        System.out.println("Task 3");
        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);

        // Получение коллекции без дубликатов из неупорядоченного стрима
        List<String> nonOrderedStrings = nonOrdered.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(String.join(", ", nonOrderedStrings));

        // Получение коллекции без дубликатов из упорядоченного стрима
        List<String> orderedStrings = ordered.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(String.join(", ", orderedStrings));

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
                        && ((p.getSex() == Sex.MAN && p.getAge() < 60)
                                || (p.getSex() == Sex.WOMAN && p.getAge() < 55)))
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