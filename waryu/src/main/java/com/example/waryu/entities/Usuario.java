package com.example.waryu.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Usuario;
    @Column(name = "nombreusuario", nullable = false, length = 20)
    private String nombreusuario;
    @Column(name = "NombreCompleto", nullable = false, length = 150)
    private String NombreCompleto;
    @Column(name = "Email", nullable = false, length = 40)
    private String Email;
    @Column(name = "contrasenahash", nullable = false, length = 64)
    private String contrasenahash;
    @Column(name = "Fecha_Registro", nullable = false)
    private LocalDateTime Fecha_Registro;
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

    public Usuario(int ID_Usuario, String nombreusuario, String nombreCompleto, String email, String contrasenahash, LocalDateTime fecha_Registro, String telefono, String telefono_Panico, String mensaje, Rol rol) {
        this.ID_Usuario = ID_Usuario;
        this.nombreusuario = nombreusuario;
        NombreCompleto = nombreCompleto;
        Email = email;
        this.contrasenahash = contrasenahash;
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

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getContrasenahash() {
        return contrasenahash;
    }

    public void setContrasenahash(String contrasenahash) {
        this.contrasenahash = contrasenahash;
    }

    public LocalDateTime getFecha_Registro() {
        return Fecha_Registro;
    }

    public void setFecha_Registro(LocalDateTime fecha_Registro) {
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