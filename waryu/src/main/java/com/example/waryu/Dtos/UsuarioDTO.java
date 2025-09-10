package com.example.waryu.Dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@JsonPropertyOrder({
        "id_Usuario",
        "email",
        "nombre",
        "mensaje",
        "fecha_Registro",
        "contacto_Emergencia",
        "contrasena_hash"
})
public class UsuarioDTO {
    private int ID_Usuario;
    private String Nombre;
    private String Email;
    private String Contrasena_hash;
    private LocalDate Fecha_Registro;
    private String Contacto_Emergencia;
    private String Mensaje;

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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

    public String getContacto_Emergencia() {
        return Contacto_Emergencia;
    }

    public void setContacto_Emergencia(String contacto_Emergencia) {
        Contacto_Emergencia = contacto_Emergencia;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
