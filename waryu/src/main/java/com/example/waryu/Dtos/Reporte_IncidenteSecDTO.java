package com.example.waryu.Dtos;

import com.example.waryu.Entities.Incidente;
import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;

@JsonPropertyOrder({
        "id_Reporte",
        "usuario",
        "incidente",
        "descripcion",
        "fecha"
})
public class Reporte_IncidenteSecDTO {
    private int ID_Reporte;
    private UsuarioSecDTO usuario;
    private IncidenteSecDTO incidente;
    private String Descripcion;
    private LocalDateTime Fecha;

    public int getID_Reporte() {
        return ID_Reporte;
    }

    public void setID_Reporte(int ID_Reporte) {
        this.ID_Reporte = ID_Reporte;
    }

    public UsuarioSecDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSecDTO usuario) {
        this.usuario = usuario;
    }

    public IncidenteSecDTO getIncidente() {
        return incidente;
    }

    public void setIncidente(IncidenteSecDTO incidente) {
        this.incidente = incidente;
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
