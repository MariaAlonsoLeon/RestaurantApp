package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.ArrayList;

import static org.ulpgc.is1.model.MenuType.Daily;

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
    }


    public static void init(OrderManager orderManager) {

        //Crear dos objetos de tipo
        Customer customer1 = new Customer("María","La Mejor");
        Customer customer2 = new Customer("Daniel", "Talavera");

        //Crear dos restaturantes
        Restaurant restaurant1 = new Restaurant("Ribera del Rio Miño", new Phone("12345678"));
        Restaurant restaurant2 = new Restaurant("Casa Lucio", new Phone("87654431"));

        //Control + shif + A --> toString
        //Crear tres platos diferentes
        Dish dish1 = new Dish("Carne con papas fritas", "Super plato para cuando estás cansado", 20);
        Dish dish2 = new Dish("Salmon con puré de papas", "El salmon es Noruego y todo, por eso es caro", 40);
        Dish dish3 = new Dish("Solomillo mechado con salsa de champiñones", "Ideal para navidad", 30);


        Menu catalogue;
        catalogue = new Menu("Desayunos", "Disponible de 9:30 a 10:30. Es super ligero", Daily);
        ArrayList<Dish> catalogueList = catalogue.getDishes();
        ArrayList<Dish> orderedDishes = (ArrayList<Dish>) catalogueList.subList(catalogueList.size() - 1, catalogueList.size());




    }
}