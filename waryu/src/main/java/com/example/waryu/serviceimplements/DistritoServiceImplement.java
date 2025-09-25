package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Distrito;
import com.example.waryu.repositories.IDistritoRepository;
import com.example.waryu.serviceinterfaces.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistritoServiceImplement implements IDistritoService {
    @Autowired
    private IDistritoRepository dR;
    @Override
    public List<Distrito> list() {
        return dR.findAll();
    }

    @Override
    public void insert(Distrito nombre) {
        dR.save(nombre);

    }

    @Override
    public void delete(int id) {
        dR.deleteById(id);

    }

    @Override
    public Distrito listId(int id) {
        return dR.findById(id).orElse(null);
    }

    @Override
    public void update(Distrito nombre) {
        dR.save(nombre);
    }

    @Override
    public List<Object[]> DistritoPeligroso() {
        return dR.contarIncidentesPorNivel();
    }

}
