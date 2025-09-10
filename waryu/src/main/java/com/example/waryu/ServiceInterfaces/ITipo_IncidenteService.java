package com.example.waryu.ServiceInterfaces;


import com.example.waryu.Entities.Tipo_Incidente;

import java.util.List;

public interface ITipo_IncidenteService {
    public List<Tipo_Incidente> list();
    public void insert(Tipo_Incidente tipo);
    public void delete(int Id);
    public Tipo_Incidente listId(int Id);
}
