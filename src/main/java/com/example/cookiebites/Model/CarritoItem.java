package com.example.cookiebites.Model;

public class CarritoItem {
    private Producto producto;
    private int cant;
    private double total;

    public CarritoItem(){}

    public CarritoItem(Producto producto, int cant) {
        this.producto = producto;
        this.cant = cant;
        this.total = calcularTotal(producto, cant);
    }

    public double calcularTotal(Producto producto, int cantidad) {
         return producto.precio*cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cant;
    }

    public void setCantidad(int cant) {
        this.cant = cant;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    } 
}
