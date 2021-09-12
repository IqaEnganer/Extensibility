package domain;

import lombok.Data;

import java.util.Objects;

@Data
public class SmartPhone extends Product {
    private String manufacturer;

    public SmartPhone() {
    }

    public SmartPhone(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public SmartPhone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    public SmartPhone(int id, String name, int price) {
        super(id, name, price);
    }



//    public boolean productSearch(String search) {
//        if (super.productSearch(search)){
//            return true;
//        }
//        if (getManufacturer().contains(search)) {
//            return true;
//        }
//        return false;
//    }
public boolean productSearch(String search) {
    return super.productSearch(search) || getManufacturer().contains(search);
}
}
