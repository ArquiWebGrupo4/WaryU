package com.example.waryu.Dtos;

import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "ID_DistritoFavorito",
        "ID_Usuario",
        "ID_Distrito",
        "Estado"
})

public class DistritoFavoritoDTO {
    private int ID_DistritoFavorito;
    private String Estado;
    private Usuario usuario;
    private Distrito distrito;

    public int getID_DistritoFavorito() {
        return ID_DistritoFavorito;
    }

    public void setID_DistritoFavorito(int ID_DistritoFavorito) {
        this.ID_DistritoFavorito = ID_DistritoFavorito;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
