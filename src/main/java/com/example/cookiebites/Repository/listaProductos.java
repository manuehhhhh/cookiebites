package com.example.cookiebites.Repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.cookiebites.Model.Perfil;
import com.example.cookiebites.Model.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;


@Repository
public class listaProductos {

    @Value("${productos.json.path}")
    private String productosJsonPath;
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    @PostConstruct
    public  void init(){
        this.listaProductos = leerProductos();
        listaProductos.forEach(galleta -> 
                System.out.println("Nombre: " + galleta.getNombre() +
                ", Precio: " + galleta.getPrecio() +
                ", Ingredientes: " + galleta.getIngredientes())
            );
    }

    public ArrayList<Producto> leerProductos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File archivo = new File(productosJsonPath);
            listaProductos = new ArrayList<>(objectMapper.readValue(
                archivo,
                new TypeReference<ArrayList<Producto>>() {}
            ));
        } catch (IOException e) {
            e.printStackTrace();
            listaProductos = new ArrayList<>();
        }
        return listaProductos;
    }

    public void actualizarProductos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File archivo = new File(productosJsonPath);
            objectMapper.writeValue(archivo, listaProductos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Producto consultaProducto(String dato) {
        Producto productoEncontrado = new Producto();
        for (Producto pro : listaProductos) {
            if (pro.nombre.equalsIgnoreCase(dato)) {
                productoEncontrado = pro;
            }
        }
        return productoEncontrado;
    }

    public ArrayList<Producto> getListaProducto() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Producto> findAll(){
        return this.listaProductos;
    }

    public void save(Producto prod){
        this.listaProductos.add(prod);
    }
}
