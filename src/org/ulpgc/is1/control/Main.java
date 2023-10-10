package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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
        Dish dish2 = new Dish("Salmon con puré de papas", "El salmon es Noruego y todo por eso es caro", 40);
        Dish dish3 = new Dish("Mechas de solomillo con salsa de champiñon", "Ideal para navidad", 30);

    }
}