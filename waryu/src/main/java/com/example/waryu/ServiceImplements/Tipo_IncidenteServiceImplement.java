package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Tipo_Incidente;
import com.example.waryu.Repositories.ITipo_IncidenteRepository;
import com.example.waryu.ServiceInterfaces.ITipo_IncidenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tipo_IncidenteServiceImplement implements ITipo_IncidenteService {
    @Autowired
    private ITipo_IncidenteRepository nTI;

    @Override
    public List<Tipo_Incidente> list(){
        return nTI.findAll();
    }

    @Override
    public void insert(Tipo_Incidente ti){
        nTI.save(ti);
    }
    @Override
    public void delete(int id){
        nTI.deleteById(id);
    }

    @Override
    public Tipo_Incidente listId(int Id){
        return nTI.findById(Id).orElse(null);
    }

    @Override
    public void update(Tipo_Incidente tipo) {
        nTI.save(tipo);
    }

    @Override
    public List<Tipo_Incidente> cantidadtipoincidente(String tipodesc){ return nTI.cantidadtipoincidente(tipodesc); }
}
