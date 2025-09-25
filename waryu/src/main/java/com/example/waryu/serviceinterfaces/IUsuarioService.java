package com.example.waryu.serviceinterfaces;

import com.example.waryu.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void delete(int id);
    public Usuario findID(int id);
    public void update(Usuario usuario);
    public List<String[]> UsoBotonPanicoPorUsuario();
}
