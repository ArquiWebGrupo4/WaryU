package com.example.waryu.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id_Distrito",
        "nombre"
})
public class DistritoDTO {
    private int ID_Distrito;
    private String Nombre;

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
