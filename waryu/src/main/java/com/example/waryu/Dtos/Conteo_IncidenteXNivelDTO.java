package com.example.waryu.Dtos;

public class Conteo_IncidenteXNivelDTO {
    private String NivelDeIncidente;
    private int Cantidad;

    public String getNivelDeIncidente() {
        return NivelDeIncidente;
    }

    public void setNivelDeIncidente(String nivelDeIncidente) {
        NivelDeIncidente = nivelDeIncidente;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
