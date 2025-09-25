package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Busqueda;
import com.example.waryu.repositories.BusquedaRepository;
import com.example.waryu.serviceinterfaces.BusquedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusquedaServiceImplement implements BusquedaService {
    @Autowired
    private BusquedaRepository bR;
    @Override
    public List<Busqueda> list() {
        return bR.findAll();
    }

    @Override
    public void insert(Busqueda busqueda) {
        bR.save(busqueda);

    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);

    }

    @Override
    public Busqueda listId(int id) {
        return bR.findById(id).orElse(null);
    }

    @Override
    public void update(Busqueda busqueda) {
        bR.save(busqueda);
    }
}
