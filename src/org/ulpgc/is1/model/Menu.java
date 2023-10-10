package org.ulpgc.is1.model;


import java.util.ArrayList;
import java.util.List;

public class Menu {


    static List<Dish> dishArrayList;

    private String name;


    public Menu(String name) {
        this.name = name;
        dishArrayList = new ArrayList<>();

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public static void addDish(Dish newDish){
        dishArrayList.add(newDish);
    }
}


