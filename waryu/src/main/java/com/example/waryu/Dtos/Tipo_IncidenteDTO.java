package com.example.waryu.Dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id_Tipo_Incidente",
        "tipo_Tipo_Incidente"
})
public class Tipo_IncidenteDTO {
    private int Id_Tipo_Incidente;
    private String Tipo_Tipo_Incidente;

    public int getId_Tipo_Incidente() {
        return Id_Tipo_Incidente;
    }

    public void setId_Tipo_Incidente(int id_Tipo_Incidente) {
        this.Id_Tipo_Incidente = id_Tipo_Incidente;
    }

    public String getTipo_Tipo_Incidente() {
        return Tipo_Tipo_Incidente;
    }

    public void setTipo_Tipo_Incidente(String tipo_Tipo_Incidente) {
        this.Tipo_Tipo_Incidente = tipo_Tipo_Incidente;
    }
}
