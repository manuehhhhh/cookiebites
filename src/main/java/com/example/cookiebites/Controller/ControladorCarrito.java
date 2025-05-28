package com.example.cookiebites.Controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.cookiebites.Model.CarritoCompra;
import com.example.cookiebites.Model.CarritoItem;
import com.example.cookiebites.Model.Producto;

@RestController
public class ControladorCarrito {
   

    private CarritoCompra carrito;

    public ControladorCarrito(){}

     @PostMapping("carrito/agregar")
    public ResponseEntity<CarritoItem> agregarProducto(@RequestBody Producto pro, @RequestParam int cant) {
        CarritoItem nuevoProducto = new CarritoItem(pro, cant);
        carrito.agregarCarrito(nuevoProducto);
        return ResponseEntity.ok(nuevoProducto);   
    } 
}
