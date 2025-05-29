package com.example.cookiebites.Model;

public class Venta {
    public Pedido pedido;
    public String banco;
    public int cedula;
    public int numRef;
    public int numTelf;

    public Venta(){}
    
    public Venta(Pedido pedido, String banco, int cedula, int numRef, int numTelf){
        this.pedido = pedido;
        this.banco = banco;
        this.cedula = cedula;
        this.numRef = numRef;
        this.numTelf = numTelf;
    }

    public String generarFactura() {
        StringBuilder factura = new StringBuilder();
        factura.append("Cliente: ").append(pedido.getNombreUsuario()).append("\n");
        factura.append("Productos:\n");
        // for (CarritoItem pro : pedido.getCompra()) {
        //     factura.append("- ")
        //     .append(pro.getProducto().getNombre())
        //     .append(" x").append(pro.getCantidad())
        //     .append(" = ").append(pro.getCantidad() * pro.getProducto().getPrecio())
        //     .append("\n");
        // }
        factura.append("Total: ").append(pedido.getTotal()).append("\n");
        factura.append("Referencia de pago: ").append(numRef);
        return factura.toString();
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

