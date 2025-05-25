package com.example;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.cookiebites.Pedido;
import com.example.cookiebites.listaPedidos;

@RestController
public class controladorPedidos {
    @Autowired
    private listaPedidos lista;
    
    @Autowired
    public controladorPedidos(listaPedidos lista){
        this.lista = lista;
    }

    @GetMapping("/pedidos")
    ArrayList<Pedido> findAll(){
        System.out.println(this.lista);
        return this.lista.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("pedido/crear")
    public void agregarProducto(@RequestBody Pedido ped){
        System.out.println(ped.toString());
        this.lista.save(ped);
    }
}
