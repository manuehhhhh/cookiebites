package com.example.cookiebites.Back.Model;

import java.util.ArrayList;

//hjgfui
public class CarritoCompra {

    private ArrayList<CarritoItem> carrito = new ArrayList<>();
    public String usuario; 
    public CarritoCompra(String Usuario){
        this.usuario = Usuario;
    }

    public void agregarCarrito(CarritoItem item) {
        boolean encontrado = false;
        for (CarritoItem existente : this.carrito) {
            if (existente.getProducto().getNombre().equals(item.getProducto().getNombre())) {
                existente.setCantidad(existente.getCantidad()+item.getCantidad());
                encontrado = true;
                break;
            }
        }
        if (!encontrado)
        this.carrito.add(item);
    }

    public double totalPagar() {
        double total = 0;
        for (CarritoItem car : this.carrito) {
            total += car.calcularTotal();
        }
        return total;
    }

    public ArrayList<CarritoItem> findAll(){
        return this.carrito;
    }   
}
