package com.example.cookiebites.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cookiebites.Model.Producto;
import com.example.cookiebites.Repository.listaProductos;

@RestController
public class ControladorProductos {
    @Autowired
    private listaProductos lista;

    
    public ControladorProductos(listaProductos list){
        this.lista = list;
        System.out.println("creado el controlador");
    }

    @GetMapping("/productos")
    ArrayList<Producto> findAll(){
        System.out.println(this.lista);
        return this.lista.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("productos/crear")
    public void agregarProducto(@RequestBody Producto prod){
        System.out.println(prod.toString());
        this.lista.save(prod);
    }

    
}
