package com.example.cookiebites;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class listaProductos {
    private ArrayList<Producto> listaProductos = new ArrayList<Producto>();

    @PostConstruct
    public void init(){
        ArrayList<String> aux = new ArrayList<String>();
        aux.add("Harina");
        aux.add("Leche");
        aux.add("Huevo");
        aux.add("Mantequilla");
        aux.add("Azucar");
    
        listaProductos.add(new Producto("Galleta de Mantequilla", 20.99 , aux));
        System.out.println("Lista creada");
    }

    public ArrayList<Producto> findAll(){
        return this.listaProductos;
    }

    public void save(Producto prod){
        this.listaProductos.add(prod);
    }
}
