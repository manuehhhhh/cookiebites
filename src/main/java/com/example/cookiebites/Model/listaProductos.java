package com.example.cookiebites.Model;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;



@Repository
public class listaProductos {

    private ArrayList<Producto> listaProductos = new ArrayList<>();

    
    public  listaProductos(){
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
            ClassPathResource resource = new ClassPathResource("Productos.json");
            return new ArrayList<>(objectMapper.readValue(
                resource.getInputStream(),
                new TypeReference<ArrayList<Producto>>() {}
            ));
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>(); 
        }
    }

   /*  @PostConstruct
    public void init(){
        ArrayList<String> aux = new ArrayList<String>();
        aux.add("Harina");
        aux.add("Leche");
        aux.add("Huevo");
        aux.add("Mantequilla");
        aux.add("Azucar");
    
        listaProductos.add(new Producto("Galleta de Mantequilla", 20.99 , aux));
        System.out.println("Lista creada");
    }*/

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
