package domain;

import lombok.Data;

@Data
public class Product {
    int id;
    String name;
    int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
