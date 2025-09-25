package com.example.waryu.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id_Rol",
        "nombre"
})

public class RolDTO {
    private int ID_Rol;
    private String Nombre;

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
