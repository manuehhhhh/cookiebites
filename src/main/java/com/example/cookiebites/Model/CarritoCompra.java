package com.example.cookiebites.Model;

import java.util.ArrayList;

public class CarritoCompra {

    private ArrayList<CarritoItem> carrito = new ArrayList<>();

    public CarritoCompra(){}

    public void agregarCarrito(Producto pro, int cant) {
        CarritoItem item = new CarritoItem(pro, cant);
        this.carrito.add(item);
    }

    public double totalPagar() {
        double total = 0;
        for (CarritoItem car : this.carrito) {
            total += car.getTotal();
        }
        return total;
    }

    public ArrayList<CarritoItem> findAll(){
        return this.carrito;
    }   
}
