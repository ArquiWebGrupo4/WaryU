package com.example.waryu.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Tipo_Notificacion")
public class Tipo_Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Tipo_Notificacion;
    @Column(name="Tipo", length = 50, nullable = false)
    private String Tipo_Tipo_Notificacion;

    public Tipo_Notificacion() {
    }

    public Tipo_Notificacion(int id_Tipo_Notificacion, String tipo_Tipo_Notificacion) {
        Id_Tipo_Notificacion = id_Tipo_Notificacion;
        Tipo_Tipo_Notificacion = tipo_Tipo_Notificacion;
    }

    public int getId_Tipo_Notificacion() {
        return Id_Tipo_Notificacion;
    }

    public void setId_Tipo_Notificacion(int id_Tipo_Notificacion) {
        Id_Tipo_Notificacion = id_Tipo_Notificacion;
    }

    public String getTipo_Tipo_Notificacion() {
        return Tipo_Tipo_Notificacion;
    }

    public void setTipo_Tipo_Notificacion(String tipo_Tipo_Notificacion) {
        Tipo_Tipo_Notificacion = tipo_Tipo_Notificacion;
    }
}
