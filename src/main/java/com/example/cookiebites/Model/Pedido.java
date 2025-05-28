package com.example.cookiebites.Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    public String nombreUsuario;
    public String direccion;
    public CarritoCompra carrito;
    public ArrayList<CarritoItem> compra = new ArrayList<>();
    public LocalDate fechaDeEntrega;
    public EstadoPedido estado;
    
    public Pedido(){}

    public Pedido(String nombreUsuario, String direccion,CarritoCompra carrito,ArrayList<CarritoItem> compra, LocalDate fechaDeEntrega, EstadoPedido estado){
        this.nombreUsuario = nombreUsuario;
        this.direccion = direccion;
        this.fechaDeEntrega = fechaDeEntrega;
        this.estado = estado;
        this.carrito = carrito;
        this.compra = compra;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public CarritoCompra getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoCompra carrito) {
        this.carrito = carrito;
    }

    public ArrayList<CarritoItem> getCompra() {
        return compra;
    }

    public void setCompra(ArrayList<CarritoItem> compra) {
        this.compra = compra;
    }

    public LocalDate getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(LocalDate fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return carrito.totalPagar();
    }
}
