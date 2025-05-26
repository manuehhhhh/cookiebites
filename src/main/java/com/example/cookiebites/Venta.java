package com.example.cookiebites;

public class Venta {
    private Pedido pedido;
    private String banco;
    private int cedula;
    private int numeroReferencia;
    private int numeroTelefonico;

    public Venta(){

    }
    
    public Venta(Pedido pedido, String banco, int cedula, int numeroReferencia, int numeroTelefonico){
        this.pedido = pedido;
        this.banco = banco;
        this.cedula = cedula;
        this.numeroReferencia = numeroReferencia;
        this.numeroTelefonico = numeroTelefonico;
    }

}
