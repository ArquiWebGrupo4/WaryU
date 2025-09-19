package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Incidente;
import com.example.waryu.Repositories.IDistritoRepository;
import com.example.waryu.Repositories.IncidenteRepository;
import com.example.waryu.ServiceInterfaces.IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteServiceImplement implements IncidenteService {
    @Autowired
    private IncidenteRepository iR;
    @Override
    public List<Incidente> list() {
        return iR.findAll();
    }

    @Override
    public void insert(Incidente incidente) {
        iR.save(incidente);
    }

    @Override
    public void delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public Incidente findID(int id) {
        return iR.findById(id).orElse(null);
    }

    @Override
    public void update(Incidente incidente) {
        iR.save(incidente);
    }
}
