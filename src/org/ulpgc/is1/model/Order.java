package org.ulpgc.is1.model;


public class Order {


    private int NEXT_ID = 0;
    private final int id;


    public Order(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


}
