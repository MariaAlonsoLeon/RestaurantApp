package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Restaurant> restaurants;
    private List<Dish> dishes;
    private List<Customer> customers;

    public OrderManager() {
        restaurants = new ArrayList<>();
        dishes = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addCustomer(String name, String surname, String street, int number, int postalCode, String city){
        if (name != null && surname != null && number >= 0 && postalCode >= 0) {
            Customer newCustomer = new Customer(name, surname, street, number, postalCode, city);
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

    public void addRestaturant(String name, Phone phone, ArrayList<Menu> menus){
        if (name == null || name.trim().isEmpty() || phone == null) {
            throw new IllegalArgumentException("Nombre o teléfono del restaurante no pueden ser nulos");
        }
        if (menus.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un menú en el restaurante.");
        }
        Restaurant newRestaurant = new Restaurant(name, phone, menus);
        if (!restaurants.contains(newRestaurant)) {
            restaurants.add(newRestaurant);
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
        /*Este método se utiliza para crear un pedido y vincularlo con un cliente y su restaurante. Para ello,
        * se hace uso de las listas dishesId y quantities. La primera de ellas contiene los índices de los platos en la
        * lista principal dishes. La segunda de ellas contiene las cantidades de los platos, correpondiéndose las posiciones
        * de forma que se relacione la cantidad con el índice del plato. Por ejemplo, */


        //Controlar excepciones
        if (customer == null || restaurant == null) {
            throw new IllegalArgumentException("Cliente o restaurante inválido");
        }
        if (dishesId.size() != quantities.size()) {
            throw new IllegalArgumentException("Cantidad de platos o id de platos incorrectos");
        }

        // Crear un nuevo pedido
        Order newOrder = new Order();

        //Asignar el pedido al cliente
        customer.addOrder(newOrder);

        // Asignar los platos y cantidades

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

        restaurant.addOrder(newOrder);
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

}
