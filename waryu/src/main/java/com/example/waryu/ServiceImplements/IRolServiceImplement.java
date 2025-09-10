package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Rol;
import com.example.waryu.Repositories.IRolRepository;
import com.example.waryu.ServiceInterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRolServiceImplement implements IRolService {
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
}
