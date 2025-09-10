package com.waryu.nivel_peligro.serviceimplements;

import com.waryu.nivel_peligro.entities.Nivel_Peligro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.waryu.nivel_peligro.repositories.INPeligroRepository;
import com.waryu.nivel_peligro.serviceinterfaces.INPeligroService;

import java.util.List;
@Service
public class NPeligroServiceImplements implements INPeligroService {
    @Autowired
    private INPeligroRepository nPR;

    @Override
    public List<Nivel_Peligro> list() {
        return nPR.findAll();
    }

    @Override
    public void insert(Nivel_Peligro np) {
        nPR.save(np);
    }

    @Override
    public void delete(int id) {
        nPR.deleteById(id);
    }

    @Override
    public Nivel_Peligro listId(int id) {
        return nPR.findById(id).orElse(null);
    }
}
