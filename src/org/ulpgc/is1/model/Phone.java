package org.ulpgc.is1.model;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {
    private String number;
    public Phone(String number) {
        setNumber(number); //Para no repetir código se llama al setter
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (this.isValid(number)) {
            this.number = number;}
        else {
            this.number = "XXXX";
        }
    }

    public boolean isValid(String number){
        String regex = "^(\\+\\d{1,3})?\\d{10}$"; //Expresión regular para el telefono
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches(); //Comprueba si el número de teléfono coincide con el patrón
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return Objects.equals(number, phone.number);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                '}';
    }
}

