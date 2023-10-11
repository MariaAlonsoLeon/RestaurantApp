package org.ulpgc.is1.model;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.ulpgc.is1.model.MenuType;

public class Menu {


    private static List<Dish> dishArrayList;

    private String name;
    private String description;
    private MenuType type;


    public Menu(String name, String description, MenuType type) {
        this.name = name;
        this.description = description;
        this.dishArrayList = new ArrayList<>();
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

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public ArrayList<Dish> getDishes(){
        return (ArrayList<Dish>) dishArrayList;
    }

}


