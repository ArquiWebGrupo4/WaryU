package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Incidente;

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
    public List<String[]> contarIncidentesPorTipo();
    public List<String[]> contarIncidentesPorNivel();
    public List<String[]> contarIncidentePorDistrito();
    public List<Object[]> listalatlon();
}

