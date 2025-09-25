package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Distrito;
import com.example.waryu.entities.DistritoFavorito;

import java.util.List;

public interface IDistritoFavoritoService {
    public List<DistritoFavorito> list();
    public void insert(DistritoFavorito favorito);
    public void delete(int id);
    public DistritoFavorito listId(int id);
    public void update(DistritoFavorito favorito);
    public List<Distrito> findDistritoFavoritoByUsuario(Integer id);//:(
}
