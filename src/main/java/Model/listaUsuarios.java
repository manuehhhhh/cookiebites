package Model;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class listaUsuarios {
    private ArrayList<Perfil> listaPerfiles = new ArrayList<Perfil>();

    @PostConstruct
    private void init(){
        System.err.println("Lista Perfil creada");
        listaPerfiles.add(new Perfil("Manuel12", "aceituna123", "cliente", "correoReal@gmail.com"));
    }

    public ArrayList<Perfil> findAll(){
        return this.listaPerfiles;
    }

    public void save(Perfil per){
        this.listaPerfiles.add(per);
    }

    public ArrayList<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(ArrayList<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }
}
