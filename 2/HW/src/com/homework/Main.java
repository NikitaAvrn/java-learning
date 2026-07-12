package com.homework;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // StudentLoader loader = new FileTxtStudentLoader("data.txt");
        StudentLoader loader = new FileXMLStudentLoader("data.xml");
        List<Student> students = loader.load();

        students.stream()
                .filter(student -> student.getGroupId().equals("JD26"))
                .flatMap(student -> student.getBooks().stream())
                .filter(book -> book.getTitle().toLowerCase().contains("java"))
                .map(book -> book.getCountPages())
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .ifPresentOrElse(pages -> System.out.printf("Количество страниц в выбранной книге: %d%n", pages),
                        () -> System.out.printf("Подходящих книг про Java не обнаружено"));

        students.stream()
                // Вывести в консоль каждого студента (переопределите toString)
                .peek(student -> System.out.println(student))
                // Получить для каждого студента список книг
                // Получить книги
                .flatMap(student -> student.getBooks().stream())
                // Отсортировать книги по количеству страниц (Не забывайте про условия для
                // сравнения объектов)
                .sorted(Comparator.comparingInt(Book::getCountPages))
                // Оставить только уникальные книги (для работы distinct необходимо
                // переопределить equals и hashCode)
                .distinct()
                // Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
                .filter(book -> book.getReleaseDate().isAfter(LocalDate.of(2000, 12, 31)))
                // Ограничить стрим на 3 элементах
                .limit(3)
                // Получить из книг годы выпуска
                .map(book -> book.getReleaseDate().getYear())
                // При помощи методов короткого замыкания (почитайте самостоятельно что это
                // такое) вернуть Optional от года
                .findFirst()
                // При помощи методов получения значения из Optional вывести в консоль год
                // выпуска найденной книги, либо запись о том, что такая книга отсутствует
                .ifPresentOrElse(
                        year -> System.out.printf("Год выпуска найденной книги: %d%n", year),
                        () -> System.out.println("Такая книга отсутствует"));
    }
}