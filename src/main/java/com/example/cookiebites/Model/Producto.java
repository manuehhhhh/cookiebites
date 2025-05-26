package com.example.cookiebites.Model;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import java.lang.String;

@Component
public class Producto {
    public String nombre;
    public double precio;
    public ArrayList<String> ingredientes = new ArrayList<>();


    public Producto(){}

    public Producto(String nombre, double precio, ArrayList<String> ingredientes){
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
