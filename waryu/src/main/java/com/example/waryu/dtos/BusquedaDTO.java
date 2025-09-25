package com.example.waryu.dtos;

import com.example.waryu.entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id_Busqueda",
        "usuario",
        "direccion",
        "palabra_Clave",
        "fecha"
})
public class BusquedaDTO {
    private int ID_Busqueda;
    private Usuario usuario;
    private String Direccion;
    private String Palabra_Clave;
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

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }

    public String getPalabra_Clave() {
        return Palabra_Clave;
    }

    public void setPalabra_Clave(String palabra_Clave) {
        Palabra_Clave = palabra_Clave;
    }
}
