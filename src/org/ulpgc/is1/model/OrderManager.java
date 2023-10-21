package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private final List<Restaurant> restaurants;
    private final List<Dish> dishes;
    private final List<Customer> customers;
    private final List<Order> orders;

    public OrderManager() {
        restaurants = new ArrayList<>();
        dishes = new ArrayList<>();
        customers = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addCustomer(String name, String surname, List<Order> orders, String street, int number, int postalCode, String city){
        if (name != null || surname != null || number >= 0 || postalCode >= 0) {
            Customer newCustomer = new Customer(name, surname, orders, street, number, postalCode, city);
            if(!customers.contains(newCustomer)) customers.add(newCustomer);
        } else {
            throw new IllegalArgumentException("Nombre, apellidos, número o código postal inválidos");
        }
    }

    public void addDish(String name, String description, int price){
        if (name != null && description != null && price > 0) {
            Dish newDish = new Dish(name, description, price);
            if(!dishes.contains(newDish)) dishes.add(newDish);
        } else {
            throw new IllegalArgumentException("Nombre, descripción o precio inválidos");
        }
    }

    public void addRestaturant(String name, Phone phone, List<Menu> menus, List<Order> orders){
        if (name != null && phone != null) {
            Restaurant newRestaurant = new Restaurant(name, phone, menus, orders);
            if(!restaurants.contains(newRestaurant)) restaurants.add(newRestaurant);
        } else if (menus.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un menú en el restaurante.");
        } else {
            throw new IllegalArgumentException("Nombre o teléfono del restaurante no pueden ser nulos");
        }
    }

    public Customer getCustomer(int index){
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice de cliente fuera de rango");
        }
    }

    public Dish getDish(int index){
        if (index >= 0 && index < dishes.size()) {
            return dishes.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice de plato fuera de rango");
        }
    }

    public Restaurant getRestaurant(int index){
        if (index >= 0 && index < restaurants.size()) {
            return restaurants.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice de restaurante fuera de rango");
        }
    }

    public void order(Customer customer, Restaurant restaurant, ArrayList<Integer> dishesId, ArrayList<Integer> quantities) {
        if (customer == null || restaurant == null) {
            throw new IllegalArgumentException("Cliente o restaurante inválido");
        }

        // Crear un nuevo pedido
        Order newOrder = new Order();

        //Asignar el pedido al cliente
        customer.addOrder(newOrder);

        // Asignar los platos y cantidades
        if (dishesId.size() != quantities.size()) {
            throw new IllegalArgumentException("Cantidad de platos o id de platos incorrectos");
        }

        for (int i = 0; i < dishesId.size(); i++) {
            int dishId = dishesId.get(i);
            int quantity = quantities.get(i);

            if (dishId >= 0 && dishId < dishes.size()) {
                Dish dish = dishes.get(dishId);
                OrderItem orderItem = new OrderItem(quantity, dish);
                newOrder.addOrderItem(orderItem);
            } else {
                throw new IllegalArgumentException("ID de plato inválido");
            }
        }


        //if(!orders.contains(newOrder)) orders.add(newOrder);
        orders.add(newOrder);
    }

    public void removeCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            customers.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Índice de cliente a eliminar fuera de rango");
        }

    }

    public int customerQuantity(){
        return customers.size();
    }

    public Order getOrder(int index){

        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        } else {
            throw new IndexOutOfBoundsException("Índice de pedido fuera de rango");
        }
    }
}
