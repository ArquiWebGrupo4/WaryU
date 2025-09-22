package com.example.waryu.Dtos;

public class UsoBotonUsuariosDTO {
    private String nombre;
    private long UsosTotales;

    public UsoBotonUsuariosDTO() {}

    public UsoBotonUsuariosDTO(String nombre, int usosTotales) {
        this.nombre = nombre;
        UsosTotales = usosTotales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getUsosTotales() {
        return UsosTotales;
    }

    public void setUsosTotales(int usosTotales) {
        UsosTotales = usosTotales;
    }
}
