package com.example.waryu.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="/DistritoFavorito")
public class DistritoFavorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_DistritoFavorito;
    @Column(name = "Estado", nullable=false, length = 20)
    private String Estado;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable=false)
    private Usuario usuario;
    @ManyToOne
    @JoinColumn
    private Distrito distrito;

    public DistritoFavorito() {
    }

    public DistritoFavorito(int ID_DistritoFavorito, String estado, Usuario usuario, Distrito distrito) {
        this.ID_DistritoFavorito = ID_DistritoFavorito;
        Estado = estado;
        this.usuario = usuario;
        this.distrito = distrito;
    }

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