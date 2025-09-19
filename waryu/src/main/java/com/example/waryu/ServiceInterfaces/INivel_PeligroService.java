package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Nivel_Peligro;

import java.util.List;

public interface INivel_PeligroService {
    public List<Nivel_Peligro> list();
    public void insert(Nivel_Peligro nivel);
    public void delete(int id);
    public Nivel_Peligro listId(int id);
    public void update(Nivel_Peligro nivel);
}