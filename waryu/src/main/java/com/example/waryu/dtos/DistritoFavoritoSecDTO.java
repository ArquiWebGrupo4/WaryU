package com.example.waryu.dtos;

import com.example.waryu.entities.Distrito;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id_DistritoFavorito",
        "usuario",
        "distrito",
        "estado"
})
public class DistritoFavoritoSecDTO {
    private int ID_DistritoFavorito;
    private Boolean Estado;
    private UsuarioSecDTO usuario;
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

    public UsuarioSecDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSecDTO usuario) {
        this.usuario = usuario;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
