package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Distrito;
import com.example.waryu.Repositories.IDistritoRepository;
import com.example.waryu.ServiceInterfaces.IDistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IDistritoServiceImplement implements IDistritoService {
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
}
