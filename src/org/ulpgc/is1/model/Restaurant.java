package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {

    private String name;
    private Phone phone;
    private final List<Menu> menus;
    private final List<Order> orders;

    public Restaurant(String name, Phone phone, ArrayList<Menu> menus) {
        this.name = name;
        this.phone = phone;
        this.orders = new ArrayList<>();

        if (menus.isEmpty()) {
            throw new IllegalArgumentException("Debe haber al menos un menú en el restaurante.");
        }

        this.menus = menus;
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

    public Menu getMenu(int index){
        return this.menus.get(index);
    }

    public void addMenu(String name, MenuType type) {
        Menu newMenu = new Menu(name, type);
        if(!menus.contains(newMenu)) menus.add(newMenu); //No puede haber menus repetidos
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && Objects.equals(menus, that.menus) && Objects.equals(orders, that.orders);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", phone=" + phone.toString() +
                ", menus=" + menus.toString() +
                ", orders=" + orders.toString() +
                '}';
    }
}
