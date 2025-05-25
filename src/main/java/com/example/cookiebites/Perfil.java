package com.example.cookiebites;

import org.springframework.stereotype.Component;
import java.lang.String;

@Component
public class Perfil {
    public String nombreUsuario;
    public String clave;
    public String rol;
    public String correo;

    public Perfil(){
    }
    public Perfil(String nombreUsuario, String Clave, String rol, String correo){
        this.nombreUsuario = nombreUsuario;
        this.clave = Clave;
        this.rol = rol;
        this.correo = correo;
    }
}
