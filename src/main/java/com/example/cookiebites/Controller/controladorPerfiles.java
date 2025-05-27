package com.example.cookiebites.Controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.cookiebites.Model.Perfil;
import com.example.cookiebites.Repository.ListaUsuarios;

@RestController
public class ControladorPerfiles {

    @Autowired
    private ListaUsuarios listaUsuarios;

    
    public ControladorPerfiles(ListaUsuarios lista){
        this.listaUsuarios = lista;
        System.out.println("creado el controlador");
    }

    @GetMapping("/perfil")
    ArrayList<Perfil> findAll(){
        System.out.println(this.listaUsuarios);
        return this.listaUsuarios.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("perfil/crear")
    public void agregarPerfil(@RequestBody Perfil per){
        System.out.println(per.toString());
        this.listaUsuarios.crearPerfil(per);
    }
}
