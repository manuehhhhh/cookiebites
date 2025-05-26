package com.example.cookiebites.Model;

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

    public Perfil(String nombreUsuario, String clave, String rol, String correo){
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rol = rol;
        this.correo = correo;
        this.carrito = new ArrayList<Tuple<String, Integer>>();
    }

    public void agregarAlCarrito(String producto, Integer cant){
        this.carrito.add(new Tuple<String,Integer>(producto, cant));
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
