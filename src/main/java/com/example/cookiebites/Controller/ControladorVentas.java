package com.example.cookiebites.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.cookiebites.Model.Venta;
import com.example.cookiebites.Repository.ListaVentas;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorVentas {

    @Autowired
    private ListaVentas listaVentas;

    public ControladorVentas(ListaVentas lista) {
        this.listaVentas = lista;
        System.out.println("creado el controlador");
    }

    @GetMapping("/ventas")
    ArrayList<Venta> findAll(){
        System.out.println(this.listaVentas);
        return this.listaVentas.findAll();
    }
}
