package com.example.waryu.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Boton_Panico")
public class Boton_Panico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Boton_Panico;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario Usuario;
    @Column(name = "Fecha_Activacion", nullable = false)
    private LocalDateTime Fecha_Activacion;
    @Column(name = "Latitud", nullable = false)
    private double Lat;
    @Column(name = "Longitud", nullable = false)
    private double Lon;

    public Boton_Panico() {}

    public Boton_Panico(int ID_Boton_Panico, Usuario Usuario, LocalDateTime fecha_Activacion, double lat, double lon) {
        this.ID_Boton_Panico = ID_Boton_Panico;
        this.Usuario = Usuario;
        Fecha_Activacion = fecha_Activacion;
        Lat = lat;
        Lon = lon;
    }

    public int getID_Boton_Panico() {
        return ID_Boton_Panico;
    }

    public void setID_Boton_Panico(int ID_Boton_Panico) {
        this.ID_Boton_Panico = ID_Boton_Panico;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario usuario) {
        Usuario = usuario;
    }

    public LocalDateTime getFecha_Activacion() {
        return Fecha_Activacion;
    }

    public void setFecha_Activacion(LocalDateTime fecha_Activacion) {
        Fecha_Activacion = fecha_Activacion;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double lon) {
        Lon = lon;
    }
}
