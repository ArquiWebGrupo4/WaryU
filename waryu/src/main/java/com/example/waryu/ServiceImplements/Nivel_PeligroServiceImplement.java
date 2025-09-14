package com.example.waryu.ServiceImplements;

import com.example.waryu.Entities.Nivel_Peligro;
import com.example.waryu.Repositories.INivel_PeligroRepository;
import com.example.waryu.ServiceInterfaces.INivel_PeligroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Nivel_PeligroServiceImplement implements INivel_PeligroService {
    @Autowired
    private INivel_PeligroRepository nPR;

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