package com.example.waryu.Dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "id_nivel",
        "nivel"
})
public class Nivel_PeligroDTO {
    private int ID_nivel;
    private int nivel;

    public int getID_nivel() {
        return ID_nivel;
    }

    public void setID_nivel(int ID_nivel) {
        this.ID_nivel = ID_nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
