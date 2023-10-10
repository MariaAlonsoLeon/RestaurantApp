package org.ulpgc.is1.model;


public class Order {


    private static int nextID = 0;
    private final int id;


    public Order(int id) {
        this.id = nextID++;
    }


    public int getId() {
        return id;
    }


}
