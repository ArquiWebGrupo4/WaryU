package com.example.waryu.Dtos;

import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "ID_Busqueda",
        "usuario",
        "Descripcion",
        "Fecha"
})
public class BusquedaDTO {
    private int ID_Busqueda;
    private Usuario usuario;
    private String Descripcion;
    private LocalDateTime Fecha;

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

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
