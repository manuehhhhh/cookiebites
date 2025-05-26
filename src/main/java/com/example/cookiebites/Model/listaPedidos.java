package com.example.cookiebites.Model;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.util.Tuple;



import jakarta.annotation.PostConstruct;

@Repository
public class listaPedidos {
    private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

    @PostConstruct
    private void init(){
        System.err.println("Lista Perfil creada");
        listaPedidos.add(new Pedido("Manuel12", "barquisimeto, Av principal", new ArrayList<Tuple<String, Integer>>(), LocalDate.now()));
    }

    public ArrayList<Pedido> findAll(){
        return this.listaPedidos;
    }

    public void save(Pedido ped){
        this.listaPedidos.add(ped);
    }
}
