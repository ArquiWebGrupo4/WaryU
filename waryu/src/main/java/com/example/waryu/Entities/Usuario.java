package com.example.waryu.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Usuario;
    @Column(name = "Nombre_Usuario", nullable = false, length = 20)
    private String Nombre_Usuario;
    @Column(name = "Nombre_Completo", nullable = false, length = 150)
    private String Nombre_Completo;
    @Column(name = "Email", nullable = false, length = 40)
    private String Email;
    @Column(name = "Contrasena_hash", nullable = false, length = 64)
    private String Contrasena_hash;
    @Column(name = "Fecha_Registro", nullable = false)
    private LocalDate Fecha_Registro;
    @Column(name = "Telefono", nullable = false, length = 15)
    private String Telefono;
    @Column(name = "Telefono_Panico", nullable = false, length = 15)
    private String Telefono_Panico;
    @Column(name = "Mensaje", nullable = false, length = 200)
    private String Mensaje;

    @ManyToOne
    @JoinColumn(name = "ID_Rol")
    private Rol rol;

    public Usuario() {}

    public Usuario(int ID_Usuario, String nombre_Usuario, String nombre_Completo, String email, String contrasena_hash, LocalDate fecha_Registro, String telefono, String telefono_Panico, String mensaje, Rol rol) {
        this.ID_Usuario = ID_Usuario;
        Nombre_Usuario = nombre_Usuario;
        Nombre_Completo = nombre_Completo;
        Email = email;
        Contrasena_hash = contrasena_hash;
        Fecha_Registro = fecha_Registro;
        Telefono = telefono;
        Telefono_Panico = telefono_Panico;
        Mensaje = mensaje;
        this.rol = rol;
    }

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