package org.ulpgc.is1.model;


import java.util.Objects;

public class OrderItem {
    private int quantity;
    private Dish dish;


    public OrderItem(int quantity, Dish dish) {
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        else if (dish == null) {
            throw new IllegalArgumentException("El plato no puede ser nulo.");
        }
        this.quantity = quantity;
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish){
        if (dish == null) {
            throw new IllegalArgumentException("El plato no puede ser nulo.");
        }
        this.dish = dish;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", dish=" + dish +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Objects.equals(dish, orderItem.dish);
    }

}

