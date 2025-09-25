package com.example.waryu.dtos;

public class DistritoPeligrosoDTO {
    private String distrito;
    private int nivelPeligro;
    private long total;

    public DistritoPeligrosoDTO() {}

    public DistritoPeligrosoDTO(String distrito, int nivelPeligro, long total) {
        this.distrito = distrito;
        this.nivelPeligro = nivelPeligro;
        this.total = total;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
