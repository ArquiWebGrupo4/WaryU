package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Busqueda;

import java.util.List;

public interface BusquedaService {
    public List<Busqueda> list();
    public void insert(Busqueda busqueda);
    public void delete(int id);
    public Busqueda listId(int id);
    public void update(Busqueda busqueda);
}
