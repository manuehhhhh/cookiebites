package com.example.cookiebites.Back.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.cookiebites.Back.Model.CarritoCompra;
import com.example.cookiebites.Back.Model.CarritoItem;
import com.example.cookiebites.Back.Repository.ListaCarritos;

@RestController
public class ControladorCarrito {
   
    @Autowired
    private ListaCarritos listaCarritos;

    public ControladorCarrito(ListaCarritos lista){
        this.listaCarritos = lista;
    }

    @PostMapping("carrito/agregar/{id}")
    public ResponseEntity<CarritoItem> agregarProducto(@RequestBody Map<String, Object> body, @PathVariable("id") String nombre) {
        Map<String, Object> productoMap = (Map<String, Object>) body.get("producto");
        String nombreProducto = (String) productoMap.get("nombre");
        int cantidad = (int) body.get("cantidad");

        if (nombreProducto == null || nombreProducto.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        CarritoItem item = new CarritoItem();
        item.setNombreProducto(nombreProducto);
        item.setCantidad(cantidad);

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
