package domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Book extends Product {
    String author;


    public Book() {
    }

    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public Book(int id, String name, int price) {
        super(id, name, price);
    }



//    public boolean productSearch(String search) {
//        if (super.productSearch(search)) {
//            return true;
//        }
//        if (getAuthor().contains(search)) {
//            return true;
//        }
//        return false;
//    }
public boolean productSearch(String search) {
    return super.productSearch(search) || getAuthor().contains(search);
}

}
