package com.example.waryu.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Rol;
    @Column(name = "Nombre", nullable = false, length = 20)
    private String Nombre;

    public Rol() {
    }
    public Rol(int ID_Rol, String Nombre) {
        this.ID_Rol = ID_Rol;
        this.Nombre = Nombre;
    }

    public int getID_Rol() {
        return ID_Rol;
    }

    public void setID_Rol(int ID_Rol) {
        this.ID_Rol = ID_Rol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
