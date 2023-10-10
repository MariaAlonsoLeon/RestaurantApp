package org.ulpgc.is1.model;


import java.util.ArrayList;
import java.util.List;

public class Restaurant {


    private String name;
    private Phone phone;
    private List<Menu> menus;


    public Restaurant(String name, Phone phone) {
        this.name = name;
        this.phone = phone;
        menus = new ArrayList<>();
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

    public void addMenu(String name, String description){
        menus.add(new Menu(name, description));
    }

}
