package com.example.cookiebites;

import java.util.ArrayList;
import org.springframework.stereotype.Component;
import java.lang.String;

@Component
public class Producto {
    public String nombre;
    public double precio;
    public ArrayList<String> ingredientes;


    public Producto(){

    }
    public Producto(String nombre, double precio, ArrayList<String> ingredientes){
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }
}
