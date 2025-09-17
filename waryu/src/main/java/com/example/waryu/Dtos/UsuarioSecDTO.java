package com.example.waryu.Dtos;

import com.example.waryu.Entities.Rol;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@JsonPropertyOrder({
        "id_Usuario",
        "rol",
        "nombre_Usuario",
        "nombre_Completo",
        "fecha_Registro"
})
public class UsuarioSecDTO {
    private int ID_Usuario;
    private String Nombre_Usuario;
    private String Nombre_Completo;
    private LocalDate Fecha_Registro;
    private Rol rol;

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre_Usuario() {
        return Nombre_Usuario;
    }

    public void setNombre_Usuario(String nombre_Usuario) {
        Nombre_Usuario = nombre_Usuario;
    }

    public String getNombre_Completo() {
        return Nombre_Completo;
    }

    public void setNombre_Completo(String nombre_Completo) {
        Nombre_Completo = nombre_Completo;
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
