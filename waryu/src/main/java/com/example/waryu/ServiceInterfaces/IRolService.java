package com.example.waryu.ServiceInterfaces;

import com.example.waryu.Entities.Rol;
import com.example.waryu.Entities.Usuario;

import java.util.List;

public interface IRolService {
    public List<Rol> list();
    public void insert(Rol rol);
    public void delete(int id);
    public Rol findID(int id);
}
