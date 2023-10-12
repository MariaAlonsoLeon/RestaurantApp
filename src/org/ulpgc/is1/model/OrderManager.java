package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {


    private final List<Restaurant> restaurants;
    private final List<Dish> dishes;
    private final List<Customer> customers;

    //Lista nueva creada
    private final List<Order> orders;



    public OrderManager() {

        restaurants = new ArrayList<>();
        dishes = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addCustomer(String name, String surname){
        customers.add(new Customer(name, surname));
    }

    public void addDish(String name, String description, int price){
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

    public void order(Customer customer, Restaurant restaurant, ArrayList<Integer> dishesId, ArrayList<Integer> quantity){

        //Controlamos exepciones
        if (customer == null || restaurant == null) {
            throw new IllegalArgumentException("Cliente o restaurante inválido");
        }

        //Creamos un pedido
        Order newOrder;

        if(orders.isEmpty()){
            newOrder = new Order(0);
        }
        else{
            newOrder = new Order(orders.indexOf(orders.size()) + 1);
        }

        //Le asignamos un cliente y restaurante

        newOrder.setCustomer(customer);
        newOrder.setRestaurant(restaurant);

        //Le asignamos los platos


        if(dishesId.size() != quantity.size()){
            throw new IllegalArgumentException("Cantidad de platos o id de platos incorrectos");
        }


        for(int i = 0; i < dishesId.size(); i++){
            Dish dish = getDish(i);
            if (dish != null) {
                OrderItem orderItem = new OrderItem(quantity.indexOf(i), dish);
                newOrder.addOrderItem(orderItem);
            }
        }

    }

    public void removeCustomer(int index) {
        customers.remove(index);
    }

    public int customerQuantity(){
        return customers.size();
    }

}
