package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        OrderManager orderManager = new OrderManager();

        init(orderManager);

        Restaurant restaurant1 = orderManager.getRestaurant(0);
        Customer customer2 = orderManager.getCustomer(1);
        Dish dish3 = orderManager.getDish(2);

        //Imprimir datos del restaurante1, cliente2 y plato3
        System.out.println(restaurant1.toString());
        System.out.println(customer2.toString());
        System.out.println(dish3.toString());

        //Crear un pedido del cliente1 al restaurante1 que incluye los dos últimos platos.
        Customer customer1 = orderManager.getCustomer(0);
        System.out.println(restaurant1.toString());
        Menu catalogue = restaurant1.getMenu(0);
        catalogue.toString();

        ArrayList<Dish> catalogueList = (ArrayList<Dish>) catalogue.getDishes();
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

        //Comprobación para acceder desde customer a order cumpliendo la navegabilidad
        System.out.println(customer1.getOrder());

    }

    public static void init(OrderManager orderManager) {

        // Crear clientes
        orderManager.addCustomer("María", "La Mejor", new ArrayList<Order>(), "California", 56, 35010, "Las Palmas de Gran Canaria");
        orderManager.addCustomer("Daniel", "Talavera", new ArrayList<Order>(), "La Habana", 10 , 35010, "Las Palmas de Gran Canaria");

        // Crear restaurantes
        Menu catalogue1 = new Menu("Desayunos", MenuType.Daily, new ArrayList<Dish>());

        ArrayList<Menu> menus1 = new ArrayList<>();
        menus1.add(catalogue1);

        Menu catalogue2 = new Menu("Cenas", MenuType.Kids, new ArrayList<>());
        ArrayList<Menu> menus2 = new ArrayList<>();
        menus2.add(catalogue1);

        orderManager.addRestaturant("Ribera del Rio Miño", new Phone("12345678"), menus1, new ArrayList<Order>());
        orderManager.addRestaturant("Casa Lucio", new Phone("87654431"), menus2, new ArrayList<Order>());

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

        // Agregar los platos al menu del restaurante 1
        catalogue1.addDish(dish1);
        catalogue1.addDish(dish2);
        catalogue1.addDish(dish3);

    }
}