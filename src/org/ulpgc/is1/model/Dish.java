package org.ulpgc.is1.model;


public class Dish {


    private String name;
    private String description;
    private int price;


    public Dish(String name, String description, int price) {
        this.name = name;
        this.description = description;
        setPrice(price);
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar en blanco.");
        }
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar en blanco.");
        }

        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio de un plato no puede ser negativo.");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
