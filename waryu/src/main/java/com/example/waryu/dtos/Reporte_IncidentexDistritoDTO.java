package com.example.waryu.dtos;

public class Reporte_IncidentexDistritoDTO {
    private String Distrito;
    private String nombre;
    private int Cantidad;

    public String getDistrito() {
        return Distrito;
    }

    public void setDistrito(String distrito) {
        Distrito = distrito;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}

