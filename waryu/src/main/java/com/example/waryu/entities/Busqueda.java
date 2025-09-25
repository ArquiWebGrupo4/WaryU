package com.example.waryu.entities;

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
    @Column (name = "Direccion", nullable = false, length = 100)
    private String Direccion;
    @Column (name = "Palabra_Clave", nullable = false, length = 30)
    private String Palabra_Clave;
    @Column(name = "Fecha", nullable = false)
    private LocalDateTime Fecha;

    public Busqueda() {}

    public Busqueda(int ID_Busqueda, Usuario usuario, String direccion, String palabra_Clave, LocalDateTime fecha) {
        this.ID_Busqueda = ID_Busqueda;
        this.usuario = usuario;
        Direccion = direccion;
        Palabra_Clave = palabra_Clave;
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getPalabra_Clave() {
        return Palabra_Clave;
    }

    public void setPalabra_Clave(String palabra_Clave) {
        Palabra_Clave = palabra_Clave;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }
}
