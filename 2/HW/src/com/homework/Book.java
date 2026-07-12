package com.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private String author;
    private String title;
    private Integer countPages;
    private LocalDate releaseDate;

    public Book(String title, String author, LocalDate releaseDate, Integer countPages) {
        this.title = title;
        this.author = author;
        this.countPages = countPages;
        this.releaseDate = releaseDate;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getCountPages() {
        return this.countPages;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public String getReleaseDateString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.releaseDate.format(dateFormat);
    }

    @Override
    public String toString() {
        return String.format("Книга: %s; Автор: %s; Количество страниц: %d; Дата выхода: %s", this.title, this.author,
                this.countPages, this.getReleaseDateString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Book book = (Book) o;
        return countPages == book.countPages &&
                title.equals(book.title) &&
                author.equals(book.author) &&
                releaseDate.equals(book.releaseDate);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, author, releaseDate, countPages);
    }
}
