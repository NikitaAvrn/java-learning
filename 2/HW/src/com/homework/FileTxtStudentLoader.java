package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.time.LocalDate;
import java.nio.file.Files;

public class FileTxtStudentLoader implements StudentLoader {
    private String filename;

    public FileTxtStudentLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Student> load() {
        Path path = Path.of(this.filename);
        List<Student> students = new ArrayList<Student>();
        try {
            List<String> lines = Files.readAllLines(path);
            Student student = null;
            for (String line : lines) {
                String[] fields = line.split(";");
                if (fields[0].equals("Student")) {
                    if (student != null) {
                        if (student.getBooks().size() < 5)
                            throw new Exception(Student.msgError);
                        students.add(student);
                    }
                    student = new Student(fields[1], fields[2], LocalDate.parse(fields[3]), fields[4]);
                }
                if (fields[0].equals("Book"))
                    student.getBooks().add(
                            new Book(fields[1], fields[2], LocalDate.parse(fields[3]), Integer.parseInt(fields[4])));
            }
            students.add(student);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return students;
    }
}