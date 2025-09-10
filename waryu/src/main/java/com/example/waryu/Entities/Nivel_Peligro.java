package com.example.waryu.Entities;
import jakarta.persistence.*;

@Entity
@Table(name = "Nivel_Peligro")
public class Nivel_Peligro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_nivel;
    @Column(name ="Nivel", nullable=false)
    private int nivel;

    public Nivel_Peligro() {}

    public Nivel_Peligro(int ID_nivel, int nivel) {
        this.ID_nivel = ID_nivel;
        this.nivel = nivel;
    }

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
