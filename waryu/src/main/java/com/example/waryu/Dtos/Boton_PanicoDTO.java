package com.example.waryu.Dtos;

import com.example.waryu.Entities.Usuario;
import jakarta.persistence.*;

import java.time.LocalDate;

public class Boton_PanicoDTO {

    private int ID_Boton_Panico;
    private Usuario ID_Usuario;
    private LocalDate Fecha_Activacion;
    private double Lat;
    private double Lon;

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
