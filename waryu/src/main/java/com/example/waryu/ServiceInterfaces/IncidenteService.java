package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Incidente;
import com.example.waryu.Entities.Usuario;

import java.util.List;

public interface IncidenteService {
    public List<Incidente> list();
    public void insert(Incidente incidente);
    public void delete(int id);
    public Incidente findID(int id);
}
