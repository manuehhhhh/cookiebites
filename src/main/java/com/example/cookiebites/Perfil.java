package com.example.cookiebites;

import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.Tuple;

import java.lang.String;
import java.util.ArrayList;

@Component
public class Perfil {
    public String nombreUsuario;
    public String clave;
    public String rol;
    public String correo;
    public ArrayList<Tuple<String, Integer>> carrito;

    public Perfil(){
    }
    public Perfil(String nombreUsuario, String Clave, String rol, String correo){
        this.nombreUsuario = nombreUsuario;
        this.clave = Clave;
        this.rol = rol;
        this.correo = correo;
        this.carrito = new ArrayList<Tuple<String, Integer>>();
    }
    
    public void agregarAlCarrito(String producto, Integer cant){
        this.carrito.add(new Tuple<String,Integer>(producto, cant));
    }
    
}
