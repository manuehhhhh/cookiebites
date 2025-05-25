package com.example.cookiebites;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controladorPerfiles {
    @Autowired
    private listaUsuarios lista;

    @Autowired
    public controladorPerfiles(listaUsuarios list){
        this.lista = list;
        System.out.println("creado el controlador");
    }

    @GetMapping("/perfil")
    ArrayList<Perfil> findAll(){
        System.out.println(this.lista);
        return this.lista.findAll();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("perfil/crear")
    public void agregarProducto(@RequestBody Perfil per){
        System.out.println(per.toString());
        this.lista.save(per);
    }

}
