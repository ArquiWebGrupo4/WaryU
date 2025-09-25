package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Busqueda;

import java.util.List;

public interface BusquedaService {
    public List<Busqueda> list();
    public void insert(Busqueda busqueda);
    public void delete(int id);
    public Busqueda listId(int id);
    public void update(Busqueda busqueda);
}
