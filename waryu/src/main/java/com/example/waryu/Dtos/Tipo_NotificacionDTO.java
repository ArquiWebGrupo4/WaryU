package com.example.waryu.Dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({
        "Id_Tipo_Notificacion",
        "Tipo_Tipo_Notificacion"
})

public class Tipo_NotificacionDTO {
    private int Id_Tipo_Notificacion;
    private String Tipo_Tipo_Notificacion;

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
