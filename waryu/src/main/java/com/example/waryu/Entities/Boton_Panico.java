package com.example.waryu.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Boton_Panico")
public class Boton_Panico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Boton_Panico;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario ID_Usuario;
    @Column(name = "Fecha_Activacion", nullable = false)
    private LocalDate Fecha_Activacion;
    @Column(name = "Latitud", nullable = false)
    private double Lat;
    @Column(name = "Longitud", nullable = false)
    private double Lon;

    public Boton_Panico() {}
    public Boton_Panico(int ID_Boton_Panico, Usuario ID_Usuario, LocalDate fecha_Activacion, double lat, double lon) {
        this.ID_Boton_Panico = ID_Boton_Panico;
        this.ID_Usuario = ID_Usuario;
        this.Fecha_Activacion = fecha_Activacion;
        this.Lat = lat;
        this.Lon = lon;
    }

    public int getID_Boton_Panico() {
        return ID_Boton_Panico;
    }

    public void setID_Boton_Panico(int ID_Boton_Panico) {
        this.ID_Boton_Panico = ID_Boton_Panico;
    }

    public Usuario getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(Usuario ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public LocalDate getFecha_Activacion() {
        return Fecha_Activacion;
    }

    public void setFecha_Activacion(LocalDate fecha_Activacion) {
        this.Fecha_Activacion = fecha_Activacion;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        this.Lat = lat;
    }

    public double getLon() {
        return Lon;
    }

    public void setLon(double lon) {
        this.Lon = lon;
    }
}
