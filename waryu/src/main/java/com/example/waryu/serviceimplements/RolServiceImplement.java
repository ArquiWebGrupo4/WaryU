package com.example.waryu.serviceimplements;

import com.example.waryu.entities.Rol;
import com.example.waryu.repositories.IRolRepository;
import com.example.waryu.serviceinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rR;

    @Override
    public List<Rol> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Rol rol) {
        rR.save(rol);
    }

    @Override
    public void delete(int id) {
        rR.deleteById(id);
    }

    @Override
    public Rol findID(int id) {
        return rR.findById(id).orElse(null);
    }

    @Override
    public void update(Rol rol) {
        rR.save(rol);
    }
}
