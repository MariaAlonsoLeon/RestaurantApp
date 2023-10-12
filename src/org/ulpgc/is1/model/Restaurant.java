package org.ulpgc.is1.model;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {


    private String name;
    private Phone phone;
    private final List<Menu> menus;


    public Restaurant(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
        this.menus = new ArrayList<>();
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("El nombre del restaurante no puede ser nulo o vacío.");
        }
    }

    public Phone getPhone() {
        return phone;
    }


    public void setPhone(Phone phone) {
        if(!(phone.isValid(phone.getNumber()))){
            throw new IllegalArgumentException("El teléfono es inválido.");
        }

        this.phone = phone;
    }

    public void addMenu(String name, String description, MenuType type) {
        for (Menu menu : menus) {
            if (menu.getName().equals(name)) {
                throw new IllegalArgumentException("Ya existe un menú con el mismo nombre.");
            }
        }

        Menu newMenu = new Menu(name, description, type);
        this.menus.add(newMenu);
    }


    public Menu getMenu(int index){
        return this.menus.get(index);
    }

    @Override
    public String toString() {

        return "Restaurant{" +
                "name='" + name + '\'' +
                ", phone=" + phone.toString() +
                ", menus=" + menus +
                '}';
    }
}
