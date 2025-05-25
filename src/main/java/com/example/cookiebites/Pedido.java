package com.example.cookiebites;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.Tuple;

@Component
public class Pedido {
    public String nombreUsuario;
    public String direccion;
    public ArrayList<Tuple<String, Integer>> carrito;
    public LocalDate fechaDeEntrega;
    public boolean confirmado;
    
    public Pedido(){
    }

    public Pedido(String nombreUsuario, String direccion, ArrayList<Tuple<String, Integer>> carrito, LocalDate fechaDeEntrega){
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.carrito = carrito;
        this.fechaDeEntrega = fechaDeEntrega;
    }
}
