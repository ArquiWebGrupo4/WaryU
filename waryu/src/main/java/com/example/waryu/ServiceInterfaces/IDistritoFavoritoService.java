package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.DistritoFavorito;

import java.util.List;

public interface IDistritoFavoritoService {
    public List<DistritoFavorito> list();
    public void insert(DistritoFavorito favorito);
    public void delete(int id);
    public DistritoFavorito listId(int id);
    public void update(DistritoFavorito favorito);
}
