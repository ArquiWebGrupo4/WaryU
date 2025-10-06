package com.example.waryu.dtos;

public class Reporte_CantidadxTipoIncidenteDTO {
    private String tipo;
    private int cantidad;

    public Reporte_CantidadxTipoIncidenteDTO(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
