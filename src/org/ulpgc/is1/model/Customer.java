package org.ulpgc.is1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {

    private String name;
    private String surname;
    private List<Order> orders;
    private Address address;

    public Customer(String name, String surname, String street, int number, int postalCode, String city) {
        //Validar el nombre y apellido
        if (name == null || name.trim().isEmpty() || surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden estar en blanco.");
        }
        this.name = name;
        this.surname = surname;
        this.orders = new ArrayList<>();

        // Validar y crear la dirección
        if (street == null || street.trim().isEmpty() || number < 0 || postalCode < 0 || city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("Los datos de dirección no son válidos.");
        }
        this.address = new Address(street, number, postalCode, city);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar en blanco.");
        }
        this.surname = surname;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public Order getOrder(int index){
        return orders.get(index);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname) && Objects.equals(orders, customer.orders) && Objects.equals(address, customer.address);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", orders=" + orders.toString() +
                ", address=" + address.toString() +
                '}';
    }
}
