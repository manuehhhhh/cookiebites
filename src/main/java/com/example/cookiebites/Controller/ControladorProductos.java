package com.example.cookiebites.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.cookiebites.Model.Producto;
import com.example.cookiebites.Repository.ListaProductos;


@RestController
public class ControladorProductos {
    @Autowired
    private ListaProductos listaProductos;

    
    public ControladorProductos(ListaProductos list){
        this.listaProductos = list;
        System.out.println("creado el controlador");
    }

     @GetMapping("productos/buscar/{nombre}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable String nombre) {
        Producto producto = listaProductos.consultaProducto(nombre);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/productos")
    ArrayList<Producto> findAll(){
        System.out.println(this.listaProductos);
        return this.listaProductos.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("productos/crear")
    public void agregarProducto(@RequestBody Producto prod){
        System.out.println(prod.toString());
        this.listaProductos.save(prod);
    }    
}
