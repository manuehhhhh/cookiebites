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
    private ArrayList<Perfil> lista = new ArrayList<>();

    
    public ControladorPerfiles(ListaUsuarios lista){
        this.listaUsuarios = lista;
        this.lista = this.listaUsuarios.findAll();
        System.out.println("creado el controlador");
    }

    public void crearPerfil(String nombre,String nombreUsuario, String clave, String rol, String correo) {
        Perfil nuevo = new Perfil(nombre, nombreUsuario, clave, rol, correo);
        boolean existe = false;
        for (Perfil usuario : this.lista) {
            if (usuario.nombreUsuario.equals(nuevo.nombreUsuario) || usuario.correo.equals(nuevo.correo)) {
                //EL USUARIO YA EXISTE
                existe = true;
            }
        }
        if (!existe) listaUsuarios.save(nuevo);
    }

    @GetMapping("/perfil")
    ArrayList<Perfil> findAll(){
        System.out.println(this.listaUsuarios);
        return this.listaUsuarios.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("perfil/crear")
    public void agregarProducto(@RequestBody Perfil per){
        System.out.println(per.toString());
        this.listaUsuarios.save(per);
    }

}
