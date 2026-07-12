package com.homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Student {
    public static final String msgError = "У студента должно быть не менее 5 книг!";

    private String firstname;
    private String lastname;
    private String groupId;
    private LocalDate birthday;
    private List<Book> books;

    public Student(String firstname, String lastname, LocalDate birthday, String groupId, List<Book> books)
            throws Exception {
        this.firstname = firstname;
        this.lastname = lastname;
        this.groupId = groupId;
        this.birthday = birthday;
        if (books.size() < 5)
            throw new Exception(Student.msgError);
        this.books = books;
    }

    public Student(String firstname, String lastname, LocalDate birthday, String groupId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.groupId = groupId;
        this.birthday = birthday;
        this.books = new ArrayList<Book>();
    }

    public String getFullname() {
        return this.firstname + " " + this.lastname;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public String getBirthdayString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return this.birthday.format(dateFormat);
    }

    @Override
    public String toString() {
        String books = "";
        for (Book book : this.books) {
            books += book + "\n";
        }
        return String.format("Студент: %s\nДата рождения: %s\nГруппа: %s\nКниги: %s%n", this.getFullname(),
                this.getBirthdayString(), this.groupId, books);
    }

    public List<Book> getBooks() {
        return this.books;
    }

    public String getTitleBooks() {
        String result = "";
        for (Book book : this.getBooks()) {
            result += result + book.getTitle() + ";\n";
        }
        return result;
    }
}
