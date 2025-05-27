package com.example.cookiebites.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.util.Tuple;

import com.example.cookiebites.Model.Pedido;

import jakarta.annotation.PostConstruct;

@Repository
public class ListaPedidos {

    private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
   
    @PostConstruct
    private void init(){
        System.err.println("Lista Perfil creada");
        listaPedidos.add(new Pedido());
    }

    public ArrayList<Pedido> findAll(){
        return this.listaPedidos;
    }

    public void save(Pedido ped){
        this.listaPedidos.add(ped);
    }
}
