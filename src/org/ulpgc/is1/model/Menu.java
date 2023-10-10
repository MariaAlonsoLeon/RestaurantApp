package org.ulpgc.is1.model;


import java.util.ArrayList;
import java.util.List;

public class Menu {


    static List<Dish> dishArrayList;
    private String name;
    private String description;


    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
        dishArrayList = new ArrayList<>();

    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static void addDish(Dish newDish){
        dishArrayList.add(newDish);
    }

}


