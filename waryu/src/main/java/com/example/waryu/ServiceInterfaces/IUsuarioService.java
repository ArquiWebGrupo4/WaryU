package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> list();
    public void insert(Usuario usuario);
    public void delete(int id);
    public Usuario findID(int id);
    public void update(Usuario usuario);
}
