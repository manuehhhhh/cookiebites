package com.example.cookiebites.Model;

public class Venta {
    private Pedido pedido;
    private String banco;
    private int cedula;
    private int numRef;
    private int numTelf;

    public Venta(){

    }
    
    public Venta(Pedido pedido, String banco, int cedula, int numRef, int numTelf){
        this.pedido = pedido;
        this.banco = banco;
        this.cedula = cedula;
        this.numRef = numRef;
        this.numTelf = numTelf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getNumRef() {
        return numRef;
    }

    public void setNumRef(int numRef) {
        this.numRef = numRef;
    }

    public int getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(int numTelf) {
        this.numTelf = numTelf;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

