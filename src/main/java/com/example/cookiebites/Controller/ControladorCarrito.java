package com.example.cookiebites.Controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.cookiebites.Model.CarritoCompra;
import com.example.cookiebites.Model.CarritoItem;
import com.example.cookiebites.Model.Producto;
import com.example.cookiebites.Repository.ListaCarritos;

@RestController
public class ControladorCarrito {
   
    @Autowired
    private ListaCarritos listaCarritos;

    public ControladorCarrito(ListaCarritos lista){
        this.listaCarritos = lista;
    }

    @PostMapping("carrito/agregar/{id}")
    public ResponseEntity<CarritoItem> agregarProducto(@RequestBody CarritoItem item, @PathVariable("id") String nombre) {
        if (listaCarritos.findByName(nombre) == null){
            listaCarritos.save(new CarritoCompra(nombre));
        }
        listaCarritos.findByName(nombre).agregarCarrito(item);
        return ResponseEntity.ok(item);   
    }

    @GetMapping("carrito/leer/{id}")
    public ResponseEntity<ArrayList<CarritoItem>> verCarrito(@PathVariable("id") String nombre) {
        if (listaCarritos.findByName(nombre) == null){
            listaCarritos.save(new CarritoCompra(nombre));
        }
        return ResponseEntity.ok(listaCarritos.findByName(nombre).findAll());   
    }

    // @PostMapping("carrito/agregar")
    // public ResponseEntity<CarritoItem> agregarProducto(@RequestBody Producto pro, @RequestParam int cant) {
    //     CarritoItem nuevoProducto = new CarritoItem(pro, cant);
    //     carrito.agregarCarrito(nuevoProducto);
    //     return ResponseEntity.ok(nuevoProducto);   
    // } 
}
