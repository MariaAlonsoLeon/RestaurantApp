package org.ulpgc.is1.model;


public class Address {


    private String street;
    private int number;
    private int postalCode;
    private String city;


    public Address(String street, int number, int postalCode, String city) {
        if (number < 0 || postalCode < 0) {
            throw new IllegalArgumentException("El número y el código postal no pueden ser valores negativos.");
        }
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("La calle no puede estar en blanco.");
        }
        this.street = street;
    }


    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public int getPostalCode() {
        return postalCode;
    }


    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede estar en blanco.");
        }

        this.city = city;
    }
}
