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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar en blanco.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar en blanco.");
        }
        this.description = description;
    }


    public static void addDish(Dish newDish){

        if (newDish != null) {
            dishArrayList.add(newDish);
        } else {
            throw new IllegalArgumentException("No se puede agregar un plato nulo al menú.");
        }
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        if (!(type instanceof MenuType)) {
            throw new IllegalArgumentException("Tipo no válido.");
        }

        this.type = type;
    }

    public ArrayList<Dish> getDishes(){
        return (ArrayList<Dish>) dishArrayList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}


