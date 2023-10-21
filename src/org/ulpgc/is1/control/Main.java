package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        OrderManager orderManager = new OrderManager();

        init(orderManager);

        Restaurant restaurant1 = orderManager.getRestaurant(0);
        Customer customer2 = orderManager.getCustomer(1);
        Dish dish3 = orderManager.getDish(2);

        //Imprimir datos del restaurante1, cliente2 y plato3
        System.out.println(restaurant1.toString() + "\n");
        System.out.println(customer2.toString() + "\n");
        System.out.println(dish3.toString() + "\n");

        //Crear un pedido del cliente1 al restaurante1 que incluye los dos últimos platos.
        Customer customer1 = orderManager.getCustomer(0);
        Menu catalogue = restaurant1.getMenu(0);


        ArrayList<Dish> catalogueList = (ArrayList<Dish>) catalogue.getDishes(); //Sacamos todos los platos del menu
        ArrayList<Integer> orderedDishesIndexes = new ArrayList<>(); //Creamos una lista con los índices de dish2 y dish3
        orderedDishesIndexes.add(catalogueList.size() - 2);
        orderedDishesIndexes.add(catalogueList.size() - 1);


        ArrayList<Integer> quantities = new ArrayList<>(); //Creamos una lista con las cantidades ficticias de cada plato
        quantities.add(2);
        quantities.add(4);

        orderManager.order(customer1, restaurant1, orderedDishesIndexes, quantities); //Formalizamos el pedido

        //Eliminamos al segundo cliente
        orderManager.removeCustomer(1);

        //Imprimir el número de clientes
        System.out.println("El número de clientes es: " + orderManager.customerQuantity() + "\n");

        //Imprimir el pedido anteriormente creado
        System.out.println(customer1.getOrder(0).toString() + "\n");

        //Comprobación para acceder desde customer a order cumpliendo la navegabilidad
        System.out.println(customer1.getOrders() + "\n");


        //Comprobaciones extras
        ArrayList<Dish> catalogueList2 = (ArrayList<Dish>) catalogue.getDishes();
        ArrayList<Integer> orderedDishesIndexes2 = new ArrayList<>();
        orderedDishesIndexes2.add(catalogueList2.size() - 1);  // Seleccionamos el último plato (dish3) del menú.

        ArrayList<Integer> quantities2 = new ArrayList<>();
        quantities2.add(3);  // Cantidad ficticia para dish3

        orderManager.order(customer2, restaurant1, orderedDishesIndexes2, quantities2);
        System.out.println(customer2.getOrder(0).toString() + "\n");

    }

    public static void init(OrderManager orderManager) {

        // Crear clientes
        orderManager.addCustomer("María", "La Mejor", "Calle1", 10, 35010, "Las Palmas de Gran Canaria");
        orderManager.addCustomer("Daniel", "Talavera", "Calle2", 10 , 35010, "Las Palmas de Gran Canaria");

        // Crear restaurantes
        Menu catalogue1 = new Menu("Desayunos", MenuType.Daily);
        ArrayList<Menu> menus1 = new ArrayList<>();
        menus1.add(catalogue1);

        Menu catalogue2 = new Menu("Cenas", MenuType.Kids);
        ArrayList<Menu> menus2 = new ArrayList<>();
        menus2.add(catalogue2);

        orderManager.addRestaturant("Ribera del Rio Miño", new Phone("1234567890"), menus1);
        orderManager.addRestaturant("Casa Lucio", new Phone("9876544310"), menus2);

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