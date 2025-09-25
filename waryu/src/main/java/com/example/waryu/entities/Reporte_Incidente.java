package com.example.waryu.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reporte_Incidente")
public class Reporte_Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_Reporte;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_Incidente")
    private Incidente incidente;

    @Column(name = "Descripcion", nullable = false, length = 1000)
    private String Descripcion;
    @Column(name = "Fecha", nullable = false)
    private LocalDateTime Fecha;

    public Reporte_Incidente() {}
    public Reporte_Incidente(int ID_Reporte, Usuario usuario, Incidente incedente, String descripcion, LocalDateTime fecha) {
        this.ID_Reporte = ID_Reporte;
        this.usuario = usuario;
        this.incidente = incedente;
        Descripcion = descripcion;
        Fecha = fecha;
    }

    public int getID_Reporte() {
        return ID_Reporte;
    }

    public void setID_Reporte(int ID_Reporte) {
        this.ID_Reporte = ID_Reporte;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incedente) {
        this.incidente = incedente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        Fecha = fecha;
    }
}
