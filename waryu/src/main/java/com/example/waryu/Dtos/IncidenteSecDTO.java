package com.example.waryu.Dtos;

import com.example.waryu.Entities.Distrito;
import com.example.waryu.Entities.Nivel_Peligro;
import com.example.waryu.Entities.Tipo_Incidente;
import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id_Incidente",
        "usuario",
        "nivelPeligro",
        "tipoIncidente",
        "distrito",
        "imagen_URL",
        "descripcion",
        "fecha_creacion",
        "fecha_modificacion"
})
public class IncidenteSecDTO {
    private int ID_Incidente;
    private UsuarioSecDTO usuario;
    private Nivel_Peligro nivelPeligro;
    private Tipo_Incidente tipoIncidente;
    private Distrito distrito;
    private String Imagen_URL;
    private String Descripcion;
    private LocalDateTime Fecha_Creacion;
    private LocalDateTime Fecha_Modificacion;

    public int getID_Incidente() {
        return ID_Incidente;
    }

    public void setID_Incidente(int ID_Incidente) {
        this.ID_Incidente = ID_Incidente;
    }

    public UsuarioSecDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSecDTO usuario) {
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

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
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

    public LocalDateTime getFecha_Creacion() {
        return Fecha_Creacion;
    }

    public void setFecha_Creacion(LocalDateTime fecha_Creacion) {
        Fecha_Creacion = fecha_Creacion;
    }

    public LocalDateTime getFecha_Modificacion() {
        return Fecha_Modificacion;
    }

    public void setFecha_Modificacion(LocalDateTime fecha_Modificacion) {
        Fecha_Modificacion = fecha_Modificacion;
    }
}
