package org.ulpgc.is1.model;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Menu {


    static List<Dish> dishArrayList;
    private String name;
    private String description;
    private Type type;


    public Menu(String name, String description, Type type) {
        this.name = name;
        this.description = description;
        dishArrayList = new ArrayList<>();
        this.type = type;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}


