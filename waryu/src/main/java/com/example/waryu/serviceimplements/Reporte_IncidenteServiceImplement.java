package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Reporte_Incidente;
import com.example.waryu.repositories.IReporte_IncidenteRepository;
import com.example.waryu.serviceinterfaces.IReporte_IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Reporte_IncidenteServiceImplement implements IReporte_IncidenteService {

    @Autowired
    private IReporte_IncidenteRepository rIR;
    @Override
    public List<Reporte_Incidente> list() {
        return rIR.findAll();
    }

    @Override
    public void insert(Reporte_Incidente reporte_incidente) {
        rIR.save(reporte_incidente);
    }

    @Override
    public void delete(int id) {
        rIR.deleteById(id);
    }

    @Override
    public Reporte_Incidente findID(int id) {
        return rIR.findById(id).orElse(null);
    }

    @Override
    public void update(Reporte_Incidente reporte) {
        rIR.save(reporte);
    }

    @Override
    public List<Reporte_Incidente> findbyIncidente(int idincidente) {
        return rIR.findbyIncidente(idincidente);
    }

    @Override
    public List<String[]> ContarPorIncidente() {
        return rIR.ContarPorIncidente();
    }

}
