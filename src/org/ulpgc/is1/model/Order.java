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

            if (quantity < 0) {
                throw new IllegalArgumentException("La cantidad en un OrderItem no puede ser negativa.");
            }

            if (dish == null) {
                throw new IllegalArgumentException("El plato en un OrderItem no puede ser nulo.");
            }

            int dishPrice = dish.getPrice();
            int itemTotalPrice = quantity * dishPrice;
            totalPrice += itemTotalPrice;
        }

        return totalPrice;

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        this.customer = customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        if (restaurant == null) {
            throw new IllegalArgumentException("El restaurante no puede ser nulo.");
        }
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
