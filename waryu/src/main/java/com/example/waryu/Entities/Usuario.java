package com.example.waryu.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Usuario;
    @Column(name = "Nombre", nullable = false, length = 20)
    private String Nombre;
    @Column(name = "Email", nullable = false, length = 40)
    private String Email;
    @Column(name = "Contrasena_hash", nullable = false, length = 64)
    private String Contrasena_hash;
    @Column(name = "Fecha_Registro", nullable = false)
    private LocalDate Fecha_Registro;
    @Column(name = "Contacto_Emergencia", nullable = false, length = 15)
    private String Contacto_Emergencia;
    @Column(name = "Mensaje", nullable = false, length = 200)
    private String Mensaje;

    public Usuario() {}

    public Usuario(int ID_Usuario, String nombre, String email, String contrasena_hash, LocalDate fecha_Registro, String contacto_Emergencia, String mensaje) {
        this.ID_Usuario = ID_Usuario;
        Nombre = nombre;
        Email = email;
        Contrasena_hash = contrasena_hash;
        Fecha_Registro = fecha_Registro;
        Contacto_Emergencia = contacto_Emergencia;
        Mensaje = mensaje;
    }



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
