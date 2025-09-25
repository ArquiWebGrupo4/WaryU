package com.example.waryu.dtos;

import com.example.waryu.entities.Rol;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({
        "id_Usuario",
        "rol",
        "nombreUsuario",
        "nombreCompleto",
        "email",
        "contrasena_hash",
        "fecha_Registro",
        "telefono",
        "telefono_Panico",
        "mensaje"
})

public class UsuarioDTO {
    private int ID_Usuario;
    private String NombreUsuario;
    private String NombreCompleto;
    private String Email;
    private String Contrasenahash;
    private LocalDate Fecha_Registro;
    private String Telefono;
    private String Telefono_Panico;
    private String Mensaje;
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getTelefono_Panico() {
        return Telefono_Panico;
    }

    public void setTelefono_Panico(String telefono_Panico) {
        Telefono_Panico = telefono_Panico;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public LocalDate getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(LocalDate fecha_Registro) {
        Fecha_Registro = fecha_Registro;
    }

    public String getContrasenahash() {
        return Contrasenahash;
    }

    public void setContrasenahash(String contrasenahash) {
        Contrasenahash = contrasenahash;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }
}