package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Distrito;


import java.util.List;

public interface IDistritoService {
    public List<Distrito> list();
    public void insert(Distrito nombre);
    public void delete(int id);
    public Distrito listId(int id);
    public void update(Distrito nombre);
}
