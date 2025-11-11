package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Boton_Panico;

import java.time.LocalDateTime;
import java.util.List;

public interface IBoton_PanicoService {
    public void insert(Boton_Panico boton_Panico);
    public List<Boton_Panico> list();
    public void delete(int id);
    public Boton_Panico listId(int id);
    public void update(Boton_Panico panico);
    public List<Boton_Panico> Buscarporfechas(LocalDateTime fechaini, LocalDateTime fechafin);
    public void interact(String nombre, double latitud, double longitud);
    public void test();
}
