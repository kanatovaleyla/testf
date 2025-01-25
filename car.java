package model;

import java.math.BigDecimal;

public class Car {
    private int id;
    private String name;
    private String engineType;
    private BigDecimal price;
    private int productionYear;

    public Car(int id, String name, String engineType, BigDecimal price, int productionYear) {
        this.id = id;
        this.name = name;
        this.engineType = engineType;
        this.price = price;
        this.productionYear = productionYear;
    }

    @Override
    public String toString() {
        return "Car{id=" + id + ", name='" + name + "', engineType='" + engineType + "', price=" + price + ", year=" + productionYear + "}";
    }
}
