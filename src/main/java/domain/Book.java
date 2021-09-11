package domain;

import lombok.Data;

@Data
public class Book extends Product {
    String name;
    String author;

    public Book() {
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
