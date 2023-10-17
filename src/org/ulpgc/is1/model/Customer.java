package org.ulpgc.is1.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {


    private String name;
    private String surname;


    public Customer(String name, String surname) {
        if (name == null || name.trim().isEmpty() || surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden estar en blanco.");
        }

        this.name = name;
        this.surname = surname;
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

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(surname, customer.surname);
    }

}
