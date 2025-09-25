package com.example.waryu.dtos;

import com.example.waryu.entities.Rol;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@JsonPropertyOrder({
        "id_Usuario",
        "rol",
        "nombreUsuario",
        "nombreCompleto",
        "fecha_Registro"
})
public class UsuarioSecDTO {
    private int ID_Usuario;
    private String NombreUsuario;
    private String NombreCompleto;
    private LocalDate Fecha_Registro;
    private Rol rol;

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public LocalDate getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(LocalDate fecha_Registro) {
        Fecha_Registro = fecha_Registro;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
