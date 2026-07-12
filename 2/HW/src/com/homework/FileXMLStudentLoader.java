package com.homework;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class FileXMLStudentLoader implements StudentLoader {
    private String filename;

    public FileXMLStudentLoader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Student> load() {
        List<Student> students = new ArrayList<Student>();

        Path path = Path.of(this.filename);
        try (InputStream inputStream = Files.newInputStream(path)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);
            document.getDocumentElement().normalize();

            NodeList studentNodes = document.getElementsByTagName("student");
            for (int i = 0; i < studentNodes.getLength(); i++) {
                Node studentNode = studentNodes.item(i);
                if (studentNode.getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element studentElement = (Element) studentNode;
                String firstname = studentElement.getElementsByTagName("firstname").item(0).getTextContent();
                String lastname = studentElement.getElementsByTagName("lastname").item(0).getTextContent();
                String groupId = studentElement.getElementsByTagName("groupId").item(0).getTextContent();
                LocalDate birthdate = LocalDate
                        .parse(studentElement.getElementsByTagName("birthdate").item(0).getTextContent());

                Student student = new Student(firstname, lastname, birthdate, groupId);
                NodeList bookNodes = studentElement.getElementsByTagName("book");
                for (int j = 0; j < bookNodes.getLength(); j++) {
                    Element bookElement = (Element) bookNodes.item(j);
                    String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                    String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                    LocalDate releaseDate = LocalDate
                            .parse(bookElement.getElementsByTagName("releaseDate").item(0).getTextContent());
                    Integer countPages = Integer
                            .parseInt(bookElement.getElementsByTagName("countPages").item(0).getTextContent());

                    Book book = new Book(title, author, releaseDate, countPages);
                    student.getBooks().add(book);
                }
                students.add(student);
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла. " + e.getMessage());
        }

        return students;
    }
}
