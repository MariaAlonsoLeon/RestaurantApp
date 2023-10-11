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
        this.name = name;
    }


    public Phone getPhone() {
        return phone;
    }


    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void addMenu(String name, String description, MenuType type) {
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
