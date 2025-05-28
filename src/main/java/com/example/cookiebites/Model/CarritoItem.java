package com.example.cookiebites.Model;

public class CarritoItem {
    private Producto producto;
    private int cant;

    public CarritoItem(){}

    public CarritoItem(Producto producto, int cant) {
        this.producto = producto;
        this.cant = cant;
    }

    public double calcularTotal(Producto producto, int cantidad) {
         return producto.getPrecio()*cantidad;
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
        calcularTotal(this.producto, cant);
    }


}
