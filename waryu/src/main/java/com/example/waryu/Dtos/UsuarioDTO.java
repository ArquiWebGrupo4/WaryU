package com.example.waryu.Dtos;

import com.example.waryu.Entities.Rol;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDate;

@JsonPropertyOrder({
        "id_Usuario",
        "nombre_Usuario",
        "nombre_Completo",
        "email",
        "contrasena_hash",
        "fecha_Registro",
        "telefono",
        "telefono_Panico",
        "mensaje",
        "rol"
})

public class UsuarioDTO {
    private int ID_Usuario;
    private String Nombre_Usuario;
    private String Nombre_Completo;
    private String Email;
    private String Contrasena_hash;
    private LocalDate Fecha_Registro;
    private String Telefono;
    private String Telefono_Panico;
    private String Mensaje;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContrasena_hash() {
        return Contrasena_hash;
    }

    public void setContrasena_hash(String contrasena_hash) {
        Contrasena_hash = contrasena_hash;
    }

    public LocalDate getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(LocalDate fecha_Registro) {
        Fecha_Registro = fecha_Registro;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getTelefono_Panico() {
        return Telefono_Panico;
    }

    public void setTelefono_Panico(String telefono_Panico) {
        Telefono_Panico = telefono_Panico;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
