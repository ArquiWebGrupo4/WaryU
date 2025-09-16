package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Boton_Panico;

import java.util.List;

public interface IBoton_PanicoService {
    public void insert(Boton_Panico boton_Panico);
    public List<Boton_Panico> list();
}
