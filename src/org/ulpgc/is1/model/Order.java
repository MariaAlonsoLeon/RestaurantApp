package org.ulpgc.is1.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order {

    private final List<OrderItem> orderItems;

    private static int nextID = 0;
    private final int id;
    private Customer customer;
    private Restaurant restaurant;

    public Order() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems.toString() +
                ", id=" + id +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", prize=" + this.price() +
                '}';
    }
}
