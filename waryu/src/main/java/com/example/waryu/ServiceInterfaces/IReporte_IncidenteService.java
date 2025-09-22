package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Reporte_Incidente;
import com.example.waryu.Entities.Rol;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReporte_IncidenteService {
    public List<Reporte_Incidente> list();
    public void insert(Reporte_Incidente reporte_incidente);
    public void delete(int id);
    public Reporte_Incidente findID(int id);
    public void update(Reporte_Incidente reporte);
    public List<Reporte_Incidente> findbyIncidente(int idincidente);
}
