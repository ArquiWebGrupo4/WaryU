package com.example.waryu.serviceimplements;


import com.example.waryu.entities.Distrito;
import com.example.waryu.entities.DistritoFavorito;
import com.example.waryu.repositories.IDistritoFavoritoRepository;
import com.example.waryu.serviceinterfaces.IDistritoFavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistritoFavoritoServiceImplement implements IDistritoFavoritoService {
    @Autowired
    private IDistritoFavoritoRepository dfR;
    @Override
    public List<DistritoFavorito> list() {
        return dfR.findAll();
    }

    @Override
    public void insert(DistritoFavorito favorito) {
        dfR.save(favorito);
    }

    @Override
    public void delete(int id) {
        dfR.deleteById(id);
    }


    @Override
    public DistritoFavorito listId(int id) {
        return dfR.findById(id).orElse(null);
    }

    @Override
    public void update(DistritoFavorito favorito) {
        dfR.save(favorito);
    }

    @Override
    public List<Distrito> findDistritoFavoritoByUsuario(Integer id) {
        return dfR.findDistritoFavoritoByUsuario(id);
    }
}
