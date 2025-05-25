package Model;

import java.util.ArrayList;

public class Pedido {
    public ArrayList<Producto> listaPedido = new ArrayList<>();

    public Pedido(){};

    public ArrayList<Producto> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(ArrayList<Producto> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public ArrayList<Producto> findAll(){
        return this.listaPedido;
    }

    public void save(Producto prod){
        this.listaPedido.add(prod);
    }
}