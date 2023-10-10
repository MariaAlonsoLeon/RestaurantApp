package org.ulpgc.is1.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Phone {
    private String number;




    public Phone(String number) {
        this.number = number;
    }


    public String getNumber() {
        return number;
    }


    public void setNumber(String number) {
        if (this.isValid()) {
            this.number = number;}
        else {
            this.number = "XXXX";
        }
    }

    public boolean isValid(){
        String regex = "^(\\+\\d{1,3})?\\d{10}$"; //Expresión regular para el telefono

        Pattern pattern = Pattern.compile(regex); //Compilamos la expresión regular

        Matcher matcher = pattern.matcher(this.number); //Creamos un objeto Match para el telefono

        return matcher.matches(); //Comprueba si el número de teléfono coincide con el patrón
    }

}

