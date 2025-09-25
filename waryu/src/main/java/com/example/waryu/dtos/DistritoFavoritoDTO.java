package com.example.waryu.dtos;

import com.example.waryu.entities.Distrito;
import com.example.waryu.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "ID_DistritoFavorito",
        "ID_Usuario",
        "ID_Distrito",
        "Estado"
})

public class DistritoFavoritoDTO {
    private int ID_DistritoFavorito;
    private Boolean Estado;
    private Usuario usuario;
    private Distrito distrito;

    public int getID_DistritoFavorito() {
        return ID_DistritoFavorito;
    }

    public void setID_DistritoFavorito(int ID_DistritoFavorito) {
        this.ID_DistritoFavorito = ID_DistritoFavorito;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
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
