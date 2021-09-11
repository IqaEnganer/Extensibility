package domain;

import lombok.Data;

@Data
public class SmartPhone {
    String name;
    String manufacturer;

    public SmartPhone() {
    }

    public SmartPhone(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }
}
