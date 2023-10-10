package org.ulpgc.is1.model;


import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<OrderItem> orderItems;

    private static int nextID = 0;
    private final int id;


    public Order(int id) {
        this.id = nextID++;
        orderItems = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public int price(){
        //Dish.price * quantity

        int totalPrice = 0;

        for (OrderItem orderItem : orderItems) {
            int quantity = orderItem.getQuantity();
            Dish dish = orderItem.getDish();
            int dishPrice = dish.getPrice();

            // Precio = cantidad * precio del plato
            int itemTotalPrice = quantity * dishPrice;

            // Agrega el precio de este OrderItem al precio total del pedido
            totalPrice += itemTotalPrice;
        }

        return totalPrice;


    }

}
