package com.example.waryu.dtos;

public class Conteo_IncidenteXTipoDTO {
    private String TipoIncidente;
    private int Cantidad;

    public String getTipoIncidente() {
        return TipoIncidente;
    }

    public void setTipoIncidente(String tipoIncidente) {
        TipoIncidente = tipoIncidente;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
}
