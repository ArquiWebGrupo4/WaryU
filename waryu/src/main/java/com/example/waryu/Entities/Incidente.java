package com.example.waryu.Entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "Incidente")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Incidente;
    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "ID_Nivel")
    private Nivel_Peligro nivelPeligro;
    @ManyToOne
    @JoinColumn(name = "ID_Tipo")
    private Tipo_Incidente tipoIncidente;
    @Column (name = "Imagen_URL",nullable = false, length = 250)
    private String Imagen_URL;
    @Column (name = "Descripcion", nullable = false, length = 500)
    private String Descripcion;
    @Column (name = "Fecha",  nullable = false)
    private LocalDate Fecha;
    @Column (name = "Lat",  nullable = false,precision = 9, scale = 6)
    private BigDecimal Lat;
    @Column (name = "Lon",  nullable = false,precision = 9, scale = 6)
    private BigDecimal Lon;

    public Incidente() {}

    public Incidente(int ID_Incidente, Usuario usuario, Nivel_Peligro nivelPeligro, Tipo_Incidente tipoIncidente, String imagen_URL, String descripcion, BigDecimal lat, BigDecimal lon, LocalDate fecha) {
        this.ID_Incidente = ID_Incidente;
        this.usuario = usuario;
        this.nivelPeligro = nivelPeligro;
        this.tipoIncidente = tipoIncidente;
        Imagen_URL = imagen_URL;
        Descripcion = descripcion;
        Lat = lat;
        Lon = lon;
        Fecha = fecha;
    }

    public int getID_Incidente() {
        return ID_Incidente;
    }

    public void setID_Incidente(int ID_Incidente) {
        this.ID_Incidente = ID_Incidente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public BigDecimal getLon() {
        return Lon;
    }

    public void setLon(BigDecimal lon) {
        Lon = lon;
    }
}
