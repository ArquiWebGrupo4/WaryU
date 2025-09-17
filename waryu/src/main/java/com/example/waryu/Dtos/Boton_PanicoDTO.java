package com.example.waryu.Dtos;

import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@JsonPropertyOrder({
        "id_Boton_Panico",
        "usuario",
        "fecha_Activacion",
        "lat",
        "lon"
})
public class Boton_PanicoDTO {

    private int ID_Boton_Panico;
    private Usuario Usuario;
    private LocalDateTime Fecha_Activacion;
    private double Lat;
    private double Lon;

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
