package com.example.waryu.Dtos;

import com.example.waryu.Entities.Nivel_Peligro;
import com.example.waryu.Entities.Tipo_Incidente;
import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.time.LocalDate;

@JsonPropertyOrder({
        "ID_Incidente",
        "usuario",
        "nivelPeligro",
        "tipo_Incidente",
        "Imagen_URL",
        "Descripcion",
        "Fecha",
        "Lat",
        "Lon"
})
public class IncidenteDTO {
    private int ID_Incidente;
    private Usuario usuario;
    private Nivel_Peligro nivelPeligro;
    private Tipo_Incidente tipoIncidente;
    private String Imagen_URL;
    private String Descripcion;
    private LocalDate Fecha;
    private BigDecimal Lat;
    private BigDecimal Lon;

    public BigDecimal getLon() {
        return Lon;
    }

    public void setLon(BigDecimal lon) {
        Lon = lon;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getID_Incidente() {
        return ID_Incidente;
    }

    public void setID_Incidente(int ID_Incidente) {
        this.ID_Incidente = ID_Incidente;
    }

    public Nivel_Peligro getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(Nivel_Peligro nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public Tipo_Incidente getTipoIncidente() {
        return tipoIncidente;
    }

    public void setTipoIncidente(Tipo_Incidente tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

    public String getImagen_URL() {
        return Imagen_URL;
    }

    public void setImagen_URL(String imagen_URL) {
        Imagen_URL = imagen_URL;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public BigDecimal getLat() {
        return Lat;
    }

    public void setLat(BigDecimal lat) {
        Lat = lat;
    }
}
