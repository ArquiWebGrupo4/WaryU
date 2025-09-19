package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Busqueda;
import com.example.waryu.Repositories.BusquedaRepository;
import com.example.waryu.ServiceInterfaces.BusquedaService;
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
