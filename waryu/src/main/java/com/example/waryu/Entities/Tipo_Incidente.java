package com.example.waryu.Entities;

import jakarta.persistence.*;

@Entity
@Table(name="Tipo_Incidente")
public class Tipo_Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id_Tipo_Incidente;
    @Column(name="Tipo", length = 50, nullable = false)
    private String Tipo_Tipo_Incidente;

    public Tipo_Incidente() {}

    public Tipo_Incidente(int id_Tipo_Incidente, String tipo_Tipo_Incidente) {
        this.Id_Tipo_Incidente = id_Tipo_Incidente;
        this.Tipo_Tipo_Incidente = tipo_Tipo_Incidente;
    }


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
