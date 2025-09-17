package com.example.waryu.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="DistritoFavorito")
public class DistritoFavorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_DistritoFavorito;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable=false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Distrito", nullable=false)
    private Distrito distrito;

    @Column(name = "Estado", nullable=false)
    private Boolean Estado;

    public DistritoFavorito() {
    }

    public int getID_DistritoFavorito() {
        return ID_DistritoFavorito;
    }

    public void setID_DistritoFavorito(int ID_DistritoFavorito) {
        this.ID_DistritoFavorito = ID_DistritoFavorito;
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

    public Boolean getEstado() {
        return Estado;
    }

    public void setEstado(Boolean estado) {
        Estado = estado;
    }
}