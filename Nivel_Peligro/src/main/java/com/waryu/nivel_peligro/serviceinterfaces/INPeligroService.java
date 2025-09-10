package com.waryu.nivel_peligro.serviceinterfaces;

import com.waryu.nivel_peligro.entities.Nivel_Peligro;

import java.util.List;

public interface INPeligroService {
    public List<Nivel_Peligro> list();
    public void insert(Nivel_Peligro nivel);
    public void delete(int id);
    public Nivel_Peligro listId(int id);
}
