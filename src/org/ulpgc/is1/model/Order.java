package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
    private List<OrderItem> orderItems;
    private static int NEXT_ID = 0;
    private final int id;

    public Order() {
        this.id = NEXT_ID++;
        orderItems = new ArrayList<OrderItem>();
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
            int itemTotalPrice = quantity * dishPrice;
            totalPrice += itemTotalPrice;
        }

        return totalPrice;
    }

    public List<OrderItem> getOrderItems(){
        return this.orderItems;
    }

    public void addOrderItem(OrderItem orderItem){
        if(!orderItems.contains(orderItem)) orderItems.add(orderItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(orderItems, order.orderItems);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderItems=" + orderItems.toString() +
                ", id=" + id +
                ", prize=" + this.price() +
                '}';
    }
}
