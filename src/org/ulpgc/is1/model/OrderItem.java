package org.ulpgc.is1.model;


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

    //Método nuevo

    @Override
    public String toString() {
        return "OrderItem{" +
                "quantity=" + quantity +
                ", dish=" + dish +
                '}';
    }
}

