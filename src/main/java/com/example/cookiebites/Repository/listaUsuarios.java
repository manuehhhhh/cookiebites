package com.example.cookiebites.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.example.cookiebites.Model.Perfil;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

@Repository
public class listaUsuarios {

    @Value("${usuarios.json.path}")
    private String usuariosJsonPath;
    private ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();

    @PostConstruct
    private void init(){
        System.err.println("Lista Perfil creada");
        Perfil p = new Perfil("Manuel","Manuel12", "aceituna123", "cliente", "correoReal@gmail.com");
        save(p);
    }

    public void agregarUsuario() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File archivo = new File(usuariosJsonPath);
            objectMapper.writeValue(archivo, listaPerfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Perfil consultaPerfil(String dato) {
        Perfil usuarioEncontrado = new Perfil();
        for (Perfil usuario : listaPerfiles) {
            if (usuario.nombreUsuario.equalsIgnoreCase(dato)) {
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }

    public ArrayList<Perfil> findAll(){
        return this.listaPerfiles;
    }

    public void save(Perfil per){
        this.listaPerfiles.add(per);
        agregarUsuario();
    }

    public ArrayList<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(ArrayList<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }
}
