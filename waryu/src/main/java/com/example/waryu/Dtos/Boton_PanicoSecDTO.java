package com.example.waryu.Dtos;

import com.example.waryu.Entities.Usuario;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDateTime;
@JsonPropertyOrder({
        "id_Boton_Panico",
        "usuario",
        "fecha_Activacion"
})
public class Boton_PanicoSecDTO {
    private int ID_Boton_Panico;
    private UsuarioSecDTO Usuario;
    private LocalDateTime Fecha_Activacion;

    public int getID_Boton_Panico() {
        return ID_Boton_Panico;
    }

    public void setID_Boton_Panico(int ID_Boton_Panico) {
        this.ID_Boton_Panico = ID_Boton_Panico;
    }

    public UsuarioSecDTO getUsuario() {
        return Usuario;
    }

    public void setUsuario(UsuarioSecDTO usuario) {
        Usuario = usuario;
    }

    public LocalDateTime getFecha_Activacion() {
        return Fecha_Activacion;
    }

    public void setFecha_Activacion(LocalDateTime fecha_Activacion) {
        Fecha_Activacion = fecha_Activacion;
    }
}
