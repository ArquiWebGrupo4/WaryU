package com.example.waryu.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Busqueda")
public class Busqueda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Busqueda;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario usuario;
    @Column (name = "Descripcion", nullable = false, length = 100)
    private String Descripcion;
    @Column(name = "Fecha", nullable = false)
    private LocalDateTime Fecha;

    public Busqueda() {}

    public Busqueda(int ID_Busqueda, Usuario usuario, String descripcion, LocalDateTime fecha) {
        this.ID_Busqueda = ID_Busqueda;
        this.usuario = usuario;
        Descripcion = descripcion;
        Fecha = fecha;
    }

    public int getID_Busqueda() {
        return ID_Busqueda;
    }

    public void setID_Busqueda(int ID_Busqueda) {
        this.ID_Busqueda = ID_Busqueda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }
}
