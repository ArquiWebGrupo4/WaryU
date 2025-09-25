package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Distrito;


import java.util.List;

public interface IDistritoService {
    public List<Distrito> list();
    public void insert(Distrito nombre);
    public void delete(int id);
    public Distrito listId(int id);
    public void update(Distrito nombre);
    public List<Object[]> DistritoPeligroso();
}
