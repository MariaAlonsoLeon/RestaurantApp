package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {


    private final List<Restaurant> restaurants;
    private final List<Dish> dishes;
    private final List<Customer> customers;


    public OrderManager() {

        restaurants = new ArrayList<>();
        dishes = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addCustomer(String name, String surname){
        customers.add(new Customer(name, surname));
    }

    public void addDishes(String name, String description, int price){
        dishes.add(new Dish(name, description, price));
    }

    public void addRestaturant(String name, Phone phone){
        restaurants.add(new Restaurant(name, phone));
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }
    public Dish getDish(int index){
        return dishes.get(index);
    }

    public Restaurant getRestaurant(int index){
        return restaurants.get(index);
    }


}
