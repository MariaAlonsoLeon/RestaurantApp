package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {
    private String name;
    private MenuType type;
    private List<Dish> dishes;

    public Menu(String name, MenuType type, List<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
        this.type = type;
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

    public void addDish(Dish newDish){
        if (newDish != null) {
            if(!dishes.contains(newDish)) dishes.add(newDish);
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

    public List<Dish> getDishes(){
        return this.dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name) && type == menu.type;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}


