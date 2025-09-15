package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Reporte_Incidente;
import com.example.waryu.Repositories.IReporte_IncidenteRepository;
import com.example.waryu.ServiceInterfaces.IReporte_IncidenteService;
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
}
