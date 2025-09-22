package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Incidente;
import com.example.waryu.Entities.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IncidenteService {
    public List<Incidente> list();
    public void insert(Incidente incidente);
    public void delete(int id);
    public Incidente findID(int id);
    public void update(Incidente incidente);
    public List<Incidente> listarenfechas(LocalDateTime fecha1, LocalDateTime fecha2);
    public List<Incidente> listarendistrito(String distrito);
}
