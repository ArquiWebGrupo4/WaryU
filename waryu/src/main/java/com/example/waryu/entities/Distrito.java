package com.example.waryu.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Distrito;
    @Column(name ="Nombre", nullable=false, length = 30)
    private String Nombre;

    public Distrito() {
    }

    public Distrito(int ID_Distrito, String nombre) {
        this.ID_Distrito = ID_Distrito;
        Nombre = nombre;
    }

    public int getID_Distrito() {
        return ID_Distrito;
    }

    public void setID_Distrito(int ID_Distrito) {
        this.ID_Distrito = ID_Distrito;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
}
