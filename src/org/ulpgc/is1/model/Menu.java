package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private String name;
    private MenuType type;
    private List<Dish> dishes;

    public Menu(String name, MenuType type) {
        this.name = name;
        this.type = type;
        this.dishes = new ArrayList<Dish>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar en blanco.");
        }
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public List<Dish> getDishes(){
        return this.dishes;
    }

    public void addDish(Dish newDish){
        if (newDish != null) {
            if(!dishes.contains(newDish)) dishes.add(newDish);
        } else {
            throw new IllegalArgumentException("No se puede agregar un plato nulo al menú.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) && type == menu.type && Objects.equals(dishes, menu.dishes);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", dishes=" + dishes.toString() +
                '}';
    }
}


