package com.example.waryu.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notificacion")
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Notificacion;

    @ManyToOne
    @JoinColumn(name = "Id_Tipo_Notificacion")
    private Tipo_Notificacion tipo_Notificacion;

    @Column(name= "Mensaje", nullable = false, length = 100)
    private String Mensaje;

    @Column(name= "Fecha", nullable = false)
    private LocalDate Fecha;

    public Notificacion() {}

    public Notificacion(int ID_Notificacion, Tipo_Notificacion tipo_Notificacion, String mensaje, LocalDate fecha) {
        this.ID_Notificacion = ID_Notificacion;
        this.tipo_Notificacion = tipo_Notificacion;
        Mensaje = mensaje;
        Fecha = fecha;
    }

    public int getID_Notificacion() {
        return ID_Notificacion;
    }

    public void setID_Notificacion(int ID_Notificacion) {
        this.ID_Notificacion = ID_Notificacion;
    }

    public Tipo_Notificacion getTipo_Notificacion() {
        return tipo_Notificacion;
    }

    public void setTipo_Notificacion(Tipo_Notificacion tipo_Notificacion) {
        this.tipo_Notificacion = tipo_Notificacion;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }
}
