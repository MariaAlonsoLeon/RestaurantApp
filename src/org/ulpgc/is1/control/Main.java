package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        OrderManager orderManager = new OrderManager();

        init(orderManager);

        Restaurant restaurant1 = orderManager.getRestaurant(0);
        Customer customer2 = orderManager.getCustomer(1);
        Dish dish3 = orderManager.getDish(2);


        System.out.println(restaurant1.toString());
        System.out.println(customer2.toString());
        System.out.println(dish3.toString());

        Customer customer1 = orderManager.getCustomer(0);
        System.out.println(restaurant1.toString());
        Menu catalogue = restaurant1.getMenu(0);
        catalogue.toString();

        ArrayList<Dish> catalogueList = catalogue.getDishes();
        ArrayList<Integer> orderedDishesID = new ArrayList<>();

        orderedDishesID.add(catalogueList.size() - 2);
        orderedDishesID.add(catalogueList.size() - 1);

        ArrayList<Integer> quantities = new ArrayList<>();
        quantities.add(2);
        quantities.add(4);

        orderManager.order(customer1, restaurant1, orderedDishesID, quantities);
        orderManager.removeCustomer(1);
        System.out.println("El número de clientes es: " + orderManager.customerQuantity());
        System.out.println(orderManager.getOrder(0).toString());

    }

    public static void init(OrderManager orderManager) {

        // Crear clientes
        orderManager.addCustomer("María", "La Mejor");
        orderManager.addCustomer("Daniel", "Talavera");

        // Crear restaurantes
        orderManager.addRestaturant("Ribera del Rio Miño", new Phone("12345678"));
        orderManager.addRestaturant("Casa Lucio", new Phone("87654431"));

        // Crear platos
        orderManager.addDish("Carne con papas fritas", "Super plato para cuando estás cansado", 20);
        orderManager.addDish("Salmon con puré de papas", "El salmon es Noruego y todo, por eso es caro", 40);
        orderManager.addDish("Solomillo mechado con salsa de champiñones", "Ideal para navidad", 30);


        // Obtener clientes, restaurantes y platos
        Customer customer1 = orderManager.getCustomer(0);
        Customer customer2 = orderManager.getCustomer(1);

        Restaurant restaurant1 = orderManager.getRestaurant(0);
        Restaurant restaurant2 = orderManager.getRestaurant(1);

        Dish dish1 = orderManager.getDish(0);
        Dish dish2 = orderManager.getDish(1);
        Dish dish3 = orderManager.getDish(2);

        // Crear un menú y agregar los platos
        restaurant1.addMenu("Desayunos", "Disponible de 9:30 a 10:30. Es super ligero", MenuType.Daily);
        Menu catalogue = restaurant1.getMenu(0);

        catalogue.addDish(dish1);
        catalogue.addDish(dish2);
        catalogue.addDish(dish3);

    }
}