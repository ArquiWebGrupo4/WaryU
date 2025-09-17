package com.example.waryu.Dtos;

import com.example.waryu.Entities.Tipo_Notificacion;
import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;
@JsonPropertyOrder({
        "id_Notificacion",
        "tipo_Notificacion",
        "mensaje",
        "fecha"
})
public class NotificacionDTO {
    private int ID_Notificacion;
    private Tipo_Notificacion tipo_Notificacion;
    private String mensaje;
    private LocalDate fecha;

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
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
