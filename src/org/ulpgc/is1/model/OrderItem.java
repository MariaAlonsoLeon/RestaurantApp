package org.ulpgc.is1.model;


public class OrderItem {
    private int quantity;
    private Dish dish; //Atributo nuevo


    public OrderItem(int quantity, Dish dish) {
        this.quantity = quantity;
        this.dish = dish;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //Método nuevo
    public Dish getDish() {
        return this.dish;
    }



}

